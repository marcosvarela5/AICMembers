import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import path from 'path'
import history from 'connect-history-api-fallback'

// Middleware para permitir rutas como /register en modo SPA
const spaFallback = () => ({
    name: 'spa-fallback',
    configureServer(server) {
        server.middlewares.use(
            history({
                // Asegura que solo se aplique en peticiones HTML
                htmlAcceptHeaders: ['text/html', 'application/xhtml+xml']
            })
        )
    }
})

export default defineConfig({
    plugins: [vue(), spaFallback()],
    resolve: {
        alias: {
            '@': path.resolve(__dirname, './src')
        }
    },
    server: {
        proxy: {
            '/api': {
                target: 'http://localhost:8080',
                changeOrigin: true,
                rewrite: path => path.replace(/^\/api/, '/api') // puedes omitir rewrite si no haces cambios
            }
        }
    }
})
