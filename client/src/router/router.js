import Vue from "vue"
import VueRouter from "vue-router"

import Users from "../components/Users";
import Auth from "../components/Auth";

Vue.use(VueRouter);

const router = new VueRouter({
    routes: [
        {path: '/Users', name: 'Users', component: Users},
        {path: '/Auth', name: 'Auth', component: Auth}
    ]
});

export default router