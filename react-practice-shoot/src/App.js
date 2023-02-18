import { useEffect, useState } from "react";
import "./App.css";

function App() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/users") // Will give you promise
      .then((response) => response.json()) // Will give you promise , response.json() will give body as promise , only response will give you body , headers , status etc...
      .then((users) => setUsers(users));
  }, []);

  console.log("users value", users);

  return (
    // JSX code START
    <div>
      <h1>Let's Learn React JS</h1>
    </div>
    // JSX code END
  );
}

export default App;
