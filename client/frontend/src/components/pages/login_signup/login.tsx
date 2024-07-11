// this is the login page component
/*
1. users login in via email and password
2. users can also login in via google
  a. just create a google button
*/
import "../pages_styling_theme/login.css";
import React from "react";
export default function Login() {
  // create state for email and password
  const [email, setEmail] = React.useState("");
  const [password, setPassword] = React.useState("");

  // create a function to handle the login
  const handleLogin = (e: any) => {
    e.preventDefault();
    console.log(email, password);
  };

  return (
    <>
      <div className="login">
        <div>
          <h1>Welcome Back!</h1>
        </div>
        <div>
          <form>
            <div>
              <input type="email" placeholder="Email" />
            </div>
            <div>
              <input type="password" placeholder="Password" />
            </div>
          </form>
          <div className="buttons">
            <div>
              <button onClick={(e) => handleLogin}>Login</button>
            </div>
            <div>
              <button>Sign Up</button>
            </div>
            <div>
              <button>Google</button>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
