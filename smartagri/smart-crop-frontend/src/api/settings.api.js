import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8080/api"
});

// attach token
API.interceptors.request.use((req) => {
  const token = localStorage.getItem("token");
  if (token) req.headers.Authorization = `Bearer ${token}`;
  return req;
});

// get settings
export const getSettings = () => API.get("/settings");

// save settings
export const saveSettings = (data) => API.post("/settings", data);