// src/api/farm.api.js

import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8080/api/farms",
});

// ===== Attach JWT =====
API.interceptors.request.use((req) => {
  const token = localStorage.getItem("token");

  if (token) {
    req.headers.Authorization = `Bearer ${token}`;
  }

  return req;
});

// ===== CREATE FARM =====
export const createFarm = (data) =>
  API.post("", data);

// ===== GET MY FARMS =====
export const getMyFarms = () =>
  API.get("/my");

// ===== DELETE =====
export const deleteFarm = (id) =>
  API.delete(`/${id}`);

// ===== UPDATE =====
export const updateFarm = (id, data) =>
  API.put(`/${id}`, data);