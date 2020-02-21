import Vue from "vue"
import VueRouter from "vue-router"

import Users from "../components/Users";
import Auth from "../components/Auth";

Vue.use(VueRouter);

const router = new VueRouter({
    routes: [
        {path: '/users', name: 'users', component: Users},
        {path: '/auth', name: 'auth', component: Auth}
    ]
});

export default router