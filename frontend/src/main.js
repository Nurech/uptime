import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import VueAxios from 'vue-axios'
import Vuetify from 'vuetify'
import vuetify from '@/plugins/vuetify' // path to vuetify export
import 'vuetify/dist/vuetify.min.css'
import moment from 'moment';
import VueMoment from 'vue-moment';
import vueAwesomeCountdown from 'vue-awesome-countdown'
import UUID from "vue-uuid";

Vue.use(vueAwesomeCountdown, 'vac'); // Component name, `countdown` and `vac` by default
Vue.use(VueMoment, { moment });
Vue.use(Vuetify);
Vue.use(VueAxios,axios);
Vue.config.productionTip = false
Vue.use(UUID);

new Vue({
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')
// src/main.js


