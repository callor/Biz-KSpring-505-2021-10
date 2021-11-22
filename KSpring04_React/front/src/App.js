import logo from "./logo.svg";
import "./App.css";
import { useState, useEffect } from "react";

function App() {
  const [hello, setHello] = useState("");

  useEffect(() => {
    fetch("/home").then((res) => res.text().then((result) => setHello(result)));
  }, []);

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <h1>{hello}</h1>
      </header>
    </div>
  );
}

export default App;
