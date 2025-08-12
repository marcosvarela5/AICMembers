<template>
  <div class="pending-users">
    <h3>Usuarios pendentes</h3>
    <table>
      <thead>
      <tr>
        <th>Nome</th>
        <th>Email</th>
        <th>Accións</th>
      </tr>
      </thead>
      <tbody>
      <tr v-if="users.length === 0">
        <td colspan="3">Non hai usuarios pendentes.</td>
      </tr>
      <tr v-for="user in users" :key="user.id">
        <td>{{ user.name }} {{ user.surname }}</td>
        <td>{{ user.email }}</td>
        <td class="actions">
          <button class="accept" @click="approve(user.id)">Aceptar</button>
          <button class="reject" @click="reject(user.id)">Rexeitar</button>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup lang="ts">
import {onMounted, ref} from 'vue'
import {api} from '@/services/api';

const users = ref<any[]>([])

function authHeader() {
  const token = localStorage.getItem('token')
  return token
      ? {headers: {Authorization: `Bearer ${token}`}}
      : null
}

async function fetchPendingUsers() {
  const config = authHeader()
  if (!config) {
    console.warn('Token non dispoñible. Cancelando petición.')
    return
  }

  try {
    const response = await api.get('/admin/pending?page=0&size=20', config)
    console.log('Usuarios pendentes:', response.data)
    users.value = response.data.content
  } catch (error) {
    console.error('Erro ao cargar usuarios pendentes', error)
  }
}

async function approve(id: number) {
  const config = authHeader()
  if (!config) return

  try {
    await api.post(`/admin/approve/${id}`, null, config)
    users.value = users.value.filter(user => user.id !== id)
  } catch (error) {
    console.error('Erro ao aprobar usuario', error)
  }
}

async function reject(id: number) {
  const config = authHeader()
  if (!config) return

  try {
    await api.delete(`/admin/reject/${id}`, config)
    users.value = users.value.filter(user => user.id !== id)
  } catch (error) {
    console.error('Erro ao rexeitar usuario', error)
  }
}

onMounted(fetchPendingUsers)
</script>

<style src="./PendingUsers.css"></style>