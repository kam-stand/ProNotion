import { BsFilterCircle } from "react-icons/bs";
import "../styles/header.css";
export default function Header() {
  return (
    <>
      <div className="header-parent">
        <div>
          <BsFilterCircle className="header-filter" size={36} />
        </div>
        <div>
          <h1>ProNotion</h1>
        </div>
        <div>
          <div className="header-links">
            <a href="/login">Login</a>
            <a href="/home">Home</a>
            <a href="/profile">Profile</a>
          </div>
        </div>
      </div>
    </>
  );
}
