import "./App.css";
import AuthPage from "./pages/auth";
import WelcomePage from "./pages/welcome";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<WelcomePage />} />
        <Route path="/auth" element= {<AuthPage/>} />
      </Routes>
    </Router>
  );
}

export default App;
