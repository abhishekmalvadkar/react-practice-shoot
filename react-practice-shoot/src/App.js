import {  Route, Routes } from "react-router-dom";
import AddBookmark from "./AddBookmark";
import "./App.css";
import Home from "./Home";

function App() {
  return (
    // JSX code START
    <>
      <Routes>
        <Route path="" element={<Home />} />
        <Route path="add-bookmark" element={<AddBookmark />} />
      </Routes>
    </>
    // JSX code END
  );
}

export default App;
