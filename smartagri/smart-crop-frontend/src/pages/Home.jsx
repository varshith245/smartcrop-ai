export default function Home() {

  return (
    <div className="home-container">

      <h1>SmartCrop AI Platform</h1>

      <p className="home-intro">
        SmartCrop is an Artificial Intelligence powered agriculture assistant designed
        to help farmers increase productivity, reduce crop risks, and make data-driven
        farming decisions using modern machine learning and environmental analytics.
      </p>

      <div className="home-section">

        <h2>🌱 What SmartCrop Provides</h2>

        <div className="home-cards">

          <div className="card">
            🌾 AI Crop Yield Prediction  
            <p>Predict future crop output using historical and environmental data.</p>
          </div>

          <div className="card">
            🌦 Weather Intelligence  
            <p>Advanced weather analytics tailored for agriculture planning.</p>
          </div>

          <div className="card">
            🧪 Soil Health Analysis  
            <p>Evaluate soil nutrients and optimize fertilizer recommendations.</p>
          </div>

          <div className="card">
            🤖 Smart Crop Recommendation  
            <p>AI suggests best crops based on climate and soil conditions.</p>
          </div>

        </div>

      </div>

      <div className="home-section">
        <h2>🚀 Why SmartCrop Matters</h2>

        <p>
          SmartCrop bridges technology and agriculture by providing farmers with
          accessible AI tools that improve crop planning, reduce losses, and
          increase sustainable farming practices.
        </p>
      </div>

    </div>
  );
}

