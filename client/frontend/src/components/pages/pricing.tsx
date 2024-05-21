import "./pages_styling_theme/pricing.css";
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
          <div className="card">1</div>
          <div className="card">2</div>
          <div className="card">3</div>
        </div>
      </div>
    </>
  );
}
