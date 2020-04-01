import Vue from 'vue'
import App from './App.vue'
import Notifications from 'vue-notification'
import router from "./router/router"




Vue.config.productionTip = false;
Vue.use(Notifications);

new Vue({
  router,



  render: h => h(App),
}).$mount('#app');
