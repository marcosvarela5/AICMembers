<template>
  <div class="register-form">
    <div class="card">
      <img src="@/assets/aic.jpg" alt="AIC logo" class="logo" />

      <form class="form" @submit.prevent="handleSubmit">
        <label for="name">Nombre:</label>
        <input id="name" v-model="form.name" required />

        <label for="surname">Apellidos:</label>
        <input id="surname" v-model="form.surname" required />

        <label for="dni">DNI:</label>
        <input id="dni" v-model="form.dni" required />

        <label for="birthDate">Fecha de nacimiento:</label>
        <input id="birthDate" type="date" v-model="form.birthDate" required />

        <label for="email">Email:</label>
        <input id="email" type="email" v-model="form.email" required />

        <label for="password">Contraseña:</label>
        <input id="password" type="password" v-model="form.password" required />

        <button type="submit">Solicitar alta</button>
      </form>
    </div>
  </div>
</template>


<script setup lang="ts">
import { reactive } from 'vue'
import './RegisterForm.css'

const form = reactive({
  name: '',
  surname: '',
  dni: '',
  birthDate: '',
  email: '',
  password: '',
  // pending fields
})

function handleSubmit() {
  console.log('Datos del formulario:', form)
  //logica de petición en progreso
}
</script>