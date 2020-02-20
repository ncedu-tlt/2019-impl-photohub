import Vue from "vue"
import VueRouter from "vue-router"
import TestRoute1 from "../components/test/TestRoute1"
import TestRoute2 from "../components/test/TestRoute2"

Vue.use(VueRouter);

const router = new VueRouter({
    routes: [
        {path: '/test1', name: 'test1', component: TestRoute1},
        {path: '/test2', name: 'test2', component: TestRoute2}
    ]
});

export default router