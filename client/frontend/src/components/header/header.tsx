import "./header.css";
export default function Header() {
  return (
    <div className="Header">
      <div className="logo">
        <h1>ProNotion</h1>
      </div>
      <div className="Header_nav">
        <div className="Header_nav_item">
          <a href="/Home">Home</a>
          <a href="About">About</a>
          <a href="/pricing">Pricing</a>
        </div>
      </div>
    </div>
  );
}
