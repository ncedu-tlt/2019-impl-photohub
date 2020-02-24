import Vue from "vue"
import VueRouter from "vue-router"
import Authenticate from "../components/Authenticate"
import Authorization from "../components/Authorization"
import Profile from "../components/Profile"

Vue.use(VueRouter);

const router = new VueRouter({
    routes: [
        {path: '/Authorization', name: 'Authorization', component: Authorization},
        {path: '/Profile', name: 'profile', component: Profile},
        {path: '/', name: 'Authenticate', component: Authenticate}
    ]
})

export default router
