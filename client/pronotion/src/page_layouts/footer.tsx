import React from "react";
import "../styles/footer.css";

export default function Footer() {
  return (
    <>
      <div className="footer-parent">
        <div className="logo">
          <img
            className="logo-image"
            src={require("../assets/pronotion-high-resolution-logo-black.png")}
            alt="ProNotion Logo"
          />
        </div>
        <div className="social-media-links">
          <a href="https://www.linkedin.com/in/kamrul-hassan-9a97a71b2?trk=public_profile_browsemap_profile-result-card_result-card_full-click">
            <img src={require("../assets/download.png")} alt="LinkedIn" />
          </a>
          <a href="mailto:kh84590@gmail.com">
            <img src={require("../assets/gmail.png")} alt="Gmail" />
          </a>
          <a href="https://github.com/kam-stand/ProNotion">
            <img src={require("../assets/github.png")} alt="GitHub" />
          </a>
        </div>

        <div>
          <div className="utils">
            <a href="/about">About</a>
            <a href="/contact">Contact</a>
            <a href="/terms">Terms</a>
            <a href="/privacy">Privacy</a>
          </div>
        </div>
      </div>
    </>
  );
}
