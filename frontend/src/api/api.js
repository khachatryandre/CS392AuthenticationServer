export const signupApi = async ({
  userEmail,
  userPassword,
  userFirstName,
  userLastName,
  userAge,
  userRole,
}) => {
  const res = await fetch(`${import.meta.env.VITE_API_URL}/register`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      userEmail,
      userPassword,
      userFirstName,
      userLastName,
      userAge,
      userRole,
    }),
  });

  return res.json();
};

export const loginApi = async (email, password) => {
  const res = await fetch(`${import.meta.env.VITE_API_URL}/login`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ email, password }),
  });

  return res.json();
};

export const fetchPublicFile = async (token) => {
  const res = await fetch(`${import.meta.env.VITE_API_URL}/getPublicString`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ token }),
  });

  return res.text();
};

export const fetchPrivateFile = async (token) => {
  const res = await fetch(`${import.meta.env.VITE_API_URL}/getPrivateString`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ token }),
  });

  return res.text();
};
