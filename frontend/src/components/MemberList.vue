<template>
  <div class="member-list">
    <h2>Lista de socios</h2>

    <input
        v-model="search"
        type="text"
        placeholder="Buscar por nome ou apelidos"
        class="search-box"
    />

    <table class="member-table">
      <thead>
      <tr>
        <th @click="sortBy('name')" class="sortable">
          Nome<span class="arrow">{{ sortArrow('name') }}</span>
        </th>
        <th @click="sortBy('userRole')" class="sortable">
          Rol<span class="arrow">{{ sortArrow('userRole') }}</span>
        </th>
        <th @click="sortBy('registerDate')" class="sortable">
          Data de alta<span class="arrow">{{ sortArrow('registerDate') }}</span>
        </th>
        <th v-if="isAdminView">Accións</th>
      </tr>
      </thead>

      <tbody>
      <tr v-for="user in filteredUsers" :key="user.id">
        <td>
            <span
                :class="{
                'glow-admin': user.userRole === 'ADMIN',
                'glow-mod': user.userRole === 'MODERATOR',
              }"
            >
              {{ user.name }} {{ user.surname }}
            </span>
        </td>

        <td class="role-cell">
          <img
              :src="roleImages[user.userRole]"
              :alt="user.userRole"
              class="role-icon"
          />
        </td>

        <td>{{ formatDate(user.registerDate) }}</td>

        <td v-if="isAdminView">
          <button
              class="btn-promote"
              v-if="user.userRole === 'SOCIO'"
              @click="openConfirmModal(user.id, 'promote')"
              type="button"
          >
            Ascender
          </button>
          <button
              class="btn-demote"
              v-if="user.userRole === 'MODERATOR'"
              @click="openConfirmModal(user.id, 'demote')"
              type="button"
          >
            Degradar
          </button>
        </td>
      </tr>
      </tbody>
    </table>

    <div class="pagination">
      <button @click="previousPage" :disabled="page === 0">Anterior</button>
      <span>Páxina {{ page + 1 }} de {{ totalPages }}</span>
      <button @click="nextPage" :disabled="page >= totalPages - 1">Seguinte</button>
    </div>


    <ConfirmModal
        :visible="showModal"
        :message="modalMessage"
        @confirm="onConfirm"
        @cancel="onCancel"
    />
  </div>
</template>

<script setup lang="ts">
import {ref, computed, onMounted, defineExpose, defineProps} from 'vue'
import {api} from '@/services/api';
import {useAuthStore} from '@/stores/authStore'
import ConfirmModal from './modals/ModalConfirm.vue'

const users = ref<any[]>([])
const page = ref(0)
const size = 10
const totalPages = ref(0)
const search = ref('')
const sortKey = ref<'name' | 'userRole' | 'registerDate'>('name')
const sortAsc = ref(true)
const auth = useAuthStore()
const roleImages = {
  ADMIN: new URL('@/assets/roles/admin.png', import.meta.url).href,
  SOCIO: new URL('@/assets/roles/socio.png', import.meta.url).href,
  MODERATOR: new URL('@/assets/roles/moderator.png', import.meta.url).href
}

const showModal = ref(false)
const modalMessage = ref('')
const userIdToAct = ref<number | null>(null)
const actionType = ref<'promote' | 'demote' | null>(null)
const emit = defineEmits(['promote', 'demote'])

const props = defineProps({
  isAdminView: {
    type: Boolean,
    default: false
  }
})

const filteredUsers = computed(() => {
  const query = search.value.toLowerCase().trim()

  let result = users.value
      .filter(user => user.userRole !== 'ASPIRANTE')
      .filter(user =>
          !query ||
          user.name.toLowerCase().includes(query) ||
          user.surname.toLowerCase().includes(query)
      )

  result = [...result].sort((a, b) => {
    let valA = a[sortKey.value]
    let valB = b[sortKey.value]

    if (sortKey.value === 'registerDate') {
      valA = new Date(valA)
      valB = new Date(valB)
    } else {
      valA = valA?.toLowerCase?.() || ''
      valB = valB?.toLowerCase?.() || ''
    }

    if (valA < valB) return sortAsc.value ? -1 : 1
    if (valA > valB) return sortAsc.value ? 1 : -1
    return 0
  })

  return result
})

function formatDate(dateStr: string): string {
  const date = new Date(dateStr)
  return date.toLocaleDateString('gl-ES')
}

function sortBy(key: 'name' | 'userRole' | 'registerDate') {
  if (sortKey.value === key) {
    sortAsc.value = !sortAsc.value
  } else {
    sortKey.value = key
    sortAsc.value = true
  }
}

function sortArrow(key: string): string {
  if (sortKey.value === key) {
    return sortAsc.value ? ' ▲' : ' ▼'
  }
  return ' ▲▼'  // Ambas flechas gris claro
}

async function loadUsers() {
  try {
    const response = await api.get(`/users?page=${page.value}&size=${size}`, {
      headers: {
        Authorization: `Bearer ${auth.token}`
      }
    })
    console.log('Usuarios cargados:', response.data)
    users.value = response.data.content
    totalPages.value = response.data.totalPages
  } catch (error) {
    console.error('Erro ao cargar os socios:', error)
  }
}

function nextPage() {
  if (page.value < totalPages.value - 1) {
    page.value++
    loadUsers()
  }
}

function previousPage() {
  if (page.value > 0) {
    page.value--
    loadUsers()
  }
}

function openConfirmModal(userId: number, action: 'promote' | 'demote') {
  userIdToAct.value = userId
  actionType.value = action
  modalMessage.value = action === 'promote'
      ? '¿Seguro que quieres ascender a este usuario a moderador?'
      : '¿Seguro que quieres degradar a este usuario a socio?'
  showModal.value = true
}

function onConfirm() {
  if (userIdToAct.value !== null && actionType.value !== null) {
    if (actionType.value === 'promote') {
      emit('promote', userIdToAct.value)
    } else {
      emit('demote', userIdToAct.value)
    }
  }
  showModal.value = false
}

function onCancel() {
  showModal.value = false
}

onMounted(loadUsers)

defineExpose({
  loadUsers
})
</script>

<style src="./MemberList.css"></style>
