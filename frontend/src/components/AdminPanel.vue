<template>
  <div class="admin-panel">
    <div class="side-menu">
      <button @click="section = 'pending'" :class="{ active: section === 'pending' }">
        Usuarios pendentes
      </button>
      <button @click="section = 'manageUsers'" :class="{ active: section === 'manageUsers' }">
        Administrar usuarios
      </button>
    </div>

    <div class="content-area">
      <div class="main-card">
        <h2>Panel de administración</h2>
        <p>Benvido/a, administrador/a.</p>
      </div>

      <PendingUsers v-if="section === 'pending'"/>
      <MemberList
          v-if="section === 'manageUsers'"
          ref="memberListRef"
          :isAdminView="true"
          @promote="handlePromote"
          @demote="handleDemote"
      />
    </div>
  </div>
</template>

<script setup lang="ts">
import {ref} from 'vue'
import PendingUsers from './PendingUsers.vue'
import MemberList from './MemberList.vue'
import {useAuthStore} from '@/stores/authStore'
import {api} from '@/services/api';

const section = ref('pending')
const auth = useAuthStore()
const memberListRef = ref<InstanceType<typeof MemberList> | null>(null)

async function handlePromote(userId: number) {
  try {
    await api.post(`/admin/promote/${userId}`, null, {
      headers: {
        Authorization: `Bearer ${auth.token}`
      }
    })
    await memberListRef.value?.loadUsers()
  } catch (error) {
    console.error(error)
  }
}

async function handleDemote(userId: number) {
  try {
    await api.post(`/admin/demote/${userId}`, null, {
      headers: {
        Authorization: `Bearer ${auth.token}`
      }
    })
    await memberListRef.value?.loadUsers()
  } catch (error) {
    console.error(error)
  }
}
</script>

<style src="./AdminPanel.css"></style>
