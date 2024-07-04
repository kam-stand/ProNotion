import "./search_bar.css";
import { FcSearch } from "react-icons/fc";
import { FcEmptyFilter } from "react-icons/fc";
import { FcFilledFilter } from "react-icons/fc";
import { useState } from "react";
export default function SearchBar() {
  // state management for the filer icon
  const [filter, setFilter] = useState(false);
  const toggleFilter = () => {
    setFilter(!filter);
  };

  return (
    <>
      <div className="search-container">
        <div className="search-function-container">
          <div className="search">
            <FcSearch className="search-icon" size={30} />
          </div>
          <div className="search">
            <input type="text" placeholder="Search for..." />
          </div>
          <div className="search">
            {filter ? (
              <FcFilledFilter
                size={30}
                className="search-icon"
                onClick={toggleFilter}
              />
            ) : (
              <FcEmptyFilter
                size={30}
                className="search-icon"
                onClick={toggleFilter}
              />
            )}
          </div>
        </div>
      </div>
    </>
  );
}
