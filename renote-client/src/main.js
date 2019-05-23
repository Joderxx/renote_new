import Vue from 'vue'

import './plugins/vuetify'
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
