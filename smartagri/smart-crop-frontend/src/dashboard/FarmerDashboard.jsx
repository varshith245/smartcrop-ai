// src/dashboard/FarmerDashboard.jsx

import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { getUserByEmail } from "../api/user.api";
import { getFarmerStats } from "../api/farmer.api";
import NotificationPanel from "../components/NotificationPanel";

export default function FarmerDashboard() {

  const [user, setUser] = useState({});
  const [stats, setStats] = useState({
  farms: 0,
  crops: 0,
  yields: 0,
  diseases: 0
});
  const navigate = useNavigate();

  const email = localStorage.getItem("email");
  useEffect(() => {
  const loadData = async () => {
    try {
      const userRes = await getUserByEmail(email);
      setUser(userRes.data);

     const data = await getFarmerStats();

setStats({
  farms: data.farms,
  crops: data.crops,
  yields: data.yields,
  diseases: data.diseases
});

    } catch (err) {
      console.log(err);
    }
  };

  loadData();
}, [email]);

 

  return (
    <div className="dashboard-wrapper">

      <div className="dashboard-header">
        <h1>Welcome, {user.name || "Farmer"} 👨‍🌾</h1>
        <p>Manage your farms and improve productivity.</p>
      </div>

      {/* PROFILE */}
      <div className="profile-card">
        <div className="profile-row">
          <div><strong>Name:</strong> {user.name}</div>
          <div><strong>Email:</strong> {user.email}</div>
          <div><strong>Role:</strong> {user.role}</div>
        </div>
      </div>
      {/* NOTIFICATIONS */}
<NotificationPanel />

      {/* STATS */}
      <div className="stats-grid">

        <div className="stat-card">
          <h2>{stats.farms || 0}</h2>
          <p>Total Farms</p>
        </div>

        <div className="stat-card">
          <h2>{stats.crops || 0}</h2>
          <p>Total Crops</p>
        </div>

        <div className="stat-card">
          <h2>{stats.yields || 0}</h2>
          <p>Yield Records</p>
        </div>

        <div className="stat-card">
          <h2>{stats.diseases || 0}</h2>
          <p>Disease Alerts</p>
        </div>

      </div>

      {/* ACTION CARDS */}
      <div className="card-grid">

        <div className="dashboard-card"
          onClick={() => navigate("/farmer/farms")}>
          My Farms
        </div>

        <div className="dashboard-card"
          onClick={() => navigate("/farmer/yield")}>
          Yield Prediction
        </div>

        <div className="dashboard-card"
          onClick={() => navigate("/farmer/yield-history")}>
          Yield History
        </div>

        <div className="dashboard-card"
          onClick={() => navigate("/farmer/fertilizer")}>
          Fertilizer Advice
        </div>

        <div className="dashboard-card"
          onClick={() => navigate("/farmer/irrigation")}>
          Irrigation Plan
        </div>

        <div className="dashboard-card"
          onClick={() => navigate("/farmer/insights")}>
          Insights
        </div>

      </div>

    </div>
  );
}