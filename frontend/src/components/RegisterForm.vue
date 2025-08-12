<template>
  <div class="register-form">
    <div class="card">
      <img :src="aicLogo" alt="AIC logo" class="logo"/>

      <form class="form" @submit.prevent="handleSubmit">
        <div class="form-grid">
          <!-- Datos persoais -->
          <div class="section">
            <label for="name">Nome:
              <input id="name" type="text" v-model="form.name" @input="validateField('name')" class="input"
                     placeholder="Escribe o teu nome"/>
              <span class="error" v-if="errors.name">{{ errors.name }}</span>
            </label>

            <label for="surname">Apelidos:
              <input id="surname" type="text" v-model="form.surname" @input="validateField('surname')" class="input"
                     placeholder="Escribe os teus apelidos"/>
              <span class="error" v-if="errors.surname">{{ errors.surname }}</span>
            </label>

            <label for="dni">DNI:
              <input id="dni" type="text" v-model="form.dni" @input="validateField('dni')" class="input"
                     placeholder="12345678X"/>
              <span class="error" v-if="errors.dni">{{ errors.dni }}</span>
            </label>

            <label for="birthDate">Data de nacemento:
              <input id="birthDate" type="date" v-model="form.birthDate" @input="validateField('birthDate')"
                     class="input"/>
              <span class="error" v-if="errors.birthDate">{{ errors.birthDate }}</span>
            </label>
          </div>

          <!-- Dirección -->
          <div class="section">
            <label for="address">Enderezo:
              <input id="address" type="text" v-model="form.address" @input="validateField('address')" class="input"
                     placeholder="Rúa, avenida, etc."/>
              <span class="error" v-if="errors.address">{{ errors.address }}</span>
            </label>

            <label for="zipCode">Código Postal:
              <input id="zipCode" type="text" v-model="form.zipCode" @input="validateField('zipCode')" class="input"
                     placeholder="XXXXX"/>
              <span class="error" v-if="errors.zipCode">{{ errors.zipCode }}</span>
            </label>

            <label for="town">Localidade:
              <input id="town" type="text" v-model="form.town" @input="validateField('town')" class="input"
                     placeholder="Cidade ou vila"/>
              <span class="error" v-if="errors.town">{{ errors.town }}</span>
            </label>

            <label for="province">Provincia:
              <input id="province" type="text" v-model="form.province" @input="validateField('province')" class="input"
                     placeholder="Provincia"/>
              <span class="error" v-if="errors.province">{{ errors.province }}</span>
            </label>
          </div>

          <!-- Contacto -->
          <div class="section">
            <label for="telephone">Teléfono:
              <input id="telephone" type="tel" v-model="form.telephone" @input="validateField('telephone')"
                     class="input" placeholder="Número fixo"/>
              <span class="error" v-if="errors.telephone">{{ errors.telephone }}</span>
            </label>

            <label for="mobilePhone">Teléfono móbil:
              <input id="mobilePhone" type="tel" v-model="form.mobilePhone" @input="validateField('mobilePhone')"
                     class="input" placeholder="Número móbil"/>
              <span class="error" v-if="errors.mobilePhone">{{ errors.mobilePhone }}</span>
            </label>
          </div>

          <!-- Login -->
          <div class="section">
            <label for="email">Email:
              <input id="email" type="email" v-model="form.email" @input="validateField('email')" class="input"
                     placeholder="usuario@exemplo.com"/>
              <span class="error" v-if="errors.email">{{ errors.email }}</span>
            </label>

            <label for="password">Contrasinal:
              <input id="password" type="password" v-model="form.password" @input="validateField('password')"
                     class="input" placeholder="********"/>
              <span class="error" v-if="errors.password">{{ errors.password }}</span>
            </label>
          </div>

          <!-- Datos bancarios -->
          <div class="section">
            <label for="bankName">Entidade bancaria:
              <input id="bankName" type="text" v-model="form.bankName" @input="validateField('bankName')" class="input"
                     placeholder="Nome do banco"/>
              <span class="error" v-if="errors.bankName">{{ errors.bankName }}</span>
            </label>

            <label for="iban">IBAN:
              <input id="iban" type="text" v-model="form.iban" @input="validateField('iban')" class="input"
                     placeholder="ES00 0000 0000 0000 0000 0000"/>
              <span class="error" v-if="errors.iban">{{ errors.iban }}</span>
            </label>
          </div>

          <!-- Consentimientos -->
          <div class="section section-consent">
            <label class="checkbox-label">
              <input type="checkbox" v-model="form.receivesNotifications"/>
              <span>Desexo recibir notificacions via telemática, de eventos relacionados coa agrupación</span>
            </label>
            <span class="error" v-if="errors.receivesNotifications">{{ errors.receivesNotifications }}</span>

            <label class="checkbox-label">
              <input type="checkbox" v-model="form.imageConsent"/>
              <span>Consinto publicación de imáxes, en eventos da agrupación, nas redes sociais e na web</span>
            </label>
            <span class="error" v-if="errors.imageConsent">{{ errors.imageConsent }}</span>

            <label class="checkbox-label">
              <input type="checkbox" v-model="form.acceptPayments"/>
              <span>Acepto sexa cargada na miña conta bancaria, a cuota anual de socio de <strong>30 €</strong></span>
            </label>
            <span class="error" v-if="errors.acceptPayments">{{ errors.acceptPayments }}</span>
          </div>
        </div>

        <p class="legal-text">
          No cumprimento do disposto no artigo 5 da Ley orgánica 15/1999, de 13 de setembro, de protección de
          datos de carácter persoal, infórmase que os datos persoais recollidos neste documento incorporaranse a
          un ficheiro para o seu tratamento. Vostede pode exercer os dereitos de acceso, rectificación, cancelación e
          oposición previstos na lei mediante un escrito dirixido á Agrupación Instructiva de Caamouco.
        </p>

        <button type="submit">Solicitar alta</button>
      </form>
    </div>
  </div>
</template>


<script setup lang="ts">
import {api} from '@/services/api';
import {reactive} from 'vue'
import './RegisterForm.css'
import aicLogo from '@/assets/aic.jpg'

const form = reactive({
  name: '', surname: '', dni: '', birthDate: '',
  address: '', zipCode: '', town: '', province: '',
  telephone: '', mobilePhone: '', email: '', password: '',
  bankName: '', iban: '',
  receivesNotifications: false, imageConsent: false, acceptPayments: false
})

const errors = reactive<Record<string, string>>({})

function validateField(field: string) {
  switch (field) {
    case 'name':
      errors.name = form.name.trim() ? '' : 'O nome é obrigatorio.';
      break
    case 'surname':
      errors.surname = form.surname.trim() ? '' : 'Os apelidos son obrigatorios.';
      break
    case 'dni':
      errors.dni = form.dni.trim() ? '' : 'O DNI é obrigatorio.';
      break
    case 'birthDate':
      errors.birthDate = form.birthDate ? '' : 'A data de nacemento é obrigatoria.';
      break
    case 'address':
      errors.address = form.address === '' ? 'O enderezo é obrigatorio.' : '';
      break
    case 'zipCode':
      errors.zipCode = form.zipCode.trim() ? '' : 'O código postal é obrigatorio.';
      break
    case 'town':
      errors.town = form.town.trim() ? '' : 'A localidade é obrigatoria.';
      break
    case 'province':
      errors.province = form.province === '' ? 'A provincia é obrigatoria.' : '';
      break
    case 'telephone':
      errors.telephone = form.telephone.trim() === '' || /^[0-9]{7,15}$/.test(form.telephone) ? '' : 'O teléfono debe ser numérico.';
      break;
    case 'mobilePhone':
      errors.mobilePhone = form.mobilePhone.trim() === '' || /^[0-9]{7,15}$/.test(form.mobilePhone) ? '' : 'O teléfono debe ser numérico.';
      break;

    case 'email':
      if (form.email.trim() === '') {
        errors.email = '';
      } else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(form.email)) {
        errors.email = 'O email non é correcto.';
      } else {
        errors.email = '';
      }
      break;

    case 'password':
      errors.password = form.password.length >= 6 ? '' : 'O contrasinal debe ter 6 caracteres mínimo.';
      break
    case 'bankName':
      errors.bankName = form.bankName.trim() ? '' : 'A entidade bancaria é obrigatoria.';
      break
    case 'iban':
      if (form.iban.trim() === '') {
        errors.iban = '';
      } else if (!/^([A-Z]{2}\d{2}\s?\d{4}\s?\d{4}\s?\d{4}\s?\d{4}|\d+)$/.test(form.iban.replace(/\s/g, ''))) {
        errors.iban = 'O IBAN non é correcto.';
      } else {
        errors.iban = '';
      }
      break;

    case 'receivesNotifications':
      errors.receivesNotifications = form.receivesNotifications ? '' : 'Este campo é obrigatorio.';
      break
    case 'imageConsent':
      errors.imageConsent = form.imageConsent ? '' : 'Este campo é obrigatorio.';
      break
    case 'acceptPayments':
      errors.acceptPayments = form.acceptPayments ? '' : 'Este campo é obrigatorio.';
      break
  }
}

function validateAll(): boolean {
  Object.keys(form).forEach((key) => validateField(key))
  return Object.values(errors).every(msg => msg === '')
}

async function handleSubmit() {
  if (!validateAll()) {
    alert('Hai erros no formulario.')
    return
  }

  try {
    await api.post('/auth/register', form)
    alert('¡Alta solicitada correctamente!')
    Object.assign(form, {
      name: '', surname: '', dni: '', birthDate: '',
      address: '', zipCode: '', town: '', province: '',
      telephone: '', mobilePhone: '', email: '', password: '',
      bankName: '', iban: '',
      receivesNotifications: false, imageConsent: false, acceptPayments: false
    })
  } catch (error) {
    console.error('Erro ao rexistrar:', error)
    alert('Produciuse un erro ao rexistrar.')
  }
}
</script>
