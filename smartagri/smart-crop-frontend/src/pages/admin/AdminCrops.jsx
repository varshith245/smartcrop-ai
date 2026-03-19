import { useEffect, useState } from "react"
import {
  getAllCrops,
  deleteCrop,
  updateCrop
} from "../../api/crop.api"
import { useNavigate } from "react-router-dom"

export default function AdminCrops() {

  const [crops, setCrops] = useState([])
  const [editingId, setEditingId] = useState(null)
  const [editData, setEditData] = useState({})
  const navigate = useNavigate()

  // ==============================
  // FETCH CROPS
  // ==============================
  useEffect(() => {
    fetchCrops()
  }, [])

  const fetchCrops = async () => {
    const res = await getAllCrops()
    setCrops(res.data)
  }

  // ==============================
  // DELETE
  // ==============================
  const handleDelete = async (id) => {

    if (!window.confirm("Delete this crop?")) return

    await deleteCrop(id)

    setCrops(prev =>
      prev.filter(c => c.id !== id)
    )
  }

  // ==============================
  // START EDIT
  // ==============================
  const startEdit = (crop) => {
    setEditingId(crop.id)
    setEditData(crop)
  }

  // ==============================
  // SAVE UPDATE
  // ==============================
 const handleUpdate = async () => {

  try {

    const res = await updateCrop(editingId, {
      name: editData.name,
      season: editData.season,
      yieldAmount: Number(editData.yieldAmount),
      farmId: editData.farmId
    });

    setCrops(prev =>
      prev.map(c =>
        c.id === editingId ? res.data : c
      )
    );

    setEditingId(null);

  } catch (error) {
    console.error("Update failed:", error);
    alert("Update failed. Check console.");
  }
};

  // ==============================
  // UI
  // ==============================
  return (
    <div className="min-h-screen bg-gradient-to-br from-slate-900 to-teal-900 p-8 text-white">

      {/* HEADER */}
      <div className="flex justify-between mb-8">
        <h1 className="text-3xl font-bold">
          🌾 Crop Management
        </h1>

        <div className="bg-white/10 px-6 py-3 rounded-xl">
          Total Crops: {crops.length}
        </div>
      </div>

      {/* GRID */}
      <div className="grid md:grid-cols-3 gap-8">

        {crops.map(crop => (

          <div
            key={crop.id}
            className="bg-white/10 p-6 rounded-2xl shadow-xl"
          >

            {/* NAME */}
            {editingId === crop.id ? (
              <input
                value={editData.name}
                onChange={e =>
                  setEditData({
                    ...editData,
                    name: e.target.value
                  })
                }
                className="w-full p-2 rounded bg-slate-800 mb-3"
              />
            ) : (
              <h2 className="text-2xl font-bold text-green-400 mb-3">
                {crop.name}
              </h2>
            )}

            {/* DETAILS */}
            {editingId === crop.id ? (
              <>
                <input
                  value={editData.season}
                  onChange={e =>
                    setEditData({
                      ...editData,
                      season: e.target.value
                    })
                  }
                  className="w-full p-2 rounded bg-slate-800 mb-2"
                />

                <input
                  type="number"
                  value={editData.yieldAmount}
                  onChange={e =>
                    setEditData({
                      ...editData,
                      yieldAmount: e.target.value
                    })
                  }
                  className="w-full p-2 rounded bg-slate-800"
                />
              </>
            ) : (
              <>
                <p>🌱 Season: {crop.season}</p>
                <p>📊 Yield: {crop.yieldAmount} tons</p>
                <p>🏡 Farm ID: {crop.farmId}</p>
              </>
            )}

            {/* BUTTONS */}
            <div className="flex gap-2 mt-6">

              <button
                onClick={() =>
                  navigate(`/admin/crops/${crop.id}/analytics`)
                }
                className="flex-1 bg-emerald-500 py-2 rounded"
              >
                Analytics
              </button>

              {editingId === crop.id ? (
                <button
                  onClick={handleUpdate}
                  className="flex-1 bg-yellow-500 py-2 rounded"
                >
                  Save
                </button>
              ) : (
                <button
                  onClick={() => startEdit(crop)}
                  className="flex-1 bg-blue-500 py-2 rounded"
                >
                  Edit
                </button>
              )}

              <button
                onClick={() => handleDelete(crop.id)}
                className="flex-1 bg-red-500 py-2 rounded"
              >
                Delete
              </button>

            </div>

          </div>

        ))}

      </div>

    </div>
  )
}