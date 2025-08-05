<template>
  <div class="admin-panel">
    <div class="side-menu">
      <button @click="section = 'pending'" :class="{ active: section === 'pending' }">
        Usuarios pendentes
      </button>

      <button @click="section = 'manageUsers'" :class="{ active: section === 'manageUsers' }">
        Administrar socios
      </button>
    </div>

    <div class="content-area">
      <div class="main-card">
        <h2>Panel de administración</h2>
        <p>Benvido/a, administrador/a.</p>
      </div>

      <PendingUsers v-if="section === 'pending'" />
      <MemberList
          v-if="section === 'manageUsers'"
          :isAdminView="true"
          @promote="handlePromote"
          @demote="handleDemote"
      />

    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import PendingUsers from './PendingUsers.vue'
import MemberList from "./MemberList.vue";
import axios from 'axios';
import { useAuthStore } from '@/stores/authStore'

const section = ref('pending')
const auth = useAuthStore()

async function handlePromote(userId: number) {
  try {
    await axios.post(`/api/admin/promote/${userId}`, null, {
      headers: {
        Authorization: `Bearer ${auth.token}`
      }
    })
    alert('Usuario promovido a moderador')
  } catch (error) {
    console.error(error)
    alert('Error promoviendo usuario')
  }
}

async function handleDemote(userId: number) {
  try {
    await axios.post(`/api/admin/demote/${userId}`, null, {
      headers: {
        Authorization: `Bearer ${auth.token}`
      }
    })
    alert('Usuario degradado a socio')
  } catch (error) {
    console.error(error)
    alert('Error degradando usuario')
  }
}
</script>

<style src="./AdminPanel.css"></style>
