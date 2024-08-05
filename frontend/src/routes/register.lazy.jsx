import { createLazyFileRoute } from "@tanstack/react-router";
import { useState } from "react";
import { loginApi, signupApi } from "../api/api";

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [age, setAge] = useState("");
  const [isError, setIsError] = useState(false);

  const handleRegister = async () => {
    try {
      const res = await signupApi({
        userAge: age,
        userEmail: email,
        userFirstName: firstName,
        userLastName: lastName,
        userPassword: password,
        userRole: "USER",
      });
      if (res.error) {
        setIsError(true);
      }

      if (res.jwtToken) {
        localStorage.setItem("token", res.jwtToken);
      }
    } catch (error) {
      setIsError(true);
    }
  };

  return (
    <>
      <div className="flex flex-col gap-2">
        {isError && (
          <div className="text-red-500 p-2 rounded-md">Error occurred</div>
        )}
        <h1 className="text-2xl font-bold">Register</h1>
        <input
          className="border border-gray-300 rounded-md p-2"
          type="email"
          placeholder="Email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />

        <input
          className="border border-gray-300 rounded-md p-2"
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />

        <input
          className="border border-gray-300 rounded-md p-2"
          type="text"
          placeholder="First name"
          value={firstName}
          onChange={(e) => setFirstName(e.target.value)}
        />

        <input
          className="border border-gray-300 rounded-md p-2"
          type="text"
          placeholder="Last name"
          value={lastName}
          onChange={(e) => setLastName(e.target.value)}
        />

        <button
          onClick={handleRegister}
          className="px-4 py-2 bg-blue-500 text-white rounded-md"
        >
          Register
        </button>
      </div>
    </>
  );
};

export const Route = createLazyFileRoute("/register")({
  component: Login,
});
