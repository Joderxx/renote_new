import Vue from 'vue'

import Vuetify from "vuetify/lib";

import 'font-awesome/css/font-awesome.css';
import '@/style/default.styl'
import App from './App'
import store from './store'
import router from './router'

import i18n from './lang' // Internationalizatio
import './errorLog' // error log
import './permission' // permission control
// import './mock' // simulation data
import './utils'

import * as filters from './filters' // global filters

Vue.use(Vuetify, {
  theme: {
    primary: "#ee44aa",
    secondary: "#424242",
    accent: "#82B1FF",
    error: "#FF5252",
    info: "#2196F3",
    success: "#4CAF50",
    warning: "#FFC107"
  },
  customProperties: true,
  iconfont: "fa4"
});



// register global utility filters.
Object.keys(filters).forEach(key => {
  Vue.filter(key, filters[key])
})

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  store,
  i18n,
  render: h => h(App)
})
