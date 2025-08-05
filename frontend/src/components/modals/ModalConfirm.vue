<template>
  <div v-if="visible" class="modal-overlay" @click.self="cancel">
    <div class="modal-content">
      <p>{{ message }}</p>
      <div class="buttons">
        <button @click="confirm" class="btn-confirm">Confirmar</button>
        <button @click="cancel" class="btn-cancel">Cancelar</button>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { defineProps, defineEmits } from 'vue'

const props = defineProps({
  message: { type: String, required: true },
  visible: { type: Boolean, required: true }
})

const emit = defineEmits(['confirm', 'cancel'])

function confirm() {
  emit('confirm')
}

function cancel() {
  emit('cancel')
}
</script>

<style scoped>
.modal-overlay {
  position: fixed;
  inset: 0;
  background: rgba(0,0,0,0.4);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000;
}
.modal-content {
  background: white;
  padding: 1.5rem 2rem;
  border-radius: 8px;
  max-width: 300px;
  text-align: center;
}
.buttons {
  margin-top: 1rem;
  display: flex;
  justify-content: space-around;
}
.btn-confirm {
  background-color: #22c55e;
  color: white;
  border: none;
  padding: 0.5rem 1rem;
  border-radius: 6px;
  cursor: pointer;
}
.btn-cancel {
  background-color: #ef4444;
  color: white;
  border: none;
  padding: 0.5rem 1rem;
  border-radius: 6px;
  cursor: pointer;
}
</style>
