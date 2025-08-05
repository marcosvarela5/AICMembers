<template>
  <div class="login-form">
    <div class="card">
      <img :src="aicLogo" alt="AIC logo" class="logo" />

      <form class="form" @submit.prevent="handleLogin">
        <label for="email">Email:
          <input id="email" type="email" v-model="form.email" @input="validateField('email')" class="input"
                 placeholder="usuario@exemplo.com" />
          <span class="error" v-if="errors.email">{{ errors.email }}</span>
        </label>

        <label for="password">Contrasinal:
          <input id="password" type="password" v-model="form.password" @input="validateField('password')" class="input"
                 placeholder="********" />
          <span class="error" v-if="errors.password">{{ errors.password }}</span>
        </label>

        <span class="error" v-if="errors.general">{{ errors.general }}</span>

        <button type="submit">Iniciar sesión</button>
      </form>
    </div>
  </div>
</template>

<script setup lang="ts">
import { reactive } from 'vue'
import axios from 'axios'
import aicLogo from '@/assets/aic.jpg'
import './LoginForm.css'
import { useRouter } from 'vue-router'
import { useAuthStore } from '@/stores/authStore' // ← aquí importas a store

const auth = useAuthStore()
const router = useRouter()

const form = reactive({
  email: '',
  password: ''
})

const errors = reactive<Record<string, string>>({
  email: '',
  password: '',
  general: ''
})

function validateField(field: string) {
  switch (field) {
    case 'email':
      errors.email = form.email.trim() === ''
          ? 'O email é obrigatorio.'
          : /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(form.email)
              ? ''
              : 'O formato do email non é válido.'
      break
    case 'password':
      errors.password = form.password.length >= 6 ? '' : 'O contrasinal debe ter 6 caracteres mínimo.'
      break
  }
  errors.general = ''
}

function validateAll(): boolean {
  Object.keys(form).forEach((key) => validateField(key))
  return Object.values(errors).every(msg => msg === '')
}

async function handleLogin() {
  if (!validateAll()) return

  try {
    const response = await axios.post('http://localhost:8080/api/auth/login', form)

    await auth.login(response.data.token)
    await router.push('/members')
    console.log('Login correcto.')
  } catch (error: any) {
    if (error.response?.status === 401) {
      errors.general = 'Credenciais incorrectas.'
    } else {
      errors.general = 'Erro no servidor. Inténtao máis tarde.'
    }
  }
}

</script>
