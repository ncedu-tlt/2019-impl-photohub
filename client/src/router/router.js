import Vue from "vue"
import VueRouter from "vue-router"
import Authenticate from "../components/Authenticate"
import Authorization from "../components/Authorization"
import Profile from "../components/Profile"

Vue.use(VueRouter);

const router = new VueRouter({

    routes: [
        {path: '/', name: 'profile', component: Profile},
        {path: '/Authorization', name: 'Authorization', component: Authorization},
        {path: '/Authenticate', name: 'Authenticate', component: Authenticate}
    ]
       router.beforeEach((to, from, next) => {
         if (!isAuthenticated) next('/Authenticate')
         else next()
       })
})

export default router
