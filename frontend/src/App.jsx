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
  const [user, setUser] = useState(null);

  return (
    <div className="w-screen flex justify-center items-center gap-3 pt-16">
      {!user && (
        <>
          <Button
            onClick={() =>
              setUser({
                name: "John Doe",
              })
            }
          >
            Log in
          </Button>
          <Button>Sign up</Button>
          <Button>View public file</Button>
        </>
      )}

      {user && (
        <>
          <div>
            <h1 className="mb-4 text-center text-xl font-bold">
              Welcome, {user.name}
            </h1>
            <div className="flex gap-3">
              <Button onClick={() => setUser(null)}>Log out</Button>
              <Button>View public file</Button>
              <Button>View private file</Button>
            </div>
          </div>
        </>
      )}
    </div>
  );
}

export default App;
