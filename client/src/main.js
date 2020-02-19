import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import SignIn from './pages/SignIn'
import Users from './components/Users'


Vue.config.productionTip = false
Vue.use(VueRouter)
const router = new VueRouter({
  routes: [
    { path: 'pages/SigIn', component: SignIn },
    { path: '/Users', component: Users },
    { path: '/', redirect: '/SignIn' }
  ]
})
new Vue({
    router,
  render: h => h(App),
}).$mount('#app')
