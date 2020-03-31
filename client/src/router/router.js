import Vue from "vue"
import VueRouter from "vue-router"
import Authenticate from "../components/Authenticate"
import Authorization from "../components/Authorization"
import Profile from "../components/Profile"
import Main from "../components/Main"
import ls from "local-storage"

Vue.use(VueRouter);

const router = new VueRouter({

    routes: [
        {path: '/', name: 'profile', component: Profile,meta: { requiresAuth: true }},
        {path: '/authorization', name: 'Authorization', component: Authorization},
        {path: '/authenticate', name: 'Authenticate', component: Authenticate},
        {path:'/main',name:'Main',component:Main},



    ]
})
    router.beforeEach((to, from, next) => {
      if (to.matched.some(record => record.meta.requiresAuth)) {
        const user=ls.get("photohubUser")
        if (!user) {
          next({
            path: '/authenticate',
            query: { redirect: to.fullPath }
          })
        } else {
          next()
        }
      } else {
        next()
      }
    })

export default router

