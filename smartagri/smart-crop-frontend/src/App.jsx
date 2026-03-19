import { BrowserRouter, Routes, Route } from "react-router-dom";

import Navbar from "./components/Navbar";

// ================= AUTH PAGES =================
import Home from "./pages/Home";
import Login from "./pages/Login";
import Register from "./pages/Register";
import VerifyOtp from "./pages/VerifyOtp";

// ================= DASHBOARDS =================
import FarmerDashboard from "./dashboard/FarmerDashboard";
import AdminDashboard from "./dashboard/AdminDashboard";

// ================= ADMIN PAGES =================
import AdminUsers from "./pages/admin/AdminUsers";
import AdminFarms from "./pages/admin/AdminFarms";
import AdminCrops from "./pages/admin/AdminCrops";
import AdminDiseases from "./pages/admin/AdminDiseases";
import AdminAnalytics from "./pages/admin/AdminAnalytics";
import AdminSettings from "./pages/admin/AdminSettings";
import AdminIrrigation from "./pages/admin/AdminIrrigation";
import AdminFarmsMap from "./pages/admin/AdminFarmsMap";
import AdminCropAnalytics from "./pages/admin/AdminCropAnalytics";


// ================= FARMER PAGES =================
import MyFarms from "./pages/farmer/MyFarms";
import YieldPrediction from "./pages/farmer/YieldPrediction";
import YieldHistory from "./pages/farmer/YieldHistory";
import FertilizerAdvice from "./pages/farmer/FertilizerAdvice";
import IrrigationPlan from "./pages/farmer/IrrigationPlan";
import Insights from "./pages/farmer/InSights";

export default function App() {
  return (
    <BrowserRouter>

      {/* NAVBAR */}
      <Navbar />

      <Routes>

        {/* ================= PUBLIC ================= */}
        <Route path="/" element={<Home />} />

        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/verify" element={<VerifyOtp />} />

        {/* ================= DASHBOARDS ================= */}
        <Route path="/farmer" element={<FarmerDashboard />} />
        <Route path="/admin" element={<AdminDashboard />} />

        {/* ================= ADMIN MODULES ================= */}
        <Route path="/admin/users" element={<AdminUsers />} />
        <Route path="/admin/farms" element={<AdminFarms />} />
        <Route path="/admin/crops" element={<AdminCrops />} />
        <Route path="/admin/diseases" element={<AdminDiseases />} />
        <Route path="/admin/analytics" element={<AdminAnalytics />} />
        <Route path="/admin/settings" element={<AdminSettings />} />
        <Route path="/admin/irrigation" element={<AdminIrrigation />}/>
        <Route path="/admin/farms-map" element={<AdminFarmsMap />}/>
        <Route path="/admin/crops/:id/analytics" element={<AdminCropAnalytics />}/>
       

        {/* ================= FARMER MODULES ================= */}
        <Route path="/farmer/farms" element={<MyFarms />} />
        <Route path="/farmer/yield" element={<YieldPrediction />} />
        <Route path="/farmer/yield-history" element={<YieldHistory />} />
        <Route path="/farmer/fertilizer" element={<FertilizerAdvice />} />
        <Route path="/farmer/irrigation" element={<IrrigationPlan />} />
        <Route path="/farmer/insights" element={<Insights />} />
        

      </Routes>

    </BrowserRouter>
  );
}