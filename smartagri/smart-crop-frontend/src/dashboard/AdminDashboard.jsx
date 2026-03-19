// src/dashboard/AdminDashboard.jsx

import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { getUserByEmail } from "../api/user.api";
import { getAdminStats } from "../api/admin.api";
import NotificationPanel from "../components/NotificationPanel";

export default function AdminDashboard() {

  const [user, setUser] = useState({});
  const [stats, setStats] = useState({});
  const navigate = useNavigate();

  const email = localStorage.getItem("email");

  useEffect(() => {

    const loadData = async () => {
      try {

        const userRes = await getUserByEmail(email);
        setUser(userRes.data);

        const statsRes = await getAdminStats();
        setStats(statsRes.data);

      } catch (err) {
        console.log(err);
      }
    };

    loadData();

  }, [email]);

  return (
    <div className="dashboard-wrapper">

      <div className="dashboard-header">
        <h1>Welcome, {user.name || "Admin"} 👨‍💼</h1>
        <p>Monitor and manage the SmartCrop platform.</p>
      </div>

      {/* PROFILE */}
      <div className="profile-card">
        <div className="profile-row">
          <div><strong>Name:</strong> {user.name}</div>
          <div><strong>Email:</strong> {user.email}</div>
          <div><strong>Role:</strong> {user.role}</div>
        </div>
      </div>

      {/* STATS */}
      <div className="stats-grid">

        <div className="stat-card">
          <h2>{stats.totalUsers || 0}</h2>
          <p>Total Users</p>
        </div>

        <div className="stat-card">
          <h2>{stats.totalFarms || 0}</h2>
          <p>Total Farms</p>
        </div>

        <div className="stat-card">
          <h2>{stats.totalCrops || 0}</h2>
          <p>Total Crops</p>
        </div>

        <div className="stat-card">
          <h2>{stats.totalYieldRecords || 0}</h2>
          <p>Yield Records</p>
        </div>

      </div>

      {/* ACTION CARDS */}
      <div className="card-grid">

        <div className="dashboard-card"
          onClick={() => navigate("/admin/users")}>
          Manage Users
        </div>

        <div className="dashboard-card"
          onClick={() => navigate("/admin/farms")}>
          Manage Farms
        </div>

        <div className="dashboard-card"
          onClick={() => navigate("/admin/crops")}>
          Manage Crops
        </div>

        <div className="dashboard-card"
          onClick={() => navigate("/admin/diseases")}>
          Disease Reports
        </div>

        <div className="dashboard-card"
          onClick={() => navigate("/admin/analytics")}>
          Analytics
        </div>

        <div className="dashboard-card"
          onClick={() => navigate("/admin/settings")}>
          Platform Settings
        </div>
        <div
  className="dashboard-card"
  onClick={() => navigate("/admin/irrigation")}
>
  Manage Irrigation
</div>

      </div>

    </div>
  );
}