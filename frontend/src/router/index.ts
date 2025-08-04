import {createRouter, createWebHistory, RouteRecordRaw} from "vue-router";
import HomeView from "../views/HomeView.vue";
import RegisterView from "../views/RegisterView.vue";
import MemberListView from '@/views/MemberListView.vue'

const routes: Array<RouteRecordRaw> = [
    {
        path: "/",
        name: "home",
        component: HomeView,
    },
    {
        path: "/register",
        name: "register",
        component: RegisterView,
    },
    {
        path: "/about",
        name: "about",
        component: () =>
            import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
    },
    {
        path: '/members',
        name: 'Members',
        component: MemberListView
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
