import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./App.css";
import Navbar from "./components/Navbar";
import Mentor from "./components/Mentor";
import Mentee from "./components/Mentee";
import HR from "./components/HR";

function App() {
  return (
    <>
      <Navbar/>
      <BrowserRouter>
      <Routes>
        <Route path="/" element={<HR />}/>
        <Route path="/mentor" element={<Mentor />} />
        <Route path="/mentee" element={<Mentee />} />
        <Route path="/hr" element={<HR />} />
      </Routes>
    </BrowserRouter>
    </>
  );
}

export default App;
