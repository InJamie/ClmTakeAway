import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'
import Mint from 'mint-ui'
import 'mint-ui/lib/style.css'

import axios from 'axios';

Vue.config.productionTip = false
Vue.use(Mint)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
