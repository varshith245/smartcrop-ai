import { Link, useNavigate } from "react-router-dom";
import ThemeSwitcher from "./ThemeSwitcher";

export default function Navbar() {

  const navigate = useNavigate();

  const token = localStorage.getItem("token");
  const role = localStorage.getItem("role");

  const handleLogout = () => {
    localStorage.clear();
    navigate("/");
  };

  return (
    <div className="navbar">

      {/* ===== LOGO ===== */}
      <div className="logo">
        🌱 SmartCrop AI
      </div>

      {/* ===== CENTER NAV ===== */}
      <div className="nav-center">

        <Link to="/">Home</Link>

        {/* ===== ADMIN NAV ===== */}
        {token && role === "ADMIN" && (
          <>
            <Link to="/admin">
              Dashboard
            </Link>

           

            {/* ✅ ADD MAP LINK HERE */}
            <Link to="/admin/farms-map">
              🌍 Farms Map
            </Link>
          </>
        )}

        {/* ===== FARMER NAV ===== */}
        {token && role === "FARMER" && (
          <>
            <Link to="/farmer">
              Dashboard
            </Link>

            <Link to="/farmer/farms">
              🌾 My Farms
            </Link>
          </>
        )}

      </div>

      {/* ===== RIGHT NAV ===== */}
      <div className="nav-right">

        <ThemeSwitcher />

        {!token ? (
          <>
            <Link to="/login">Login</Link>
            <Link to="/register">Register</Link>
          </>
        ) : (
          <button onClick={handleLogout}>
            Logout
          </button>
        )}

      </div>

    </div>
  );
}