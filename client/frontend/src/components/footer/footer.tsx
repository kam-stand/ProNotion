// creating a footer component
import "./footer.css";
export default function Footer() {
  return (
    <>
      <div className="Footer">
        <div className="Footer_logo">
          <img
            src="https://static1.makeuseofimages.com/wordpress/wp-content/uploads/2021/02/Notion-logo-1.png"
            alt="logo"
            width="150px"
          />
        </div>
        <div className="Footer_divider"></div>
        <div className="Footer_nav_item">
          <a href="/Email">Email</a>
          <a href="/Github">Github</a>
          <a href="/Linkedin">Linkedin</a>
        </div>
      </div>
    </>
  );
}
