import './App.css';

function App() {

  fetch('https://jsonplaceholder.typicode.com/users') // Will give you promise
  .then((response) => response.json()) // Will give you promise , response.json() will give body as promise , only response will give you body , headers , status etc...
  .then((body)=> console.log(body));

  return (
    // JSX code START
    <div>
      <h1>Let's Learn React JS</h1>
    </div>
    // JSX code END
  );
}

export default App;
