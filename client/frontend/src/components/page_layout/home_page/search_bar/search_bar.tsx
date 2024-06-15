import { FaSearch } from "react-icons/fa";
import "./search_bar.css";
export default function SearchBar() {
  return (
    <div className="searchbar">
      <div className="search_wrapper">
        <div>
          <FaSearch className="search_icon" size={20} />
        </div>
        <div>
          <input type="text" className="search_input" placeholder="Search.." />
        </div>
      </div>
    </div>
  );
}
