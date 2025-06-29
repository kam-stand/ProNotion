import "./App.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import WelcomePage from "./pages/welcome_page";
import HomePage from "./pages/home_page";
import AuthPage from "./pages/auth_page";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<WelcomePage />} />
        <Route path="/home" element={<HomePage />} />
        <Route path="auth" element={<AuthPage />} />
      </Routes>
    </Router>
  );
}

export default App;
