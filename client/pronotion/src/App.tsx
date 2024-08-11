import AuthPage from "./pages/auth_page";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import WelcomePage from "./pages/welcome_page";
import PricingPage from "./pages/pricing_page";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<WelcomePage />} />
        <Route path="/auth" element={<AuthPage />} />
        <Route path="/price" element={<PricingPage />} />
      </Routes>
    </Router>
  );
}

export default App;
