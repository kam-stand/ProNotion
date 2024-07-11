import "./pages_styling_theme/pricing.css";
import { FaCcPaypal } from "react-icons/fa6";
import { FaCcVisa } from "react-icons/fa6";
import { FaCcMastercard } from "react-icons/fa6";
import { FaUserAstronaut } from "react-icons/fa6";
import { FaUserSecret } from "react-icons/fa6";
import { PiUsersThree } from "react-icons/pi";
import Header from "../header/header";
import Footer from "../footer/footer";
export default function Pricing() {
  return (
    <>
      <Header />
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
                <p>1 user</p>
                <div>
                  <ol>
                    <ul>Read and organize emails</ul>
                    <ul>Create tasks</ul>
                    <ul>Automation and rules</ul>
                    <ul>
                      3 project <b>resources</b>
                    </ul>
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
                <p>up to 5 teams members</p>
                <div>
                  <ol>
                    <ul>Assign task</ul>
                    <ul>Track projects</ul>
                    <ul>Filter and label emails</ul>
                    <ul>
                      Organize with <b>ProNotion Calendar</b>
                    </ul>
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
                    <ul>Reminders</ul>
                    <ul>
                      <b>CRM</b> tracking
                    </ul>
                    <ul>
                      <b>Automated</b> response templates
                    </ul>
                    <ul>
                      <b>ProNotion</b> Chrome Extension
                    </ul>
                  </ol>
                </div>
              </div>
              <button className="button">Purchase</button>
            </div>
          </div>
        </div>
        <h2>Testimonial</h2>
        <div className="testimonial">
          <div className="card">
            <FaUserAstronaut size="100px" />
          </div>
          <div className="response">
            <h3>Awesome tool. Keeps me close to my customers.</h3>
          </div>

          <div className="card">
            <FaUserSecret size="100px" />
          </div>
          <div className="response">
            <h3>
              <b>Productive. Efficient. Easy.</b>
            </h3>
          </div>

          <div className="card">
            <PiUsersThree size="100px" />
          </div>
          <div className="response">
            <h3>
              My teams is <b>organized</b> and much more aligned thanks to
              ProNotion.
            </h3>
          </div>
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
      {/* <div className="img">
        <img
          height="150px"
          alt="img1"
          width="fit-content"
          src="https://images.thdstatic.com/productImages/d876ff26-5e8e-4585-98e5-9e50c621f25f/svn/black-wall-sculptures-wa1748w-64_600.jpg"
        />
        <img
          alt="img2"
          height="170px"
          width="fit-content"
          src="https://img.fruugo.com/product/7/87/969719877_max.jpg"
        />
      </div> */}
      <Footer />
    </>
  );
}
