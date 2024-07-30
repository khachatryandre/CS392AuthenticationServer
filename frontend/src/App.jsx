import { useState } from "react";

const Button = (props) => {
  return (
    <button
      className="bg-blue-50 py-3 px-7 rounded-md hover:bg-blue-500 transition-colors hover:text-white"
      {...props}
    />
  );
};

function App() {
  const [token, setToken] = useState(null);

  return (
    <div className="h-screen w-screen flex justify-center items-center gap-3 pt-16">
      {!token && (
        <>
          <Button onClick={() => setToken("blah")}>Log in</Button>
          <Button>Sign up</Button>
          <Button>View public file</Button>
        </>
      )}

      {token && (
        <>
          <Button onClick={() => setToken(null)}>Log out</Button>
          <Button>View public file</Button>
          <Button>View private file</Button>
        </>
      )}
    </div>
  );
}

export default App;
