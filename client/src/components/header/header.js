import React from "react";
export default function Header() {
    return (
        <div className="header">
            <div className="header-logo">
                <div className="logo-wrapper">
                    <div className="logo">
                    </div>
                </div>
            </div>
            <div className="header-nav">
                <ul>
                    <li>Home</li>
                    <li>About Us</li>
                    <li>To Do</li>
                    <li>Calendar</li>
                </ul>
            </div>
        </div>
    );
}
