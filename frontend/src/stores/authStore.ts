// src/stores/authStore.ts
import { defineStore } from 'pinia'
import axios from 'axios'

export const useAuthStore = defineStore('auth', {
    state: () => ({
        token: localStorage.getItem('token') || '',
        user: localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')!) : null
    }),

    getters: {
        isAuthenticated: (state) => !!state.token,
        isAdmin: (state) => state.user?.userRole === 'ADMIN'
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
                const response = await axios.get('/api/auth/me', {
                    headers: {
                        Authorization: `Bearer ${this.token}`
                    }
                })
                this.user = response.data
                localStorage.setItem('user', JSON.stringify(response.data))
            } catch (error) {
                console.error('Erro ao obter usuario:', error)
                this.logout()
            }
        },

        logout() {
            this.token = ''
            this.user = null
            localStorage.removeItem('token')
            localStorage.removeItem('user')
        }
    }
})
