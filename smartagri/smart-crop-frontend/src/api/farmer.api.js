import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8080/api",
});

API.interceptors.request.use((req) => {
  const token = localStorage.getItem("token");
  if (token) req.headers.Authorization = `Bearer ${token}`;
  return req;
});

export const getFarmerStats = async () => {
  try {

    const farmsRes = await API.get("/farms/my");
    const cropsRes = await API.get("/crops");
    const yieldsRes = await API.get("/yield/all");
    const diseaseRes = await API.get("/disease/all");

    return {
      farms: farmsRes.data.length,
      crops: cropsRes.data.length,
      yields: yieldsRes.data.length,
      diseases: diseaseRes.data.length
    };

  } catch (error) {
    console.error("Stats error:", error);

    return {
      farms: 0,
      crops: 0,
      yields: 0,
      diseases: 0
    };
  }
};
