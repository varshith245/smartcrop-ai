// src/pages/admin/AdminIrrigation.jsx

import React, { useState, useEffect } from "react";

import {
  addIrrigationPlan,
  getAllIrrigationPlans,
  deleteIrrigationPlan
} from "../../api/irrigation.api";

export default function AdminIrrigation() {

  // ===============================
  // STATE
  // ===============================
  const [form, setForm] = useState({
    cropName: "",
    soilType: "",
    waterRequirement: "",
    irrigationMethod: "",
    schedule: "",
    recommendation: ""
  });

  const [plans, setPlans] = useState([]);

  // ===============================
  // FETCH ALL PLANS
  // ===============================
  useEffect(() => {
    fetchPlans();
  }, []);

  const fetchPlans = async () => {
    try {
      const res = await getAllIrrigationPlans();
      setPlans(res.data);
    } catch (err) {
      console.error("Error fetching plans", err);
    }
  };

  // ===============================
  // HANDLE INPUT
  // ===============================
  const handleChange = (e) => {

    setForm({
      ...form,
      [e.target.name]: e.target.value
    });
  };

  // ===============================
  // SUBMIT PLAN
  // ===============================
  const submit = async () => {

    try {

      await addIrrigationPlan({
        ...form,

        // Convert to number
        waterRequirement:
          Number(form.waterRequirement)
      });

      alert("Plan added ✅");

      // Refresh list
      fetchPlans();

      // Reset form
      setForm({
        cropName: "",
        soilType: "",
        waterRequirement: "",
        irrigationMethod: "",
        schedule: "",
        recommendation: ""
      });

    } catch (err) {

      console.error(err);
      alert("Error adding plan ❌");
    }
  };

  // ===============================
  // DELETE PLAN
  // ===============================
  const deletePlan = async (id) => {

    try {
      await deleteIrrigationPlan(id);
      fetchPlans();
    } catch (err) {
      console.error(err);
    }
  };

  // ===============================
  // UI
  // ===============================
  return (
    <div className="dashboard-wrapper">

      <h2>Admin Irrigation Management</h2>

      {/* FORM */}

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

      <input
        name="waterRequirement"
        type="number"
        placeholder="Water Requirement (liters/day)"
        value={form.waterRequirement}
        onChange={handleChange}
      />

      <input
        name="irrigationMethod"
        placeholder="Method (Drip/Sprinkler/Flood)"
        value={form.irrigationMethod}
        onChange={handleChange}
      />

      <input
        name="schedule"
        placeholder="Schedule (Daily/Weekly)"
        value={form.schedule}
        onChange={handleChange}
      />

      <textarea
        name="recommendation"
        placeholder="Recommendation"
        value={form.recommendation}
        onChange={handleChange}
      />

      <button onClick={submit}>
        Add Plan
      </button>

      <hr />

      {/* PLANS LIST */}

      {plans.map(plan => (

        <div
          key={plan.id}
          className="dashboard-card"
        >
          <h3>
            {plan.cropName} ({plan.soilType})
          </h3>

          <p>
            <strong>Water:</strong>
            {" "}
            {plan.waterRequirement} L/day
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

          <button
            onClick={() =>
              deletePlan(plan.id)
            }
          >
            Delete
          </button>

        </div>
      ))}

    </div>
  );
}