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
          <div className="card">
            <div className="price-context">
              <h1>Basic</h1>
              <h2>$10/month</h2>
              <div className="info">
                <p>5 users included</p>
                <div>
                  <ol>
                    <ul>basic feature</ul>
                    <ul>not included feature</ul>
                    <ul>not included feature</ul>
                    <ul>not included feature</ul>
                  </ol>
                </div>
              </div>
              <button className="button">Purchase</button>
            </div>
          </div>
          <div className="card">
            <div className="price-context">
              <h1>Professional</h1>
              <h2>$20/month</h2>
              <div className="info">
                <p>5 users included</p>
                <div>
                  <ol>
                    <ul>Professional feature</ul>
                    <ul>Professional feature</ul>
                    <ul>Professional feature</ul>
                    <ul>Professional feature</ul>
                  </ol>
                </div>
              </div>
              <button className="button">Purchase</button>
            </div>
          </div>
          <div className="card">
            <div className="price-context">
              <h1>Enterprise</h1>
              <h2>$50/month</h2>
              <div className="info">
                <p>100+ users included</p>
                <div>
                  <ol>
                    <ul>Enterprise feature</ul>
                    <ul>Enterprise feature</ul>
                    <ul>Enterprise feature</ul>
                    <ul>Enterprise feature</ul>
                  </ol>
                </div>
              </div>
              <button className="button">Purchase</button>
            </div>
          </div>
        </div>
        <h2>Testimonial</h2>
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
      <div className="img">
        <img
          height="210px"
          alt="img1"
          width="fit-content"
          src="https://images.thdstatic.com/productImages/d876ff26-5e8e-4585-98e5-9e50c621f25f/svn/black-wall-sculptures-wa1748w-64_600.jpg"
        />
        <img
          alt="img2"
          height="200px"
          width="fit-content"
          src="https://img.fruugo.com/product/7/87/969719877_max.jpg"
        />
      </div>
    </>
  );
}
