// import "../App.css"
import "./styles.css/welcome.css";
import test1 from "../assets/test1.png";
import test2 from "../assets/test2.png";
import test3 from "../assets/test4.jpeg";
import test5 from "../assets/test5.png";

import task1 from "../assets/task1.png";
import task2 from "../assets/task2.png";
import task3 from "../assets/task3.jpg";
const testimonials = [
  {
    image: test1,
    title: "OMG!",
    message:
      "ProNotion has been able to greatly reduce my anxiety in project management",
  },
  {
    image: test2,
    title: "Amazing!",
    message: "This tool is my daily go-to for staying on top of tasks",
  },
  {
    image: test3,
    title: "Love it!",
    message: "My team has never been more organized",
  },
];

const tasks = [
  {
    image: task1,
    title: "Communicate",
    message: "Seamlessly interacte and coordinate with team members",
  },
  {
    image: task2,
    title: "Project Management",
    message: "Manage large workloads with ease",
  },
  {
    image: task3,
    title: "Tasks",
    message: "Assign and manage your tasks with a simple to use UI",
  },
];

const pricingOptions = [
  {
    tier: "Free",
    price: "$0/mo",
    features: ["Unlimited task creation", "No reminders", "No teams"],
  },
  {
    tier: "Basic",
    price: "$5/mo",
    features: ["Task creation", "Reminders", "Up to 5 teams"],
  },
  {
    tier: "Premium",
    price: "$15/mo",
    features: ["Everything in Basic", "Email integration"],
  },
];
function PricingCardGrid() {
  return (
    <div className="card">
      {pricingOptions.map((option, index) => (
        <div key={index} className="card-item">
          <h3>{option.tier}</h3>
          <hr style={{ width: "60%", borderTop: "2px solid #ccc" }} />
          <p
            style={{ fontWeight: "bold", fontSize: "1.2rem", margin: "10px 0" }}
          >
            {option.price}
          </p>
          <div className="feature-list">
            {option.features.map((feature, i) => {
              const isNegative = feature.toLowerCase().includes("no ");
              return (
                <div key={i} className="feature-item">
                  <span className="emoji">{isNegative ? "❌" : "✅"}</span>
                  <span>{feature}</span>
                </div>
              );
            })}
          </div>
        </div>
      ))}
    </div>
  );
}

function TaskGrid() {
  return (
    <div className="card">
      {tasks.map((item, index) => (
        <div key={index} className="card-item">
          <img
            src={item.image}
            alt={`tasks-${index}`}
            style={{ width: "100px", height: "100px", borderRadius: "8px" }}
          />
          <h3>{item.title}</h3>
          <p>{item.message}</p>
        </div>
      ))}
    </div>
  );
}

function CardGrid() {
  return (
    <div className="card">
      {testimonials.map((item, index) => (
        <div key={index} className="card-item">
          <img
            src={item.image}
            alt={`testimonial-${index}`}
            style={{ width: "110px", height: "110px", borderRadius: "8px" }}
          />
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
        <button
          className="welcome-button"
          onClick={() => (window.location.href = "/auth")}
        >
          Get Started
        </button>
        <div className="welcome-info">
          <h1>Welcome to ProNotion!</h1>
          {<CardGrid />}
        </div>
        <div className="welcome-info">
          <h1>Manage tasks on the fly</h1>
          {<TaskGrid />}
        </div>
        <div className="welcome-info">
          <h1>Affordable Pricing</h1>
          {<PricingCardGrid />}
        </div>
      </div>
    </div>
  );
}
