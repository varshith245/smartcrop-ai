// src/pages/farmer/YieldPrediction.jsx

import React, { useState } from "react";
import { predictYield } from "../../api/yield.api";

export default function YieldPrediction() {

  const [form, setForm] = useState({
    cropName: "",
    landArea: "",
    soilType: "",
    fertilizerUsed: "",
    waterUsed: ""
  });

  const [result, setResult] = useState(null);

  const handleChange = (e) => {
    setForm({
      ...form,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async () => {
    try {

      // Convert numbers before sending
      const payload = {
        ...form,
        landArea: Number(form.landArea),
        fertilizerUsed: Number(form.fertilizerUsed),
        waterUsed: Number(form.waterUsed)
      };

      const res = await predictYield(payload);
      setResult(res.data);

    } catch (err) {
      console.log(err);
    }
  };

  return (
    <div className="dashboard-wrapper">
      <h2>Yield Prediction</h2>

      <input
        name="cropName"
        placeholder="Crop Name"
        onChange={handleChange}
      />

      <input
        name="landArea"
        placeholder="Land Area"
        onChange={handleChange}
      />

      <input
        name="soilType"
        placeholder="Soil Type"
        onChange={handleChange}
      />

      <input
        name="fertilizerUsed"
        placeholder="Fertilizer Used (kg)"
        onChange={handleChange}
      />

      <input
        name="waterUsed"
        placeholder="Water Used (litres)"
        onChange={handleChange}
      />

      <button onClick={handleSubmit}>
        Predict
      </button>

      {result && (
        <div className="dashboard-card">
          <p>Expected Yield: {result.expectedYield}</p>
          <p>Profit: {result.profitEstimate}</p>
        </div>
      )}
    </div>
  );
}