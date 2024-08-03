import axios from "axios";
import React, { useState } from "react";

export default function AuthPage() {
  const [auth, setAuth] = useState<null | "login" | "signup">(null);

  const handleAuth = (event: React.MouseEvent<HTMLButtonElement>) => {
    const option = event.currentTarget.innerText.toLowerCase();
    setAuth(option as "login" | "signup");
  };

  return (
    <div className="auth-parent">
      <h1>Join us at ProNotion</h1>
      <p>Returning Users</p>
      <div className="button">
        <button onClick={handleAuth}>Login</button>
      </div>
      <p>Create an account</p>
      <div className="button">
        <button onClick={handleAuth}>Signup</button>
      </div>
      {auth === "login" ? (
        <LoginComponent />
      ) : auth === "signup" ? (
        <SignupComponent />
      ) : (
        <></>
      )}
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
  } catch (error) {
    console.error(error);
  }
};

const LoginComponent = () => {
  return (
    <>
      <h1>Login</h1>
      <form>
        <input type="email" placeholder="Email" />
        <input type="password" placeholder="Password" />
        <button>Login</button>
      </form>
    </>
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
    } else {
      alert("Please fill all fields");
    }
  };

  return (
    <>
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
    </>
  );
};
