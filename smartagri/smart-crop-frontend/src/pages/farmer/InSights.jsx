import React, { useState, useRef } from "react";

import {
  getYieldInsight,
  getFertilizerInsight,
  getIrrigationInsight
} from "../../api/insight.api";

// 📊 CHART IMPORTS
import {
  BarChart,
  Bar,
  XAxis,
  YAxis,
  Tooltip,
  ResponsiveContainer,
  CartesianGrid
} from "recharts";

// 📄 PDF LIBRARIES
import jsPDF from "jspdf";
import html2canvas from "html2canvas";

export default function Insights() {

  const [cropName, setCropName] = useState("");
  const [soilType, setSoilType] = useState("");

  const [yieldData, setYieldData] = useState(null);
  const [fertilizerData, setFertilizerData] = useState(null);
  const [irrigationData, setIrrigationData] = useState(null);

  const [loading, setLoading] = useState(false);

  // 📌 REF FOR PDF CAPTURE
  const reportRef = useRef();

  // ================= LOAD INSIGHTS =================
  const loadInsights = async () => {

    if (!cropName || !soilType) {
      alert("Please enter crop and soil type");
      return;
    }

    try {
      setLoading(true);

      const yieldRes = await getYieldInsight({
        cropName,
        soilType,
        landArea: 2,
        fertilizerUsed: 100,
        waterUsed: 1200
      });

      setYieldData(yieldRes.data);

      const fertRes = await getFertilizerInsight({
        cropName,
        soilType,
        nitrogen: 100,
        phosphorus: 40,
        potassium: 50
      });

      setFertilizerData(fertRes.data);

      const irrigationRes = await getIrrigationInsight({
        cropName,
        soilType
      });

      setIrrigationData(irrigationRes.data);

    } catch (error) {
      console.error(error);
      alert("Error loading insights");
    } finally {
      setLoading(false);
    }
  };


  // ================= PDF GENERATION =================
 const generatePDF = async () => {

  if (!yieldData || !fertilizerData || !irrigationData) {
    alert("Generate insights first");
    return;
  }

  const element = document.getElementById("pdf-report");

  if (!element) {
    alert("Report not ready");
    return;
  }

  const canvas = await html2canvas(element, {
    scale: 2,
    backgroundColor: "#ffffff",
    useCORS: true
  });

  const imgData = canvas.toDataURL("image/png");

  const pdf = new jsPDF("p", "mm", "a4");

  const imgWidth = 190;
  const pageHeight = 295;
  const imgHeight =
    (canvas.height * imgWidth) / canvas.width;

  let heightLeft = imgHeight;
  let position = 0;

  pdf.addImage(
    imgData,
    "PNG",
    10,
    position,
    imgWidth,
    imgHeight
  );

  heightLeft -= pageHeight;

  while (heightLeft > 0) {
    position = heightLeft - imgHeight;
    pdf.addPage();
    pdf.addImage(
      imgData,
      "PNG",
      10,
      position,
      imgWidth,
      imgHeight
    );
    heightLeft -= pageHeight;
  }

  pdf.save(`${cropName}_SmartCrop_Report.pdf`);
};
  // ================= CHART DATA =================
  const chartData = yieldData
    ? [
        {
          name: "Yield (tons)",
          value: yieldData.expectedYield
        },
        {
          name: "Profit (₹ / 1000)",
          value: yieldData.profitEstimate / 1000
        }
      ]
    : [];


  return (
    <div className="dashboard-wrapper">

      <h2>🌾 Advanced Farmer Insights</h2>

      {/* INPUTS */}
      <div className="insight-inputs">

        <input
          placeholder="Crop Name"
          value={cropName}
          onChange={(e) => setCropName(e.target.value)}
        />

        <input
          placeholder="Soil Type"
          value={soilType}
          onChange={(e) => setSoilType(e.target.value)}
        />

        <button onClick={loadInsights}>
          {loading ? "Generating..." : "Generate Insights"}
        </button>

        {(yieldData && fertilizerData && irrigationData) && (
          <button onClick={generatePDF}>
            📄 Download PDF
          </button>
        )}

      </div>


      {/* ================= REPORT AREA ================= */}
      {(yieldData && fertilizerData && irrigationData) && (
        <div
  id="pdf-report"
  style={{
    background: "#ffffff",
    padding: "30px",
    color: "#000",
    marginTop: "20px", 
    borderRadius: "12px",
    boxShadow: "0 8px 20px rgba(0,0,0,0.15)"
  }}
>{/* HEADER / LOGO */}
          <div className="insight-card full" style={{ textAlign: "center" }}>
            <h2>🌾 SmartCrop AI</h2>
            <p>AI Powered Agriculture Intelligence Report</p>
          </div>


          {/* SUMMARY */}
          <div className="insight-card full">
            <h3>📊 Crop Summary</h3>
            <p><b>Crop:</b> {cropName}</p>
            <p><b>Soil:</b> {soilType}</p>
          </div>


          {/* YIELD */}
          <div className="insight-card">
            <h3>🌾 Yield Prediction</h3>
            <p className="metric">
              {yieldData.expectedYield} tons
            </p>
          </div>


          {/* PROFIT */}
          <div className="insight-card">
            <h3>💰 Profit Estimate</h3>
            <p className="metric">
              ₹{yieldData.profitEstimate}
            </p>
          </div>


          {/* CHART */}
          {/* CHART */}
<div className="insight-card full">

  <h3>📊 Yield & Profit Visualization</h3>

  {/* 🔥 IMPORTANT ID */}
  <div
    id="chart-section"
    style={{
      background: "#ffffff",
      padding: "20px",
      borderRadius: "10px"
    }}
  >

    <ResponsiveContainer width="100%" height={300}>
      <BarChart data={chartData}>
        <CartesianGrid strokeDasharray="3 3" />
        <XAxis dataKey="name" />
        <YAxis />
        <Tooltip />
        <Bar dataKey="value" />
      </BarChart>
    </ResponsiveContainer>

  </div>

</div>


          {/* FERTILIZER */}
          <div className="insight-card">
            <h3>🌿 Fertilizer Advice</h3>
            <p>{fertilizerData.recommendation}</p>
          </div>


          {/* IRRIGATION */}
          <div className="insight-card">
            <h3>💧 Irrigation Plan</h3>
            <p><b>Method:</b> {irrigationData.irrigationMethod}</p>
            <p><b>Schedule:</b> {irrigationData.schedule}</p>
          </div>


          {/* SMART ADVICE */}
          <div className="insight-card full highlight">
            <h3>🤖 Smart AI Advice</h3>

            <p>
              For <b>{cropName}</b> grown in <b>{soilType}</b> soil,
              follow recommended fertilizer and irrigation plan
              to maximize yield and profit.
            </p>

          </div>

        </div>
      )}

    </div>
  );
}
