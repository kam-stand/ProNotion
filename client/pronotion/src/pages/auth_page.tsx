import axios from "axios";
import { useState } from "react";
export default function AuthPage() {
  const [auth, setAuth] = useState("");
  return (
    <div className="auth-parent">
      <h1>Join us at ProNotion</h1>
      <p>Returning Users</p>
      <div className="button">
        <button onClick={() => setAuth("login")}>Login</button>
      </div>
      <p>Create an account</p>
      <div className="button">
        <button onClick={() => setAuth("signup")}>Signup</button>
      </div>
      {/* if the auth is equal to login render the Login Component  OtherWise render SignupComponent the functions*/}
      {auth === "login" ? (
        loginComponent()
      ) : auth === "signup" ? (
        signupComponent()
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
  lastName: string
) => {
  try {
    const response = await axios.post("http://localhost:8080/auth/register", {
      email,
      password,
      firstName,
      lastName,
    });
    console.log(response.data);
  } catch (error) {
    console.error(error);
  }
};

const loginComponent = () => {
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

const signupComponent = () => {
  return (
    <>
      <h1>Signup</h1>
      <form>
        <input type="text" placeholder="First Name" />
        <input type="text" placeholder="Last Name" />
        <input type="email" placeholder="Email" />
        <input type="password" placeholder="Password" />
        <button>Signup</button>
      </form>
    </>
  );
};
