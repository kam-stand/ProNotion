import React from "react";
import "./header.css";

export default function Header() {
  return (
    <div className="Header">
      <div className="logo">Logo</div>
      <div className="Header_nav">
        <div className="Header_nav_item">
          <a>Home</a>
        </div>
        <div className="Header_nav_item">
          <a>About</a>
        </div>
        <div className="Header_nav_item">
          <a>Pricing</a>
        </div>
      </div>
    </div>
  );
}
