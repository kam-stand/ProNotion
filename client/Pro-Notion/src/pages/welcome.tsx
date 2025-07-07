// import "../App.css"
import "./styles.css/welcome.css";
import test1 from "../assets/test1.png";
import test2 from "../assets/test2.png";
import test3 from "../assets/test4.jpeg";
import test5 from "../assets/test5.png";

const testimonials = [
  {
    image: test1,
    title: "OMG!",
    message: "ProNotion has been able to greatly reduce my anxiety in project management"
  },
  {
    image: test2,
    title: "Amazing!",
    message: "This tool is my daily go-to for staying on top of tasks"
  },
  {
    image: test3,
    title: "Love it!",
    message: "My team has never been more organized"
  },
  {
    image: test5,
    title: "A must-have",
    message: "Can't imagine working without ProNotion now"
  }
];

function CardGrid() {
  return (
    <div className="card">
      {testimonials.map((item, index) => (
        <div key={index} className="card-item">
          <img src={item.image} alt={`testimonial-${index}`} style={{ width: "100px", height: "100px", borderRadius: "8px" }} />
          <h3>{item.title}</h3>
          <p>{item.message}</p>
        </div>
      ))}
    </div>
  );
}
export default function WelcomePage() {
  return (
    <div className="welcome">
      <div className="welcome-sub">
        <div className="welcome-info">
          <h1>Welcome to ProNotion!</h1>
          <h2>The less Complicated Notion...</h2>
          {<CardGrid/>}
        </div>
        <div className="welcome-info">
            <h1>Manage tasks on the fly</h1>
        </div>
        <div className="welcome-info">
            <h1>Develop workflows</h1>
        </div>
        <div className="welcome-info">
            <h1>Affordable Pricing</h1>
        </div>
      </div>
    </div>
  );
}
