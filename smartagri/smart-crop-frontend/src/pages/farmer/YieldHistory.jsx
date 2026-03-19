// src/pages/farmer/YieldHistory.jsx

import React, { useEffect, useState } from "react";
import { getAllYields } from "../../api/yield.api";

export default function YieldHistory() {

  const [records, setRecords] = useState([]);

  useEffect(() => {
    const load = async () => {
      const res = await getAllYields();
      setRecords(res.data);
    };
    load();
  }, []);

  return (
    <div className="dashboard-wrapper">
      <h2>Yield History</h2>

      {records.map(y => (
        <div key={y.id} className="dashboard-card">
          <p>Crop: {y.cropName}</p>
          <p>Yield: {y.expectedYield}</p>
          <p>Profit: {y.profitEstimate}</p>
        </div>
      ))}
    </div>
  );
}