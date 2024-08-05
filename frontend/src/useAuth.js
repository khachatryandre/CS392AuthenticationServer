import { useEffect, useState } from "react";

export const useIsAuthenticated = () => {
  const [token, setToken] = useState(localStorage.getItem("token"));

  useEffect(() => {
    if (localStorage.getItem("token")) {
      setToken(localStorage.getItem("token"));
    } else {
      setToken(null);
    }
  });

  return token;
};
