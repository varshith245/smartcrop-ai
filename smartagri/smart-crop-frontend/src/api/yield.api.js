import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8080/api/yield"
});

API.interceptors.request.use((req) => {
  req.headers.Authorization =
    `Bearer ${localStorage.getItem("token")}`;
  return req;
});

export const predictYield = (data) =>
  API.post("/predict", data);

export const getAllYields = () =>
  API.get("/all");