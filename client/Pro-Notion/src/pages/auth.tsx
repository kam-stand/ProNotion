import "./styles.css/auth.css";
import hero from "../assets/hero.png";
import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom"; // ✅ import navigate

interface Errors {
  email: string;
  password: string;
  name?: string;
}

const validateEmail = (email: string): boolean => {
  return email.includes("@") && email.includes(".");
};

const validatePassword = (password: string): boolean => {
  const lengthOK = password.length >= 12;
  const specialChar = /[!@#$%^&*(),.?":{}|<>]/.test(password);
  const upperCase = /[A-Z]/.test(password);
  const number = /[0-9]/.test(password);
  return lengthOK && specialChar && upperCase && number;
};

const AuthPage: React.FC = () => {
  const navigate = useNavigate(); // ✅ initialize navigate
  const [auth, setAuth] = useState<"login" | "signup">("login");
  const [email, setEmail] = useState<string>("");
  const [password, setPassword] = useState<string>("");
  const [name, setName] = useState<string>("");
  const [errors, setErrors] = useState<Errors>({
    email: "",
    password: "",
    name: "",
  });

  const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    const emailValid = validateEmail(email);
    const passwordValid = validatePassword(password);

    setErrors({
      email: emailValid ? "" : "Email must include '@' and '.'",
      password: passwordValid
        ? ""
        : "Password must be 12+ chars, include 1 special char, 1 uppercase letter, and 1 number",
      name: "",
    });

    if (!emailValid || !passwordValid) return;

    if (auth === "signup" && name.trim() === "") {
      setErrors((prev) => ({ ...prev, name: "Name is required." }));
      return;
    }

    try {
      if (auth === "signup") {
        const response = await axios.post(
          "http://localhost:8080/api/user/register",
          {
            name,
            email,
            password,
          }
        );
        if (response.status === 200) {
          localStorage.setItem("email", email); // ✅ save email
          localStorage.setItem("state", "home")

          navigate("/home"); // ✅ navigate to home
        }
      } else {
        const response = await axios.post(
          "http://localhost:8080/api/user/login",
          {
            email,
            password,
          }
        );
        if (response.status === 200) {
          localStorage.setItem("email", email); // ✅ save email
          navigate("/home"); // ✅ navigate to home
        }
      }
    } catch (err: any) {
      alert(
        err.response?.data?.message || err.response?.data || "An error occurred"
      );
    }
  };

  return (
    <div className="auth">
      <div className="auth-container">
        <img src={hero} alt="hero" className="hero-image" />
        <div className="auth-buttons">
          <button
            type="button"
            onClick={() => setAuth("login")}
            className={auth === "login" ? "active" : ""}
          >
            Login
          </button>
          <button
            type="button"
            onClick={() => setAuth("signup")}
            className={auth === "signup" ? "active" : ""}
          >
            Sign up
          </button>
        </div>
        <form onSubmit={handleSubmit} className="auth-form">
          {auth === "signup" && (
            <>
              <input
                type="text"
                placeholder="Name"
                value={name}
                onChange={(e: React.ChangeEvent<HTMLInputElement>) =>
                  setName(e.target.value)
                }
              />
              {errors.name && <small className="error">{errors.name}</small>}
            </>
          )}

          <input
            type="email"
            placeholder="Email"
            value={email}
            onChange={(e: React.ChangeEvent<HTMLInputElement>) =>
              setEmail(e.target.value)
            }
          />
          {errors.email && <small className="error">{errors.email}</small>}

          <input
            type="password"
            placeholder="Password"
            value={password}
            onChange={(e: React.ChangeEvent<HTMLInputElement>) =>
              setPassword(e.target.value)
            }
          />
          {errors.password && (
            <small className="error">{errors.password}</small>
          )}

          <button type="submit">{auth === "login" ? "➜" : "➜"}</button>
        </form>
      </div>
    </div>
  );
};

export default AuthPage;
