import React from "react";
import "../styles/pricing_page.css";
import { RiMoneyDollarBoxLine } from "react-icons/ri";
export default function PricingPage() {
  return (
    <>
      <div className="price-parent">
        <div className="price-info-container">
          {pricing("Free!", "0", [
            "10 Users included",
            "2 GB of storage",
            "Email support",
            "Help center access",
          ])}
          {pricing("Pro", "15", [
            "20 Users included",
            "10 GB of storage",
            "Priority email support",
            "Help center access",
          ])}
          {pricing("Enterprise", "30", [
            "50 Users included",
            "30 GB of storage",
            "Phone and email support",
            "Help center access",
          ])}
        </div>
      </div>
    </>
  );
}

const pricing = (header: String, pricing: String, info: String[]) => {
  return (
    <div className="price-info">
      <div>
        <h1>
          {header}
          <RiMoneyDollarBoxLine size={36} />
        </h1>
        <div className="price">
          <h3>
            <button>
              Sign Up ${pricing}
              <span>/month</span>
            </button>
          </h3>
        </div>
        <div className="info">
          {info.map((item, index) => {
            return <p key={index}>{item}</p>;
          })}
        </div>
      </div>
    </div>
  );
};
