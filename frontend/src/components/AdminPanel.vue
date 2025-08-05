<template>
  <div class="admin-panel">
    <div class="side-menu">
      <button @click="section = 'pending'" :class="{ active: section === 'pending' }">
        Usuarios pendentes
      </button>
    </div>

    <div class="content-area">
      <div class="main-card">
        <h2>Panel de administración</h2>
        <p>Benvido/a, administrador/a.</p>
      </div>

      <PendingUsers v-if="section === 'pending'" />
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import PendingUsers from './PendingUsers.vue'

const section = ref('pending')
</script>

<style src="./AdminPanel.css"></style>
