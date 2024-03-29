import logo from "../../images/notion.png"

export default function Header(){
    return(
        <>
        <div className ="header">
            <div className="logo">
                <img
                alt="logo"
                className="notion"
                src={logo}
                />
            </div>
            <nav className="navigation">
            <ul>
                <li>Home</li>
                <li>About us</li>
                <li>Tasks</li>
                <li>Calendar</li>
            </ul>
            </nav>
        </div>
        </>
    );
}