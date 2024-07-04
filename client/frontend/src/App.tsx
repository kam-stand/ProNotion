import "./App.css";

import Pricing from "./components/pages/pricing";
import About from "./components/pages/about";
import Landing from "./components/pages/landing";
import Home from "./components/pages/home_page/home_page";
import { BrowserRouter, Routes, Route } from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/pricing" element={<Pricing />} />
        <Route path="/about" element={<About />} />
        <Route path="/landing" element={<Landing />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
