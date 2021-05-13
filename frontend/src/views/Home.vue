<template>
  <div id="app">
    <v-app>
      <template>

      </template>
      <v-content class="container align-center px-1">
        <h2 class="font-weight-light mb-2"> COSMOS ODYSSEY </h2>
        <p>Solar System Travel Deals</p>

        <v-chip class="ma-2" color="primary" x-small label text-color="white">API ID: {{ items }}</v-chip>
        <v-chip class="ma-2" color="primary" x-small label text-color="white">Price list valid until:</v-chip>

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
                        :items="items" mobile-breakpoint="800"
                        class="elevation-1"
                        inline
                        :loading="loadTable"
                        loading-text="Loading... Please wait"
          >

            <template v-slot:item.providerPrice="{ item }">
              <v-chip :color="getColor(item.providerPrice)"
                      dark> {{ item.providerPrice }}
              </v-chip>
            </template>

            <v-snackbar v-model="snackbar">{{ snackText }}
              <template v-slot:action="{ attrs }">
                <v-btn
                    color="pink"
                    text
                    v-bind="attrs"
                    @click="snackbar = false">
                  Close
                </v-btn>
              </template>
            </v-snackbar>

            <!--            crud operations-->
            <template v-slot:item.actions="{ item }">
              <div class="text-truncate">
                <v-btn
                    small
                    class="mr-2"
                    @click="showEditDialog(item)"
                    color="primary"
                >
                  Book this
                  <v-icon
                      dark
                      right>
                    mdi-checkbox-marked-circle
                  </v-icon>
                </v-btn>
              </div>
            </template>
          </v-data-table>

          <!-- this dialog is used for both create and update -->
          <v-dialog v-model="dialog" max-width="500px">
            <template v-slot:activator="{ on }">
              <div class="d-flex">
                <v-btn color="primary" dark class="ml-auto ma-3" v-on="on">
                  New
                  <v-icon small>mdi-plus-circle-outline</v-icon>
                </v-btn>
              </div>
            </template>
            <v-card>
              <v-card-title>
                <span>Make a booking {{items.id}}</span>
              </v-card-title>
              <v-card-text>
                <v-row>
                  <v-col cols="12" sm="6">
                    <v-text-field v-model="booking.firstName" label="First Name"></v-text-field>
                  </v-col>
                  <v-col cols="12" sm="6">
                    <v-text-field v-model="booking.lastName" label="Last Name"></v-text-field>
                  </v-col>
                  <v-col cols="12" sm="12">

                  </v-col>
                </v-row>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn class="error" @click="showEditDialog()">Cancel</v-btn>
                <v-btn class="primary" @click="saveBooking()">Save</v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </v-card>

        <v-divider></v-divider>

        <v-subheader>Last 30 bookings</v-subheader>
        <template>
          <v-simple-table dense
                          hover
                          :booking="bookings"
                          :loading="loadTable"
                          loading-text="Loading... Please wait"class="elevation-1">
            <template v-slot:default>
              <thead>
              <tr>
                <th class="text-left">
                  User ID
                </th>
                <th class="text-left">
                  Booking ID
                </th>
                <th class="text-left">
                  API ID
                </th>
                <th class="text-left">
                  First Name
                </th>
                <th class="text-left">
                  Last Name
                </th>
                <th class="text-left">
                  Is in last 15 price list
                </th>
              </tr>
              </thead>
              <tbody>
              <tr v-for="booking in bookings"
                  :key="booking.userIdNr">
                <td>{{ booking.userIdNr }}</td>
                <td>{{ booking.bookingId }}</td>
                <td>{{ booking.apiId }}</td>
                <td>{{ booking.firstName }}</td>
                <td>{{ booking.lastName }}</td>
                <td>{{ booking.isValidPrice }}</td>
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
import {get, post} from "axios";


const apiToken = "keyZIIVNiQPvozEWb"
const airTableApp = "appXJzFFs2zgj4X5C"
const airTableName = "Example"

export default {
  name: "Home",
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

      items: [],
      bookings: [],
      selectedHeaders: [],
      dialog: false,
      loadTable: true,
      search: '',
      snackbar: false,
      snackText: `Booked you on flight!`,
      routeTime: '',
      bookingUuid: this._uid,

      selectedValue1: '',
      selectedValue2: '',
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
    }
  },

  created() {
    this.headers = Object.values(this.headersMap);
    this.selectedHeaders = this.headers;
  },

  mounted() {
    this.loadItems()
  },

  methods: {

    filterFrom(value, search, item) {
      return value != null && search != null &&
          typeof value === 'string' &&
          value.toString().indexOf(search) !== -1
    },

    getColor(price) {
      if (price > 2500000) return 'red'
      else if (price > 100000) return 'orange'
      else return 'green'
    },

    showEditDialog(item) {
      this.saveBooking = item || {}
      this.dialog = !this.dialog
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

    saveBooking() {
      post('api/savebooking',{
        bookingId: this.bookingId
      })
          .then((response) => {
            this.loadTable = true;
            this.saveBookingResponse = response.data;
          }).catch((error) => {
        console.log(error)
      })
    },

    loadBookings() {
      get('api/bookings')
          .then((response) => {
            this.loadTable = false;
            this.bookings = response.data.map((item) => {
              return {
                userIdNr: item.userIdNr,
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