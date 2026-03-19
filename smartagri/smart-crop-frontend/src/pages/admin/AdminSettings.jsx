import React, { useEffect, useState } from "react";
import { getSettings, saveSettings } from "../../api/settings.api";

export default function AdminSettings() {

  const [settings,setSettings] = useState({
    location:"",
    temperatureUnit:"Celsius",
    rainAlert:false,
    irrigationAuto:false,
    moistureThreshold:0,
    aiCrop:false,
    fertilizerAI:false,
    diseaseAlert:false
  });

  // LOAD SETTINGS FROM BACKEND
  useEffect(()=>{

    const load = async ()=>{

      try{
        const res = await getSettings();

        if(res.data){
          setSettings(res.data);
        }

      }catch(err){
        console.error("Settings load error",err);
      }

    };

    load();

  },[]);

  const update = (key,value)=>{
    setSettings(prev=>({
      ...prev,
      [key]:value
    }));
  };

  const save = async ()=>{

    try{
      await saveSettings(settings);
      alert("Settings saved");
    }catch(err){
      console.error(err);
    }

  };

  return (
    <div className="dashboard-wrapper">

      <h2>⚙ Platform Settings</h2>

      <div className="settings-grid">

        {/* WEATHER */}
        <div className="settings-card">

          <h3>🌦 Weather Settings</h3>

          <label>Default Farm Location</label>

          <input
            value={settings.location || ""}
            onChange={(e)=>update("location",e.target.value)}
          />

          <label>Temperature Unit</label>

          <select
            value={settings.temperatureUnit || "Celsius"}
            onChange={(e)=>update("temperatureUnit",e.target.value)}
          >
            <option>Celsius</option>
            <option>Fahrenheit</option>
          </select>

          <label>
            <input
              type="checkbox"
              checked={settings.rainAlert || false}
              onChange={()=>update("rainAlert",!settings.rainAlert)}
            />
            Rain Alerts
          </label>

        </div>

        {/* IRRIGATION */}
        <div className="settings-card">

          <h3>💧 Irrigation Automation</h3>

          <label>
            <input
              type="checkbox"
              checked={settings.irrigationAuto || false}
              onChange={()=>update("irrigationAuto",!settings.irrigationAuto)}
            />
            Enable Auto Irrigation
          </label>

          <label>Soil Moisture Threshold (%)</label>

          <input
            type="number"
            value={settings.moistureThreshold || 0}
            onChange={(e)=>update("moistureThreshold",e.target.value)}
          />

        </div>

        {/* AI */}
        <div className="settings-card">

          <h3>🤖 AI Recommendations</h3>

          <label>
            <input
              type="checkbox"
              checked={settings.aiCrop || false}
              onChange={()=>update("aiCrop",!settings.aiCrop)}
            />
            AI Crop Recommendation
          </label>

          <label>
            <input
              type="checkbox"
              checked={settings.fertilizerAI || false}
              onChange={()=>update("fertilizerAI",!settings.fertilizerAI)}
            />
            Fertilizer Suggestions
          </label>

          <label>
            <input
              type="checkbox"
              checked={settings.diseaseAlert || false}
              onChange={()=>update("diseaseAlert",!settings.diseaseAlert)}
            />
            Disease Prediction Alerts
          </label>

        </div>

      </div>

      <button className="btn-save" onClick={save}>
        Save All Settings
      </button>

    </div>
  );
}