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
        <div className="testimonial">
          <div className="card">1</div>
          <div className="card">2</div>
          <div className="card">3</div>
        </div>
        <div className="payments">
          <div className="card">1</div>
          <div className="card">2</div>
          <div className="card">3</div>
        </div>
      </div>
    </>
  );
}
/**
 * 1. 3 cards
 * 2. pricing on each cards
 * 3. for each card, there is a button
 * 3.1 the button displays the text "Select"
 * 4. when the button is clicked, it will redirect to the payment page
 * 5. the payment page will have a form to fill in the payment details
 * 6. the payment page will have a button to submit the payment
 */
