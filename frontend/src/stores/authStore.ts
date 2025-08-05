import { defineStore } from 'pinia'
import axios from 'axios'

export const useAuthStore = defineStore('auth', {
    state: () => ({
        token: localStorage.getItem('token') || '',
        user: null as { name: string; email: string; userRole: string } | null
    }),

    getters: {
        isAuthenticated: (state) => !!state.token
    },

    actions: {
        async login(token: string) {
            this.token = token
            localStorage.setItem('token', token)

            try {
                const response = await axios.get('/api/auth/me', {
                    headers: {
                        Authorization: `Bearer ${token}`
                    }
                })
                this.user = response.data
            } catch (error) {
                this.user = null
                console.error('Erro ao recuperar o usuario:', error)
            }
        },

        async loadUserFromToken() {
            if (!this.token) return

            try {
                const response = await axios.get('/api/auth/me', {
                    headers: {
                        Authorization: `Bearer ${this.token}`
                    }
                })
                this.user = response.data
            } catch {
                this.user = null
            }
        },

        logout() {
            this.token = ''
            this.user = null
            localStorage.removeItem('token')
        }
    }
})
