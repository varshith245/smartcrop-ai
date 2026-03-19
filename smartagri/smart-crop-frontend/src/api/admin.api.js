import axios from "axios";

export const API = axios.create({
  baseURL: "http://localhost:8080/api/admin",
});

API.interceptors.request.use((req) => {
  const token = localStorage.getItem("token");
  if (token) {
    req.headers.Authorization = `Bearer ${token}`;
  }
  return req;
});

// USERS
export const getAllUsers = () => API.get("/users");

// DASHBOARD
export const getAdminStats = () => API.get("/dashboard");