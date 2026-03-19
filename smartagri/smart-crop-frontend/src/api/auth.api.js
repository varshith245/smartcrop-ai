// src/api/auth.api.js

import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8080/api/auth",
  headers: {
    "Content-Type": "application/json"
  }
});

// REGISTER
export const registerUser = (data) =>
  API.post("/register", data);

// VERIFY OTP
export const verifyOtp = (data) =>
  API.post("/verify-otp", data);

// LOGIN
export const loginUser = (data) =>
  API.post("/login", data);