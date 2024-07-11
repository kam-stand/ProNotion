import MainSection from "../../page_layout/home_page/main_section/main_section";
import SearchBar from "../../page_layout/home_page/search_bar/search_bar";
import SidebarNavigation from "../../page_layout/home_page/sidebar_navigation/sidebar_navigation";
import "../pages_styling_theme/home.css";
export default function HomePage() {
  return (
    <>
      <section className="Searchbar">
        <SearchBar />
      </section>
      <section className="SidebarNavigation">
        <SidebarNavigation />
      </section>
      <section className="MainContent">
        <MainSection />
      </section>
    </>
  );
}
