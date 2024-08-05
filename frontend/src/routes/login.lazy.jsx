import { createLazyFileRoute, useNavigate } from "@tanstack/react-router";
import { useState } from "react";
import { loginApi } from "../api/api";

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [isError, setIsError] = useState(false);
  const navigate = useNavigate();

  const handleLogin = async () => {
    try {
      const res = await loginApi(email, password);
      if (res.error) {
        setIsError(true);
      }

      if (res.jwtToken) {
        localStorage.setItem("token", res.jwtToken);
      }

      navigate({ to: "/" });
    } catch (error) {
      setIsError(true);
    }
  };

  return (
    <>
      <div className="flex flex-col gap-2">
        {isError && (
          <div className="text-red-500 p-2 rounded-md">
            Invalid email or password
          </div>
        )}
        <h1 className="text-2xl font-bold">Log in</h1>
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
        <button
          onClick={handleLogin}
          className="px-4 py-2 bg-blue-500 text-white rounded-md"
        >
          Log in
        </button>
      </div>
    </>
  );
};

export const Route = createLazyFileRoute("/login")({
  component: Login,
});
