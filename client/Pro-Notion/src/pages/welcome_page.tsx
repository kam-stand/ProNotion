import { useNavigate } from "react-router-dom";
import "./styles/welompe_page.css";

export default function WelcomePage() {
  const navigate = useNavigate();

  return (
    <div className="WelcomePage">
      <div className="welcome-header">
        <h1>Welcome to Pro Notion!</h1>
        <span className="subtitle">Your AI-powered Notion Assistant</span>
        <p>
          Pro Notion helps you manage tasks, set reminders, and automate your
          workflow within Notion.
        </p>
        <button onClick={() => navigate("/home")}>Go to Home</button>
      </div>
    </div>
  );
}
