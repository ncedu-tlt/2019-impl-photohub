import Vue from 'vue'
import App from './App.vue'
import Notifications from 'vue-notification'
import router from "./router/router"




Vue.config.productionTip = false;


new Vue({
  router,
  Notifications,


  render: h => h(App),
}).$mount('#app');
