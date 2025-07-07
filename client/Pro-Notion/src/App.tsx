import "./App.css";
import AuthPage from "./pages/auth";
import HomePage from "./pages/home";
import WelcomePage from "./pages/welcome";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<WelcomePage />} />
        <Route path="/auth" element= {<AuthPage/>} />
        <Route path="/home" element={<HomePage/>} />
      </Routes>
    </Router>
  );
}

export default App;
