// src/api/irrigation.api.js

import axios from "axios";

// AXIOS INSTANCE
const API = axios.create({
  baseURL: "http://localhost:8080/api/irrigation"
});

// ATTACH TOKEN
API.interceptors.request.use((req) => {

  const token = localStorage.getItem("token");

  if (token) {
    req.headers.Authorization = `Bearer ${token}`;
  }

  return req;
});


// ===============================
// ADD NEW IRRIGATION PLAN (ADMIN)
// ===============================
export const addIrrigationPlan = (data) =>
  API.post("", data);   // IMPORTANT → NO "/"


// ===============================
// GET ALL PLANS (ADMIN)
// ===============================
export const getAllIrrigationPlans = () =>
  API.get("/all");


// ===============================
// DELETE PLAN (ADMIN)
// ===============================
export const deleteIrrigationPlan = (id) =>
  API.delete(`/${id}`);


// ===============================
// RECOMMEND PLAN (FARMER)
// ===============================
export const recommendIrrigation = (data) =>
  API.post("/recommend", data);