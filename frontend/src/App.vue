<template>
  <div class="layout">
    <header class="navbar">
      <nav class="nav-links">
        <router-link to="/">Home</router-link>
        <router-link to="/about">About</router-link>
        <router-link to="/register">Alta</router-link>
        <router-link to="/members">Socios</router-link>
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
</style>
