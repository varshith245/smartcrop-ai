import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8080/api"
});

API.interceptors.request.use((req) => {
  const token = localStorage.getItem("token");
  if (token) {
    req.headers.Authorization = `Bearer ${token}`;
  }
  return req;
});

// Yield
export const getYieldInsight = (data) =>
  API.post("/yield/predict", data);

// Fertilizer
export const getFertilizerInsight = (data) =>
  API.post("/fertilizer/recommend", data);

// Irrigation
export const getIrrigationInsight = (data) =>
  API.post("/irrigation/recommend", data);