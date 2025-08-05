<template>
  <div class="layout">
    <header class="navbar">
      <nav class="nav-links">
        <router-link to="/">Home</router-link>
        <router-link to="/about">About</router-link>
        <router-link v-if="!auth.isAuthenticated" to="/register">Alta</router-link>
        <router-link to="/members">Socios</router-link>
        <router-link
            v-if="auth.user?.userRole === 'ADMIN'"
            to="/admin"
        >
          Panel de administración
        </router-link>

        <div class="auth-section">
          <router-link v-if="!auth.isAuthenticated" to="/login" class="login-button">Iniciar</router-link>

          <div v-else class="user-menu" @mouseenter="showDropdown = true" @mouseleave="showDropdown = false">
            <span class="username">
  <template v-if="auth.user">Ola {{ auth.user.name }}</template>
  <template v-else>Cargando...</template>
</span>
            <div v-if="showDropdown" class="dropdown">
              <button @click="logout">Pechar sesión</button>
            </div>
          </div>
        </div>

      </nav>
    </header>

    <main class="content">
      <router-view/>
    </main>
  </div>
</template>


<style scoped>

html, body {
  margin: 0;
  padding: 0;
  overflow-x: hidden;
  width: 100%;
  max-width: 100vw;
}


.layout {
  display: flex;
  flex-direction: column;
  align-items: center;
  min-height: 100vh;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  color: #1e293b;
  background-color: transparent;
  overflow-x: hidden;
  width: 100%;
}

/* Navbar */
.navbar {
  width: 100%;
  background: rgba(255, 255, 255, 0.85); /* semitransparente */
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.06);
  padding: 1rem 2rem;
  display: flex;
  justify-content: center;
  z-index: 1000;
  position: sticky;
  top: 0;
  backdrop-filter: blur(8px); /* efecto de desenfoque detrás */
}


/* Links */
.nav-links {
  display: flex;
  gap: 2rem;
}

.nav-links a {
  font-weight: 600;
  color: #334155;
  text-decoration: none;
  padding: 0.5rem 0.75rem;
  border-radius: 8px;
  transition: background 0.2s, color 0.2s;
}

.nav-links a:hover {
  background: #f1f5f9;
  color: #2563eb;
}

.nav-links a.router-link-exact-active {
  background: #2563eb;
  color: white;
  box-shadow: 0 2px 8px rgba(37, 99, 235, 0.2);
}

/* Main content */
.content {
  width: 100%;
  max-width: 1100px;
  padding: 2rem 1rem;
  box-sizing: border-box;
}

.logout-button {
  background: none;
  border: none;
  font-weight: 600;
  color: #ef4444;
  cursor: pointer;
  padding: 0.5rem 0.75rem;
  border-radius: 8px;
  transition: background 0.2s, color 0.2s;
}

.logout-button:hover {
  background: #ffe4e6;
}

.auth-section {
  margin-left: auto;
  display: flex;
  align-items: center;
}

.login-button {
  padding: 0.4rem 1rem;
  background-color: #e2e8f0;
  color: #1e293b;
  border-radius: 8px;
  font-weight: 600;
  text-decoration: none;
  transition: background 0.2s;
}

.login-button:hover {
  background-color: #cbd5e1;
}

.user-menu {
  position: relative;
  cursor: pointer;
}

.username {
  padding: 0.4rem 1rem;
  background-color: #f1f5f9;
  border-radius: 8px;
  font-weight: 600;
}

.dropdown {
  position: absolute;
  top: 110%;
  right: 0;
  background: white;
  border: 1px solid #e2e8f0;
  border-radius: 8px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
  z-index: 10;
  padding: 0.5rem;
}

.dropdown button {
  background: none;
  border: none;
  color: #ef4444;
  font-weight: 500;
  cursor: pointer;
  padding: 0.5rem 1rem;
  width: 100%;
  text-align: left;
}

.dropdown button:hover {
  background-color: #ffe4e6;
}
</style>
<script setup lang="ts">
import {useAuthStore} from '@/stores/authStore'
import {useRouter} from 'vue-router'
import {ref, onMounted} from 'vue'

const auth = useAuthStore()
const router = useRouter()
const showDropdown = ref(false)

function logout() {
  auth.logout()
  router.push('/')
}

onMounted(() => {
  if (auth.isAuthenticated && !auth.user) {
    auth.loadUserFromToken()
  }
})
</script>


