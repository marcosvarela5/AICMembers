import { ref } from 'vue'

export function useConfirmModal() {
    const showModal = ref(false)
    const modalMessage = ref('')
    const dataToAct = ref<any>(null)
    const actionType = ref<string | null>(null)

    function openConfirmModal(data: any, action: string, message: string) {
        dataToAct.value = data
        actionType.value = action
        modalMessage.value = action === 'accept'
            ? '¿Seguro que queres aceptar a este usuario?'
            : '¿Seguro que queres rexeitar a este usuario?'
        showModal.value = true
    }

    function closeModal() {
        showModal.value = false
    }

    return {
        showModal,
        modalMessage,
        dataToAct,
        actionType,
        openConfirmModal,
        closeModal
    }
}