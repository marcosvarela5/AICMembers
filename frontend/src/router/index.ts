import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router"
import HomeView from "../views/HomeView.vue"
import RegisterView from "../views/RegisterView.vue"
import MemberListView from '@/views/MemberListView.vue'
import LoginView from "@/views/LoginView.vue"
import AdminPanelView from "@/views/AdminPanelView.vue"
import axios from "axios";

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
        beforeEnter: (to, from, next) => {
            const token = localStorage.getItem('token')
            if (token) {
                next('/')  // Si está logueado, no puede acceder a register
            } else {
                next()
            }
        }
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
    },
    {
        path: '/login',
        name: 'Login',
        component: LoginView,
        beforeEnter: (to, from, next) => {
            const token = localStorage.getItem('token')
            if (token) {
                next('/members')  // Ya logueado, redirigir
            } else {
                next()
            }
        }
    },
    {
        path: '/admin',
        name: 'AdminPanel',
        component: AdminPanelView,
        beforeEnter: async (to, from, next) => {
            const authorized = await isAdmin()
            next(authorized ? true : '/home')
        }
    }

]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

async function isAdmin(): Promise<boolean> {
    const token = localStorage.getItem('token')
    if (!token) return false

    try {
        const response = await axios.get('/api/auth/me', {
            headers: { Authorization: `Bearer ${token}` }
        })
        return response.data.userRole === 'ADMIN'
    } catch (error) {
        return false
    }
}


export default router
