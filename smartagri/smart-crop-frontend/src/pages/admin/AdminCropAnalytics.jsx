import { useEffect, useState } from "react"
import { useParams ,useNavigate } from "react-router-dom"
import { getAllCrops } from "../../api/crop.api"
import {
  LineChart,
  Line,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  ResponsiveContainer
} from "recharts"

export default function AdminCropAnalytics() {

  const { id } = useParams()
   const navigate = useNavigate()
  const [crop, setCrop] = useState(null)

  useEffect(() => {
    getAllCrops().then(res => {
      const found = res.data.find(c => c.id === Number(id))
      setCrop(found)
    })
  }, [id])

  if (!crop) {
    return (
      <div className="min-h-screen bg-slate-900 text-white p-8">
        Loading...
      </div>
    )
  }

  // Fake growth trend data (simulate real analytics)
  const chartData = [
    { month: "Jan", yield: crop.yieldAmount - 1 },
    { month: "Feb", yield: crop.yieldAmount - 0.5 },
    { month: "Mar", yield: crop.yieldAmount },
    { month: "Apr", yield: crop.yieldAmount + 0.3 },
    { month: "May", yield: crop.yieldAmount + 0.5 }
  ]

  const performance =
    crop.yieldAmount >= 5
      ? "Excellent"
      : crop.yieldAmount >= 3
      ? "Good"
      : "Low"

  return (
    <div className="min-h-screen bg-gradient-to-br from-slate-900 to-teal-900 p-8 text-white">

      <h1 className="text-3xl font-bold mb-8">
        🌾 Crop Analytics Dashboard
      </h1>
      <button
  onClick={() => navigate(-1)}
  className="bg-gray-700 hover:bg-gray-600 px-4 py-2 rounded-lg"
>
  ← Back
</button>

      {/* INFO CARD */}
      <div className="bg-white/10 backdrop-blur-lg rounded-2xl p-6 shadow-xl mb-8">

        <h2 className="text-2xl font-bold text-green-400 mb-4">
          {crop.name}
        </h2>

        <div className="grid md:grid-cols-3 gap-6 text-sm">

          <div>
            <p className="text-gray-300">Season</p>
            <p className="font-semibold">{crop.season}</p>
          </div>

          <div>
            <p className="text-gray-300">Yield</p>
            <p className="font-semibold">
              {crop.yieldAmount} tons
            </p>
          </div>

          <div>
            <p className="text-gray-300">Performance</p>
            <p className="font-semibold text-emerald-400">
              {performance}
            </p>
          </div>

        </div>
      </div>

      {/* YIELD TREND CHART */}
      <div className="bg-white/10 backdrop-blur-lg rounded-2xl p-6 shadow-xl">

        <h2 className="text-xl font-semibold mb-4">
          📈 Yield Growth Trend
        </h2>

        <ResponsiveContainer width="100%" height={300}>
          <LineChart data={chartData}>
            <CartesianGrid strokeDasharray="3 3" />
            <XAxis dataKey="month" />
            <YAxis />
            <Tooltip />
            <Line
              type="monotone"
              dataKey="yield"
              stroke="#34d399"
              strokeWidth={3}
            />
          </LineChart>
        </ResponsiveContainer>

      </div>

    </div>
  )
}