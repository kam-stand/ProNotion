import "./styles.css/auth.css";
import hero from "../assets/hero.png";
import { useState } from "react";

export default function AuthPage() {
  const [auth, setAuth] = useState("login");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [errors, setErrors] = useState({ email: "", password: "" });
  const [name, setName] = useState("");


  const validateEmail = (email:string) => {
    return email.includes("@") && email.includes(".");
  };

  const validatePassword = (password:string) => {
    const lengthOK = password.length >= 12;
    const specialChar = /[!@#$%^&*(),.?":{}|<>]/.test(password);
    const upperCase = /[A-Z]/.test(password);
    const number = /[0-9]/.test(password);
    return lengthOK && specialChar && upperCase && number;
  };

  const handleSubmit = (e:any) => {
    e.preventDefault();
    const emailValid = validateEmail(email);
    const passwordValid = validatePassword(password);

    setErrors({
      email: emailValid ? "" : "Email must include '@' and '.'",
      password: passwordValid
        ? ""
        : "Password must be 12+ chars, include 1 special char, 1 uppercase letter, and 1 number",
    });

    if (emailValid && passwordValid) {
  console.log("Submitting", {
    auth,
    ...(auth === "signup" && { name }),
    email,
    password
  });

  if (auth === "signup" && name.trim() === "") {
  setErrors((prev) => ({ ...prev, name: "Name is required." }));
  return;
}

}

  };

  return (
    <div className="auth">
      <div className="auth-container">
        <img src={hero} alt="hero" className="hero-image" />
        <div className="auth-buttons">
          <button onClick={() => setAuth("login")} className={auth === "login" ? "active" : ""}>
            Login
          </button>
          <button onClick={() => setAuth("signup")} className={auth === "signup" ? "active" : ""}>
            Sign up
          </button>
        </div>
<form onSubmit={handleSubmit} className="auth-form">
  {auth === "signup" && (
    <input
      type="text"
      placeholder="Name"
      value={name}
      onChange={(e) => setName(e.target.value)}
    />
  )}

  <input
    type="email"
    placeholder="Email"
    value={email}
    onChange={(e) => setEmail(e.target.value)}
  />
  {errors.email && <small className="error">{errors.email}</small>}

  <input
    type="password"
    placeholder="Password"
    value={password}
    onChange={(e) => setPassword(e.target.value)}
  />
  {errors.password && <small className="error">{errors.password}</small>}

  <button type="submit">{auth === "login" ? "Log In" : "Sign Up"}</button>
</form>

      </div>
    </div>
  );
}
