import React from "react";

const Login = () => {
  return (
    <div className="login">
      <h1>Login</h1>
      <input type="text" placeholder="Email" />
      <input type="password" placeholder="Password" />
      <button>Login</button>
    </div>
  );
};

const Signup = () => {
  return (
    <div className="signup">
      <h1>Signup</h1>
      <input type="text" placeholder="Email" />
      <input type="password" placeholder="Password" />
      <input type="password" placeholder="Confirm Password" />
      <button>Signup</button>
    </div>
  );
};

export default function AuthPage() {
  const [auth, setAuth] = React.useState<null | "login" | "signup">(null);

  const handleAuth = (event: React.MouseEvent<HTMLButtonElement>) => {
    setAuth(event.currentTarget.innerText.toLowerCase() as "login" | "signup");
  };

  return (
    <div className="auth-parent">
      <h1>Join us at ProNotion!!</h1>
      <div className="auth-button">
        <button onClick={handleAuth}>Login</button>
        <button onClick={handleAuth}>Signup</button>
      </div>
      {auth === "login" && <Login />}
      {auth === "signup" && <Signup />}
    </div>
  );
}
