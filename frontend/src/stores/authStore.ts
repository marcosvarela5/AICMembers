import {defineStore} from 'pinia'
import {api} from '@/services/api'

export const useAuthStore = defineStore('auth', {
    state: () => ({
        token: localStorage.getItem('token') || '',
        user: (() => {
            try {
                return localStorage.getItem('user')
                    ? JSON.parse(localStorage.getItem('user')!)
                    : null
            } catch {
                return null
            }
        })()
    }),

    getters: {
        isAuthenticated: (s) => !!s.token,
        isAdmin: (s) => s.user?.userRole === 'ADMIN'
    },

    actions: {
        async login(token: string) {
            this.token = token
            localStorage.setItem('token', token)
            await this.loadUserFromToken()
        },

        async loadUserFromToken() {
            if (!this.token) return
            try {
                const {data} = await api.get('/auth/me')
                this.user = data
                localStorage.setItem('user', JSON.stringify(data))
            } catch (e) {
                console.error('Erro ao obter usuario:', e)
                this.logout()
            }
        },

        async hydrate() {
            if (this.token) await this.loadUserFromToken()
        },

        logout() {
            this.token = ''
            this.user = null
            localStorage.removeItem('token')
            localStorage.removeItem('user')
            delete api.defaults.headers.common.Authorization
        }
    }
})
