import React from "react";
import "../styles/sidebar.css";

export default function Sidebar() {
  return (
    <>
      <div className="nav-parent">
        <div className="nav-list">
          <div className="nav-item"> Email </div>
          <div className="nav-item"> Task </div>
          <div className="nav-item"> Project </div>
          <div className="nav-item"> Teams </div>
        </div>
      </div>
    </>
  );
}
