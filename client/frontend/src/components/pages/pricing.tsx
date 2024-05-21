import "./pages_styling_theme/pricing.css";
import { FaCcPaypal } from "react-icons/fa6";
import { FaCcVisa } from "react-icons/fa6";
import { FaCcMastercard } from "react-icons/fa6";

export default function Pricing() {
  return (
    <>
      <div className="Parent">
        <div className="header">
          <h1>Pricing</h1>
        </div>
        <div className="pricing">
          <div className="card">1</div>
          <div className="card">2</div>
          <div className="card">3</div>
        </div>
        <h3>Testimonial</h3>
        <div className="testimonial">
          <div className="card">1</div>
          <div className="card">2</div>
          <div className="card">3</div>
        </div>
        <h3>Payments</h3>
        <div className="payments">
          <div className="card">
            <FaCcPaypal size="80px" />
          </div>
          <div className="card">
            <FaCcVisa size="80px" />
          </div>
          <div className="card">
            <FaCcMastercard size="80px" />
          </div>
        </div>
      </div>
    </>
  );
}
