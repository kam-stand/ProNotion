import { useState } from "react";
import "./styles.css/home.css";

export default function HomePage() {
  const [activeView, setActiveView] = useState("home");

  const renderContent = () => {
    switch (activeView) {
      case "tasks":
        return <div className="content-box">📝 Task Creation Form</div>;
      case "team":
        return <div className="content-box">👥 Team Management Panel</div>;
      case "email":
        return <div className="content-box">📧 Email Inbox / Composer</div>;
      default:
        return <div className="content-box">🏠 Welcome to the Home Page</div>;
    }
  };

  return (
    <div className="home-container">
      <header className="home-header">
        <h1>Dashboard</h1>
        <div className="header-icons">
          <span role="img" aria-label="notifications">🔔</span>
          <span role="img" aria-label="profile">👤</span>
        </div>
      </header>

      <aside className="sidebar">
        <button onClick={() => setActiveView("tasks")} title="Tasks">📝</button>
        <button onClick={() => setActiveView("team")} title="Team">👥</button>
        <button onClick={() => setActiveView("email")} title="Email">📧</button>
      </aside>

      <main className="main-content">
        {renderContent()}
      </main>
    </div>
  );
}
