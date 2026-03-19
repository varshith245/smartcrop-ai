// src/pages/Login.jsx

import React, { useState } from "react";
import { loginUser } from "../api/auth.api";
import { Link, useNavigate } from "react-router-dom";

export default function Login() {

  const navigate = useNavigate();

  const [form, setForm] = useState({
    email: "",
    password: ""
  });

  const [loading, setLoading] = useState(false);

  const handleChange = (e) => {
    setForm({
      ...form,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    setLoading(true);

    try {

      const res = await loginUser(form);

      // ===============================
      // STORE LOGIN DATA
      // ===============================
      localStorage.setItem("token", res.data.token);
      localStorage.setItem("role", res.data.role);
      localStorage.setItem("userId", res.data.id);
      localStorage.setItem("email", res.data.email);

      // ===============================
      // ROLE BASED REDIRECT
      // ===============================
      if (res.data.role === "ADMIN") {
        navigate("/admin");
      }
      else if (res.data.role === "FARMER") {
        navigate("/farmer");
      }
      else {
        navigate("/");
      }

    } catch (err) {
      alert(
        err?.response?.data?.message ||
        "Login failed. Check credentials."
      );
    }

    setLoading(false);
  };

  return (
    <div className="auth-wrapper">
      <div className="auth-container large-auth">

        <h2>Welcome Back 👋</h2>

        <p className="auth-subtitle">
          Login to continue SmartCrop AI farming insights
        </p>

        <form onSubmit={handleSubmit}>

          <input
            name="email"
            type="email"
            placeholder="Enter Email"
            onChange={handleChange}
            required
          />

          <input
            name="password"
            type="password"
            placeholder="Enter Password"
            onChange={handleChange}
            required
          />

          <button type="submit">
            {loading ? "Logging in..." : "Login"}
          </button>

        </form>

        <p className="auth-msg">
          New to SmartCrop?
          <Link to="/register"> Create Account 🌱</Link>
        </p>

      </div>
    </div>
  );
}