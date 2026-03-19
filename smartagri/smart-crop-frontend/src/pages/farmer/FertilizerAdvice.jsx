// src/pages/farmer/FertilizerAdvice.jsx

import React, { useState } from "react";
import { recommendFertilizer } from "../../api/fertilizer.api";

export default function FertilizerAdvice() {

  // ================= STATE =================
  const [form, setForm] = useState({
    cropName: "",
    soilType: "",
    nitrogen: "",
    phosphorus: "",
    potassium: ""
  });

  const [result, setResult] = useState(null);
  const [loading, setLoading] = useState(false);

  // ================= HANDLE INPUT =================
  const handleChange = (e) => {
    setForm({
      ...form,
      [e.target.name]: e.target.value
    });
  };

  // ================= SUBMIT =================
  const handleSubmit = async () => {

    try {
      setLoading(true);

      const payload = {
        cropName: form.cropName,
        soilType: form.soilType,
        nitrogen: Number(form.nitrogen),
        phosphorus: Number(form.phosphorus),
        potassium: Number(form.potassium)
      };

      console.log("Sending 👉", payload);

      const res = await recommendFertilizer(payload);

      console.log("Response 👉", res.data);

      setResult(res.data);

    } catch (err) {

      console.error(err);

      alert(
        err.response?.data?.message ||
        "No recommendation found"
      );

      setResult(null);

    } finally {
      setLoading(false);
    }
  };

  // ================= UI =================
  return (
    <div className="dashboard-wrapper">

      <h2>Fertilizer Recommendation</h2>

      {/* ===== FORM ===== */}

      <input
        name="cropName"
        placeholder="Crop Name (Rice, Wheat...)"
        value={form.cropName}
        onChange={handleChange}
      />

      <input
        name="soilType"
        placeholder="Soil Type (Clay, Sandy...)"
        value={form.soilType}
        onChange={handleChange}
      />

      <input
        name="nitrogen"
        type="number"
        placeholder="Nitrogen (N)"
        value={form.nitrogen}
        onChange={handleChange}
      />

      <input
        name="phosphorus"
        type="number"
        placeholder="Phosphorus (P)"
        value={form.phosphorus}
        onChange={handleChange}
      />

      <input
        name="potassium"
        type="number"
        placeholder="Potassium (K)"
        value={form.potassium}
        onChange={handleChange}
      />

      <button onClick={handleSubmit}>
        {loading ? "Analyzing..." : "Get Recommendation"}
      </button>

      {/* ===== RESULT CARD ===== */}

      {result && (
        <div className="dashboard-card">

          <h3>Recommendation Result</h3>

          <p>
            <strong>Crop:</strong> {result.cropName}
          </p>

          <p>
            <strong>Soil:</strong> {result.soilType}
          </p>

          <hr />

          <p>
            <strong>Nitrogen (N):</strong> {result.nitrogen}
          </p>

          <p>
            <strong>Phosphorus (P):</strong> {result.phosphorus}
          </p>

          <p>
            <strong>Potassium (K):</strong> {result.potassium}
          </p>

          <hr />

          <p>
            <strong>Advice:</strong>
          </p>

          <p>{result.recommendation}</p>

        </div>
      )}

    </div>
  );
}