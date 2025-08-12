// src/main.ts
import {createApp} from 'vue'
import {createPinia} from 'pinia'
import App from './App.vue'
import router from './router'
import {useAuthStore} from '@/stores/authStore'

const app = createApp(App)

app.use(createPinia())
app.use(router)


const auth = useAuthStore()
void auth.hydrate()

app.mount('#app')
