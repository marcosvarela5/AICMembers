<template>
  <div class="register-form">
    <div class="card">
      <img src="@/assets/aic.jpg" alt="AIC logo" class="logo" />

      <form class="form" @submit.prevent="handleSubmit">
        <!-- Datos personales -->
        <label for="name">Nombre:</label>
        <input id="name" v-model="form.name" @input="validateField('name')" />
        <span class="error" v-if="errors.name">{{ errors.name }}</span>

        <label for="surname">Apellidos:</label>
        <input id="surname" v-model="form.surname" @input="validateField('surname')" />
        <span class="error" v-if="errors.surname">{{ errors.surname }}</span>

        <label for="dni">DNI:</label>
        <input id="dni" v-model="form.dni" @input="validateField('dni')" />
        <span class="error" v-if="errors.dni">{{ errors.dni }}</span>

        <label for="birthDate">Fecha de nacimiento:</label>
        <input id="birthDate" type="date" v-model="form.birthDate" @input="validateField('birthDate')" />
        <span class="error" v-if="errors.birthDate">{{ errors.birthDate }}</span>

        <!-- Dirección -->
        <label for="address">Dirección:</label>
        <input id="address" v-model="form.address" @input="validateField('address')" />
        <span class="error" v-if="errors.address">{{ errors.address }}</span>

        <label for="zipCode">Código Postal:</label>
        <input id="zipCode" v-model="form.zipCode" @input="validateField('zipCode')" />
        <span class="error" v-if="errors.zipCode">{{ errors.zipCode }}</span>

        <label for="town">Localidad:</label>
        <input id="town" v-model="form.town" @input="validateField('town')" />
        <span class="error" v-if="errors.town">{{ errors.town }}</span>

        <label for="province">Provincia:</label>
        <input id="province" v-model="form.province" @input="validateField('province')" />
        <span class="error" v-if="errors.province">{{ errors.province }}</span>

        <!-- Contacto -->
        <label for="telephone">Teléfono:</label>
        <input id="telephone" v-model="form.telephone" @input="validateField('telephone')" />
        <span class="error" v-if="errors.telephone">{{ errors.telephone }}</span>

        <label for="mobilePhone">Teléfono móvil:</label>
        <input id="mobilePhone" v-model="form.mobilePhone" @input="validateField('mobilePhone')" />
        <span class="error" v-if="errors.mobilePhone">{{ errors.mobilePhone }}</span>

        <!-- Login -->
        <label for="email">Email:</label>
        <input id="email" type="email" v-model="form.email" @input="validateField('email')" />
        <span class="error" v-if="errors.email">{{ errors.email }}</span>

        <label for="password">Contraseña:</label>
        <input id="password" type="password" v-model="form.password" @input="validateField('password')" />
        <span class="error" v-if="errors.password">{{ errors.password }}</span>

        <!-- Datos bancarios -->
        <label for="bankName">Entidad bancaria:</label>
        <input id="bankName" v-model="form.bankName" @input="validateField('bankName')" />
        <span class="error" v-if="errors.bankName">{{ errors.bankName }}</span>

        <label for="iban">IBAN:</label>
        <input id="iban" v-model="form.iban" @input="validateField('iban')" />
        <span class="error" v-if="errors.iban">{{ errors.iban }}</span>

        <!-- Consentimientos -->
        <label>
          <input type="checkbox" v-model="form.receivesNotifications" />
          Deseo recibir notificaciones
        </label>
        <span class="error" v-if="errors.receivesNotifications">{{ errors.receivesNotifications }}</span>

        <label>
          <input type="checkbox" v-model="form.imageConsent" />
          Consiento el uso de imágenes
        </label>
        <span class="error" v-if="errors.imageConsent">{{ errors.imageConsent }}</span>

        <label>
          <input type="checkbox" v-model="form.acceptPayments" />
          Acepto pagos por domiciliación
        </label>
        <span class="error" v-if="errors.acceptPayments">{{ errors.acceptPayments }}</span>

        <button type="submit">Solicitar alta</button>
      </form>
    </div>
  </div>
</template>

<script setup lang="ts">
import axios from 'axios'
import { reactive } from 'vue'
import './RegisterForm.css'

const form = reactive({
  name: '',
  surname: '',
  dni: '',
  birthDate: '',
  address: '',
  zipCode: '',
  town: '',
  province: '',
  telephone: '',
  mobilePhone: '',
  email: '',
  password: '',
  bankName: '',
  iban: '',
  receivesNotifications: false,
  imageConsent: false,
  acceptPayments: false
})

const errors = reactive<Record<string, string>>({})

function validateField(field: string) {
  switch (field) {
    case 'name':
      errors.name = form.name.trim() ? '' : 'El nombre es obligatorio.'
      break
    case 'surname':
      errors.surname = form.surname.trim() ? '' : 'Los apellidos son obligatorios.'
      break
    case 'dni':
      errors.dni = form.dni.trim() ? '' : 'El DNI es obligatorio.'
      break
    case 'birthDate':
      errors.birthDate = form.birthDate ? '' : 'La fecha de nacimiento es obligatoria.'
      break
    case 'address':
      errors.address = form.address.trim() ? '' : 'La dirección es obligatoria.'
      break
    case 'zipCode':
      errors.zipCode = form.zipCode.trim() ? '' : 'El código postal es obligatorio.'
      break
    case 'town':
      errors.town = form.town.trim() ? '' : 'La localidad es obligatoria.'
      break
    case 'province':
      errors.province = form.province.trim() ? '' : 'La provincia es obligatoria.'
      break
    case 'telephone':
      errors.telephone = /^[0-9]+$/.test(form.telephone) ? '' : 'El teléfono debe ser numérico.'
      break
    case 'mobilePhone':
      errors.mobilePhone = /^[0-9]+$/.test(form.mobilePhone) ? '' : 'El móvil debe ser numérico.'
      break
    case 'email':
      errors.email = /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(form.email) ? '' : 'El email no es válido.'
      break
    case 'password':
      errors.password = form.password.length >= 6 ? '' : 'La contraseña debe tener al menos 6 caracteres.'
      break
    case 'bankName':
      errors.bankName = form.bankName.trim() ? '' : 'El banco es obligatorio.'
      break
    case 'iban':
      errors.iban = /^[A-Z]{2}[0-9]{2}[A-Z0-9]{1,30}$/.test(form.iban) ? '' : 'El IBAN no es válido.'
      break
  }
}

function validateAll(): boolean {
  Object.keys(form).forEach((key) => validateField(key))
  if (!form.receivesNotifications) errors.receivesNotifications = 'Este campo es obligatorio.'
  if (!form.imageConsent) errors.imageConsent = 'Este campo es obligatorio.'
  if (!form.acceptPayments) errors.acceptPayments = 'Este campo es obligatorio.'
  return Object.values(errors).every(msg => msg === '')
}

async function handleSubmit() {
  if (!validateAll()) {
    alert('Hay errores en el formulario.')
    return
  }

  try {
    const response = await axios.post('http://localhost:8080/api/auth/register', form)
    alert('¡Registro completado con éxito!')

    // Limpiar el formulario
    Object.assign(form, {
      name: '',
      surname: '',
      dni: '',
      birthDate: '',
      address: '',
      zipCode: '',
      town: '',
      province: '',
      telephone: '',
      mobilePhone: '',
      email: '',
      password: '',
      bankName: '',
      iban: '',
      receivesNotifications: false,
      imageConsent: false,
      acceptPayments: false
    })
  } catch (error) {
    console.error('Error al registrar:', error)
    alert('Ha ocurrido un error al registrar. Revisa los datos.')
  }
}
</script>