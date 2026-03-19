// src/pages/farmer/IrrigationPlan.jsx

import React, { useState } from "react";
import { recommendIrrigation }
  from "../../api/irrigation.api";

export default function IrrigationPlan() {

  const [form, setForm] = useState({
    cropName: "",
    soilType: ""
  });

  const [plan, setPlan] = useState(null);

  const [loading, setLoading] =
    useState(false);

  const handleChange = (e) => {
    setForm({
      ...form,
      [e.target.name]: e.target.value
    });
  };

  const submit = async () => {

    try {

      setLoading(true);

      const res =
        await recommendIrrigation(form);

      setPlan(res.data);

    } catch (err) {

      console.error(err);
      alert("No irrigation plan found ❌");

      setPlan(null);

    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="dashboard-wrapper">

      <h2>Irrigation Recommendation</h2>

      {/* INPUTS */}

      <input
        name="cropName"
        placeholder="Crop Name"
        value={form.cropName}
        onChange={handleChange}
      />

      <input
        name="soilType"
        placeholder="Soil Type"
        value={form.soilType}
        onChange={handleChange}
      />

      <button onClick={submit}>
        {loading ? "Loading..." : "Get Plan"}
      </button>

      <hr />

      {/* RESULT */}

      {plan && (

        <div className="dashboard-card">

          <h3>
            {plan.cropName}
            {" "}
            ({plan.soilType})
          </h3>

          <p>
            <strong>Water Requirement:</strong>
            {" "}
            {plan.waterRequirement}
            {" "}
            L/day
          </p>

          <p>
            <strong>Method:</strong>
            {" "}
            {plan.irrigationMethod}
          </p>

          <p>
            <strong>Schedule:</strong>
            {" "}
            {plan.schedule}
          </p>

          <p>
            <strong>Advice:</strong>
            {" "}
            {plan.recommendation}
          </p>

        </div>
      )}

    </div>
  );
}