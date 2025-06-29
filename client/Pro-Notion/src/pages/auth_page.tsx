import React, { useState } from "react";
import "./styles/auth_page.css";

const AuthPage: React.FC = () => {
  const [mode, setMode] = useState<"login" | "signup">("login");
  const [form, setForm] = useState({ email: "", password: "", name: "" });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    // Handle login or signup logic here
    alert(
      mode === "login"
        ? `Logging in as ${form.email}`
        : `Signing up as ${form.name} (${form.email})`
    );
  };

  return (
    <div className="AuthPage">
      <div className="auth-header">
        <h1>{mode === "login" ? "Login" : "Sign Up"}</h1>
        <p>
          {mode === "login"
            ? "Welcome back! Please login to your account."
            : "Create a new account to get started."}
        </p>
        <div className="auth-toggle">
          <button
            className={mode === "login" ? "active" : ""}
            onClick={() => setMode("login")}
          >
            Login
          </button>
          <button
            className={mode === "signup" ? "active" : ""}
            onClick={() => setMode("signup")}
          >
            Sign Up
          </button>
        </div>
      </div>
      <form className="auth-form" onSubmit={handleSubmit}>
        {mode === "signup" && (
          <input
            type="text"
            name="name"
            placeholder="Full Name"
            value={form.name}
            onChange={handleChange}
            required
          />
        )}
        <input
          type="email"
          name="email"
          placeholder="Email"
          value={form.email}
          onChange={handleChange}
          required
        />
        <input
          type="password"
          name="password"
          placeholder="Password"
          value={form.password}
          onChange={handleChange}
          required
        />
        <button type="submit">{mode === "login" ? "Login" : "Sign Up"}</button>
      </form>
    </div>
  );
};

export default AuthPage;
