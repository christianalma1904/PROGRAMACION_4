import api from "./api";
import { authStore } from "../store/auth";

// API pública: https://reqres.in
// const BASE = "https://reqres.in/api";

// CAMBIO CRUCIAL: Mantenemos 10.0.2.2 para el emulador.
const BASE = "http://10.0.2.2:8000"; 
// La barra diagonal final se maneja en los endpoints.

export async function login(email: string, password: string) {
  // CORRECCIÓN: Usamos 'auth/login/' para coincidir con users/urls.py
  const { data } = await api.post(`${BASE}/auth/login/`, { email, password });
  authStore.set({ token: data.token, email });
  return data;
}

export async function register(email: string, password: string) {
  // CORRECCIÓN: Usamos 'auth/register/' para coincidir con users/urls.py
  const { data } = await api.post(`${BASE}/auth/register/`, { email, password });
  // Opcional: guardar token si devuelve
  authStore.set({ token: data.token ?? null, email });
  return data;
}

export function logout() {
  authStore.clear();
}