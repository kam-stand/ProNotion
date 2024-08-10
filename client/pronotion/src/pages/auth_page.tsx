import axios from "axios";
import React, { useState } from "react";
import "../styles/auth_page.css";
export default function AuthPage() {
  const [auth, setAuth] = useState<null | "login" | "signup">(null);

  const handleAuth = (event: React.MouseEvent<HTMLButtonElement>) => {
    const option = event.currentTarget.innerText.toLowerCase();
    setAuth(option as "login" | "signup");
  };

  return (
    <div className="auth-parent">
      <h1>Join us at ProNotion</h1>
      <div className="button">
        <div className="auth">
          <p>Returning Users</p>
          <button onClick={handleAuth}>login</button>
        </div>
        <div className="auth">
          <p>Create an account</p>
          <button onClick={handleAuth}>Signup</button>
        </div>
      </div>
      {auth === "login" ? (
        <LoginComponent />
      ) : auth === "signup" ? (
        <SignupComponent />
      ) : (
        <></>
      )}
      <div className="img">
        <img
          className="auth-img"
          sizes="(max-width: 767px) 100vw, (max-width: 1023px) 728px, 728px"
          src="data:image/jpeg;base64,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jRdC/PurhgLt5nTOWyxczSmVWKlMpGZQyghn0OvBzIEsE7BszW0LiGIBIgjX2HUezpUmlKCNjmZbbm2JcA5RE6+yqn6TiQ5Vxw6AuiMxGlskqANdWYdepgZDN/Sgz307FacBnI5jI4BdbdtgORgFmuDmOUZjGtjhHdn1ZimQEZkKktmYGQQCIAXTxnqKsKUEbHO623KCWjhAE6+yqi9isUucBQWUiIVspAtFiQcuvGMuh15cPOtBSgpDib4IkHV3ygW2aQLgVQxAGQZJMnvmYBB4WsZi8qzb1KkH8W3CzLbKsTIlVJcFYnpPCSdFSgz74/FTItGJBHAZKqj5xo2jFkXKTE5wPGulvGXzu8wYE3Atxd28KsPBDhSDMIT3TBK1eUoFZ98Vi1Ctuw0hzlymfQChh0li/XQQTyNaClBQtjb8PAYwHKE2XlyFQgMsSgzFwJAmB3GVzHXwdFZhwnS28+KyUHESdDGWAQchhjfUoFKUoKzaV68rLulBGR2aQSJUpA01kgvA6keBqC+NxQU8BzgNCi2xVoa4JLjQHKtsgaTPLiAXQ0oKq01/eKGPCHymACCN2rTmgenmWYHdVrSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlApSlB//Z"
          alt="auth"
        />
      </div>
    </div>
  );
}

const login = async (email: string, password: string) => {
  try {
    const response = await axios.post("http://localhost:8080/auth/login", {
      email,
      password,
    });
    console.log(response.data);
  } catch (error) {
    console.error(error);
  }
};

const signup = async (
  email: string,
  password: string,
  firstName: string,
  lastName: string,
  role: string
) => {
  try {
    const response = await axios.post("http://localhost:8080/auth/register", {
      email,
      password,
      firstName,
      lastName,
      role,
    });
    console.log(response.data);
    // the data we will receive is a JWT needs to be stored
    const token = response.data.accessToken;
    localStorage.setItem("token", token);
  } catch (error) {
    console.error(error);
  }
};

const setAuthToken = (token: string) => {
  if (token) {
    axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
  } else {
    delete axios.defaults.headers.common["Authorization"];
  }
};

const LoginComponent = () => {
  const [email, setEmail] = useState<string>("");
  const [password, setPassword] = useState<string>("");

  const handleLogin = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    if (email && password) {
      login(email, password);
      const token = localStorage.getItem("jwtToken");
      window.location.href = "/home";
      if (token) {
        setAuthToken(token);
      }
    } else {
      alert("Please fill all fields");
    }
  };

  return (
    <div className="login-container">
      <h1>Login</h1>
      <form className="login-form" onSubmit={handleLogin}>
        <input
          type="email"
          placeholder="Email"
          className="login-input"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <input
          type="password"
          placeholder="Password"
          className="login-input"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <button className="login-button">Login</button>
      </form>
    </div>
  );
};

const SignupComponent = () => {
  const [email, setEmail] = useState<string>("");
  const [password, setPassword] = useState<string>("");
  const [firstName, setFirstName] = useState<string>("");
  const [lastName, setLastName] = useState<string>("");

  const handleRegistration = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    // check if all fields are filled
    if (email && password && firstName && lastName) {
      signup(email, password, firstName, lastName, "USER");
      // redirect them to the home page
      window.location.href = "/home";
    } else {
      alert("Please fill all fields");
    }
  };

  return (
    <>
      <div className="signup-parent">
        <h1>Signup</h1>
        <form onSubmit={handleRegistration}>
          <input
            type="email"
            placeholder="Email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
          <input
            type="password"
            placeholder="Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <input
            type="text"
            placeholder="First Name"
            value={firstName}
            onChange={(e) => setFirstName(e.target.value)}
          />
          <input
            type="text"
            placeholder="Last Name"
            value={lastName}
            onChange={(e) => setLastName(e.target.value)}
          />
          <button>Signup</button>
        </form>
      </div>
    </>
  );
};
