import React, { useState } from "react";
import { createLazyRoute, Link, useNavigate } from "@tanstack/react-router";
import { authStore } from "../authStore";
import { useIsAuthenticated } from "../useAuth";
import { fetchPrivateFile, fetchPublicFile } from "../api/api";

const Button = ({ children, ...props }) => {
  return (
    <button className="px-4 py-2 bg-blue-500 text-white rounded-md" {...props}>
      {children}
    </button>
  );
};

const Home = () => {
  const token = useIsAuthenticated();
  const [fileContents, setFileContents] = useState("");
  const navigate = useNavigate();

  const getPublicFile = async () => {
    const res = await fetchPublicFile();

    setFileContents(JSON.stringify(res, null, 2));
  };

  const getPrivateFile = async () => {
    const res = await fetchPrivateFile();

    if (res.includes("invalid") || true) {
      setFileContents("Invalid token");
      navigate({ to: "/login" });
      return;
    }

    setFileContents(JSON.stringify(res, null, 2));
  };

  return (
    <>
      {!token && (
        <>
          <Link to="/login">
            <Button>Log in</Button>
          </Link>
          <Link to="/register">
            <Button>Sign up</Button>
          </Link>
          <Button onClick={getPublicFile}>View public file</Button>
        </>
      )}

      {token && (
        <>
          <div>
            <div className="flex gap-3">
              <Button
                onClick={() => {
                  localStorage.removeItem("token");
                  window.location.reload();
                }}
              >
                Log out
              </Button>
              <Button onClick={getPublicFile}>View public file</Button>
              <Button onClick={getPrivateFile}>View private file</Button>
            </div>
          </div>
        </>
      )}

      {fileContents && (
        <pre className="bg-gray-100 p-4 rounded-md">{fileContents}</pre>
      )}
    </>
  );
};

export const Route = createLazyRoute("/")({
  component: () => <Home />,
});
