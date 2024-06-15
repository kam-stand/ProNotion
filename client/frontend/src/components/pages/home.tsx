import React from "react";
import SearchBar from "../page_layout/home_page/search_bar/search_bar";
import "./pages_styling_theme/home.css";

export default function Home() {
  return (
    <div className="parent">
      <div className="search">
        <SearchBar />
      </div>
      <div className="sidebar">Side bar</div>
      <div className="main-progress">
        <div className="main">Main Section</div>
        <div className="progress">Progress</div>
      </div>
    </div>
  );
}
