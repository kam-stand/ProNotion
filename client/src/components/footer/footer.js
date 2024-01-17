import logo from "../../images/notion2.png"
export default function Footer(){
    return(
        <>
        <div className ="footer">
            <div className="logo">
                <img
                alt="logo"
                className="notion"
                src={logo}
                />
            </div>
            <nav className="navigation">
            <ul>
                <li>Purchase</li>
                <li>Address</li>
                <li>Contact</li>
            </ul>
            </nav>
        </div>
        
        
        </>
    )
}