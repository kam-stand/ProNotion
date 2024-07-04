import React from "react";
import { BsInboxes } from "react-icons/bs";
import { RiTeamLine } from "react-icons/ri";
import { PiHammer } from "react-icons/pi";
import { BiTask } from "react-icons/bi";
import "./sidebar_navigation.css";
export default function SidebarNavigation() {
  return (
    <div className="sidebar-navigation">
      <div className="sidebar-navigation-item">
        <BsInboxes size={30} />
        <h2>Inbox</h2>
      </div>
      <div className="sidebar-navigation-item">
        <BiTask size={30} />
        <h2>Tasks</h2>
      </div>
      <div className="sidebar-navigation-item">
        <RiTeamLine size={30} />
        <h2>Contacts</h2>
      </div>
      <div className="sidebar-navigation-item">
        <PiHammer size={30} />
        <h2>Projects</h2>
      </div>
    </div>
  );
}
