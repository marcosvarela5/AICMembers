# 1) Build (Vite)
FROM node:20-alpine AS build
WORKDIR /app

# Permitir inyectar la URL del backend en build
ARG VITE_API_URL
ENV VITE_API_URL=${VITE_API_URL}

COPY package*.json ./
RUN npm ci
COPY . .
RUN apk add --no-cache dos2unix \
 && find /app/src -type f -print0 | xargs -0 dos2unix
RUN npm run build

# 2) Serve (Nginx)
FROM nginx:1.27-alpine

# SPA fallback (rutas de Vue Router)
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Estáticos
COPY --from=build /app/dist /usr/share/nginx/html
EXPOSE 80
