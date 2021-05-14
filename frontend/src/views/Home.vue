<template>
  <div id="app">
    <v-app>
      <v-content class="container align-center px-1">
        <h2 class="font-weight-light mb-2"> COSMOS ODYSSEY </h2>
        <p>Solar System Travel Deals</p>

        <v-chip class="ma-2" color="primary" x-small label text-color="white">API ID: {{ items[0].id }}</v-chip>

        <v-chip class="ma-2" color="primary" x-small label text-color="white">
          Price list valid until: {{ items[0].validUntil | moment("MM-DD-yyyy HH:mm") }}
        </v-chip>

        <v-chip class="ma-2" color="primary" x-small label text-color="white">
          Current server time: {{ new Date() | moment("MM-DD-yyyy HH:mm") }}
        </v-chip>

        <v-chip class="ma-2" color="primary" x-small label text-color="white">
          <countdown :end-time="items[0].validUntil">
            <template
                v-slot:process="anyYouWantedScopName">
              <span>{{ `Next update in: ${anyYouWantedScopName.timeObj.ceil.s} seconds` }}</span>
            </template>
            <template
                v-slot:finish>
              <span>Done!</span>
            </template>
          </countdown>
        </v-chip>


        <v-card>
          <v-card-title>
            All Flights
            <v-spacer></v-spacer>
            <div>
              <v-select v-model="selectedHeaders" :items="headers" label="Select Columns" multiple outlined
                        return-object>
                <template v-slot:selection="{ item, index }">
                  <v-chip v-if="index < 5">
                    <span>{{ item.text }}</span>
                  </v-chip>
                  <span v-if="index === 5" class="grey--text caption">(+{{ selectedHeaders.length - 2 }} others)</span>
                </template>
              </v-select>
            </div>
          </v-card-title>

          <v-data-table :headers="showHeaders"
                        dense
                        hover
                        :items="items"
                        mobile-breakpoint="800"
                        class="elevation-3"
                        inline
                        :loading="loadTable"
                        loading-text="Loading... Please wait">

            <template v-slot:item.providerPrice="{ item }">
              <v-chip :color="getColor(item.providerPrice)"
                      dark> {{ item.providerPrice }}
              </v-chip>
            </template>

            <template v-slot:item.actions="{ item }">
              <div class="text-truncate">
                <v-btn small
                       class="mr-2"
                       @click="showEditDialog(item)"
                       color="success">BOOK THIS
                </v-btn>
              </div>
            </template>
          </v-data-table>

          <v-dialog v-model="dialog" max-width="500px">
            <v-card>

              <v-card-title><span>Booking a flight</span></v-card-title>

              <validation-observer ref="observer" v-slot="{ invalid }">
              <form @submit.prevent="submit">
                <v-card-text>

                  <v-row>


                    <v-col cols="12" sm="6">
                        <validation-provider v-slot="{ errors }" name="First Name" rules="required|max:10">
                          <v-text-field v-model="firstName" :counter="10" :error-messages="errors" label="First Name" required></v-text-field>
                        </validation-provider>
                    </v-col>

                    <v-col cols="12" sm="6">
                        <validation-provider v-slot="{ errors }" name="Last Name" rules="required|max:10">
                          <v-text-field v-model="lastName" :counter="10" :error-messages="errors" label="Last Name" required></v-text-field>
                        </validation-provider>
                    </v-col>



                    <v-col cols="12" sm="6">
                      <v-text-field
                          :value="Math.floor((new Date(editedItem.providerFlightStart) - new Date(editedItem.providerFlightEnd)) / (1000*60*-1))+' minutes'"
                          label="Travel time is" disabled></v-text-field>
                    </v-col>

                    <v-col cols="12" sm="6">
                      <v-text-field :value="editedItem.providerPrice+'$'" label="Travel price is"
                                    disabled></v-text-field>
                    </v-col>

                    <v-col cols="12" sm="12">
                      <v-text-field :value="generatedId" label="Booking ID" disabled></v-text-field>
                    </v-col>

                    <v-col cols="12" sm="12">
                      <v-text-field :value="editedItem.id" label="Flight ID" disabled></v-text-field>
                    </v-col>

                  </v-row>
                </v-card-text>

                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-chip class="ma-2" color="alert" x-small label text-color="black">Not saving empty fields</v-chip>
                  <v-btn class="mr-4" type="submit" text-color="black" :disabled="invalid" @click="saveItem(editedItem); clear">submit</v-btn>
                </v-card-actions>
              </form>
              </validation-observer>
            </v-card>
          </v-dialog>
        </v-card>


        <v-divider></v-divider>
        <v-subheader>Last 10 bookings</v-subheader>
        <template>
          <v-simple-table  dense :loading="loadTable1" loading-text="Loading... Please wait">
            <template v-slot:default>
              <thead>
              <tr>
                <th class="text-left">First Name</th>
                <th class="text-left">Last Name</th>
                <th class="text-left">On valid price list?</th>
                <th class="text-left">Booking ID</th>
                <th class="text-left">API ID</th>
              </tr>
              </thead>

              <tbody>
              <tr v-for="item in bookings.slice().reverse()" :key="item.name">
                <td >{{ item.firstName }}</td>
                <td>{{ item.lastName }}</td>
                <td>{{ item.isValidPrice }}</td>
                <td>{{ item.bookingId }}</td>
                <td>{{ item.apiId }}</td>
              </tr>
              </tbody>

            </template>
          </v-simple-table>
        </template>
      </v-content>
    </v-app>
  </div>
</template>

<script>
import axios, {get, post} from "axios";
import {uuid} from 'vue-uuid';
const compiler = require('vue-template-compiler')
import moment from 'moment'
const apiToken = "keyZIIVNiQPvozEWb"
const airTableApp = "appXJzFFs2zgj4X5C"
const airTableName = "Example"
import {required, digits, email, max, regex} from 'vee-validate/dist/rules'
import {extend, ValidationObserver, ValidationProvider, setInteractionMode} from 'vee-validate'

setInteractionMode('eager')

extend('digits', {
  ...digits,
  message: '{_field_} needs to be {length} digits. ({_value_})',
})

extend('required', {
  ...required,
  message: '{_field_} can not be empty',
})

extend('max', {
  ...max,
  message: '{_field_} may not be greater than {length} characters',
})

export default {
  components: {
    ValidationProvider,
    ValidationObserver,
  },
  data() {
    return {
      headers: [
        {text: 'Action', value: 'actions', sortable: false},
        {text: 'Route From Name', value: 'routeFromName'},
        {text: 'Route To Name', value: 'routeToName'},
        {text: 'Route Distance', value: 'routeDistance'},
        {text: 'Provider Price', value: 'providerPrice'},
        {text: 'Provider Flight Start', value: 'providerFlightStart'},
        {text: 'Provider Flight End', value: 'providerFlightEnd'},
        {text: 'Provider Name', value: 'providerCompanyName'},
      ],

      headersMap: {
        action: {text: 'Action', value: 'actions', sortable: false},
        routeFromName: {text: 'From', value: 'routeFromName'},
        routeToName: {text: 'Where', value: 'routeToName'},
        routeDistance: {text: 'Distance (km)', value: 'routeDistance'},
        providerPrice: {text: 'Price ($)', value: 'providerPrice'},
        providerFlightStart: {text: 'Leaves (date)', value: 'providerFlightStart'},
        providerFlightEnd: {text: 'Arrives (date)', value: 'providerFlightEnd'},
        providerCompanyName: {text: 'Provider Name', value: 'providerCompanyName'}
      },

      booking: {},
      travelTime: '',
      updateApiTime: '',
      bookings: [],
      bookingForm: {},
      editedItem: {},
      generatedId: '',
      items: [],
      serverTime: '',
      selectedHeaders: [],
      dialog: false,
      loadTable: true,
      loadTable1: true,
      search: '',
      routeTime: '',
      timer: '',
      firstName: '',
      lastName: '',
      select: null,
      bookingIdGenerated: this.bookingIdGenerated,
      selectedValue1: '',
      selectedValue2: '',
      sortDesc: true,
      uuid: uuid.v1(),
      v1: this.$uuid.v1(),
      v4: this.$uuid.v4(),

      // All the options that could be rendered.
      // Selected value from Select1 must exist as a key in the options array
      options: {
        'Earth': [
          {'display': 'Jupiter', 'value': 'Jupiter'},
          {'display': 'Uranus', 'value': 'Uranus'}
        ],
        'Venus': [
          {'display': 'Earth', 'value': 'Earth'},
          {'display': 'Mercury', 'value': 'Mercury'}
        ],
        'Mercury': [
          {'display': 'Venus', 'value': 'Venus'},
        ],
        'Mars': [
          {'display': 'Earth', 'value': 'Earth'},
        ],
        'Jupiter': [
          {'display': 'Earth', 'value': 'Earth'},
        ],
        'Saturn': [
          {'display': 'Neptune', 'value': 'Neptune'},
          {'display': 'Earth', 'value': 'Earth'},
        ],
        'Uranus': [
          {'display': 'Saturn', 'value': 'Saturn'},
          {'display': 'Neptune', 'value': 'Neptune'},
        ],
        'Neptune': [
          {'display': 'Mercury', 'value': 'Mercury'},
          {'display': 'Saturn', 'value': 'Saturn'},
        ]
      }
    }
  },

  watch: {
    // Reset second value if first one changed
    selectedValue1: function (oldVal, newVal) {
      if (oldVal !== newVal) {
        this.selectedValue2 = ''
      }
    }
  },

  computed: {
    //Done to get the ordered headers
    showHeaders() {
      return this.headers.filter(s => this.selectedHeaders.includes(s));
    },

    clear() {
      this.firstName = ''
      this.lastName = ''
      this.$refs.observer.reset()
    },
  },

  created() {
    this.headers = Object.values(this.headersMap);
    this.selectedHeaders = this.headers;
  },

  mounted() {
    this.loadItems(),
        this.loadBookings(),
        this.bookingIdGenerated = uuid.v1
  },

  methods: {

    toggleOrder() {
      this.sortDesc = !this.sortDesc
    },

    nextSort() {
      let index = this.headers.findIndex(h => h.value === this.sortBy)
      index = (index + 1) % this.headers.length
      this.sortBy = this.headers[index].value
    },

    showEditDialog(item) {
      this.editedItem = item || {}
      this.dialog = !this.dialog
      this.generatedId = this.$uuid.v4();
    },

    cancelAutoUpdate() {
      clearInterval(this.timer);
    },

    beforeDestroy() {
      this.cancelAutoUpdate();
    },

    filterFrom(value, search, item) {
      return value != null && search != null &&
          typeof value === 'string' &&
          value.toString().indexOf(search) !== -1
    },

    getColor(price) {
      if (price > 2200000) return 'red'
      else if (price > 100000) return 'orange'
      else return 'green'
    },

    loadItems() {
      get('api/serverinfo')
          .then((response) => {
            this.loadTable = false;
            this.apiValidUntil = response.data.apiValidUntil;
            this.nextUpdateAt = response.data.nextUpdateAt;
            this.items = response.data.map((item) => {
              return {
                id: item.id,
                validUntil: item.validUntil,
                legsId: item.legsId,
                routeId: item.routeId,
                routeFromId: item.routeFromId,
                routeFromName: item.routeFromName,
                routeToId: item.routeToId,
                routeToName: item.routeToName,
                routeDistance: item.routeDistance,
                providerId: item.providerId,
                providerPrice: item.providerPrice,
                providerFlightStart: item.providerFlightStart,
                providerFlightEnd: item.providerFlightEnd,
                providerCompanyId: item.providerCompanyId,
                providerCompanyName: item.providerCompanyName
              }
            })
          }).catch((error) => {
        console.log(error)
      })
    },


    saveItem(item) {
      let method = "post"
      let url = `api/savebooking`
      let id = item.id
      let data = {
        apiId: item.id,
        firstName: this.firstName,
        lastName: this.lastName,
        bookingId: this.generatedId
      }
      // save the booking
      post(url,
          data,
          {
            headers: {
              Authorization: "Bearer " + apiToken,
              "Content-Type": "application/json"
            }
          }).then((response) => {
        if (response.data && response.data.id) {
          console.log(response.data)
          // add new item to state
          this.editedItem.id = response.data.id
          if (!id) {
            // add the new item to items state
            this.items.push(this.editedItem)
          }
          this.editedItem = {}
        }
        this.dialog = !this.dialog
      })
    },

    loadBookings() {
      get('api/bookings')
          .then((response) => {
            this.loadTable1 = false;
            this.bookings = response.data.map((item) => {
              return {
                userId: item.userId,
                bookingId: item.bookingId,
                apiId: item.apiId,
                firstName: item.firstName,
                lastName: item.lastName,
                isValidPrice: item.isValidPrice,
              }
            })
          }).catch((error) => {
        console.log(error)
      })
    },
  }
}
</script>