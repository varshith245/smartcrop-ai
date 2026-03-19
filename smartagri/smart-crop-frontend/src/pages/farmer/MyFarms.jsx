// src/pages/farmer/MyFarms.jsx

import React, { useEffect, useState } from "react";
import {
  getMyFarms,
  createFarm,
  deleteFarm,
  updateFarm,
} from "../../api/farm.api";

export default function MyFarms() {

  const [farms, setFarms] = useState([]);

  const [form, setForm] = useState({
    name: "",
    location: "",
    soilType: "",
    area: "",
    waterSource: "",
  });

  const [editingId, setEditingId] =
    useState(null);

  // ===== LOAD FARMS =====
  useEffect(() => {
    loadFarms();
  }, []);

  const loadFarms = async () => {
    try {
      const res = await getMyFarms();
      setFarms(res.data);
    } catch (err) {
      console.error(err);
    }
  };

  // ===== HANDLE INPUT =====
  const handleChange = (e) => {
    setForm({
      ...form,
      [e.target.name]: e.target.value,
    });
  };

  // ===== SUBMIT =====
  const handleSubmit = async (e) => {
    e.preventDefault();

    try {

      if (editingId) {
        await updateFarm(editingId, form);
        setEditingId(null);
      } else {
        await createFarm(form);
      }

      setForm({
        name: "",
        location: "",
        soilType: "",
        area: "",
        waterSource: "",
      });

      loadFarms();

    } catch (err) {
      console.error("Farm save error:", err);
      alert("Failed to save farm");
    }
  };

  // ===== DELETE =====
  const handleDelete = async (id) => {
    if (!window.confirm("Delete farm?"))
      return;

    await deleteFarm(id);
    loadFarms();
  };

  // ===== EDIT =====
  const handleEdit = (farm) => {
    setForm(farm);
    setEditingId(farm.id);
  };

  // ===== UI =====
  return (
    <div className="admin-users-wrapper">

      <h1 className="admin-title">
        🌾 My Farms
      </h1>

      {/* ===== FORM ===== */}
      <form
        className="stat-card"
        onSubmit={handleSubmit}
      >
        

        <input
          name="name"
          placeholder="Farm Name"
          value={form.name}
          onChange={handleChange}
          required
        />

        <input
          name="location"
          placeholder="Location"
          value={form.location}
          onChange={handleChange}
          required
        />

        <input
          name="soilType"
          placeholder="Soil Type"
          value={form.soilType}
          onChange={handleChange}
        />

        <input
          name="area"
          type="number"
          placeholder="Area"
          value={form.area}
          onChange={handleChange}
        />

        <input
          name="waterSource"
          placeholder="Water Source"
          value={form.waterSource}
          onChange={handleChange}
        />

        <button className="btn-enable">
          {editingId
            ? "Update Farm"
            : "Add Farm"}
        </button>

      </form>

      {/* ===== TABLE ===== */}
      {farms.length === 0 ? (

        <div className="stat-card">
          No farms found.
        </div>

      ) : (

        <table className="users-table">

          <thead>
            <tr>
              
              <th>Name</th>
              <th>Location</th>
              <th>Soil</th>
              <th>Area</th>
              <th>Water</th>
              <th>Actions</th>
            </tr>
          </thead>

          <tbody>

            {farms.map((f) => (

              <tr key={f.id}>

                <td>{f.name}</td>
                <td>{f.location}</td>
                <td>{f.soilType}</td>
                <td>{f.area} Acres</td>
                <td>{f.waterSource}</td>

                <td>

                  <button
                    className="btn-disable"
                    onClick={() => handleEdit(f)}
                  >
                    Edit
                  </button>

                  <button
                    className="btn-delete"
                    onClick={() => handleDelete(f.id)}
                  >
                    Delete
                  </button>

                </td>

              </tr>

            ))}

          </tbody>

        </table>

      )}

    </div>
  );
}