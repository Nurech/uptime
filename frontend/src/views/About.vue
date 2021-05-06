<template>
  <div class="about">
    <h1>This an test page to recieve JSON</h1>
    <br>
    <button v-on:click="pullInfo()">Pull Info</button>
    <div v-if="showResponse"><h6>{{ serverResponse }}</h6></div>
  </div>
</template>
<script>
import axios from "axios";
export default {
  name: "About",
  data: function () {

    return {
      showResponse: false,
      serverResponse: ""
    }
  },

  methods: {
    // PULL INFO
    'pullInfo': function () {
     axios.get('/api/info/')
          .then((response) => {
            this.event = response.data;
            console.log('Pulled server data ' + response.data);
            this.serverResponse = response.data
            this.showResponse = true
          }).catch((error) => {
        this.errors = error.response.data.message;
      })
    }
  }
};
</script>