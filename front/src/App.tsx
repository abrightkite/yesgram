import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import HomeContainer from "./components/Home/containers/HomeContainer";
import SignInContainer from "./components/SignIn/containers/SignInContainer";
import SignUpContainer from "./components/SignUp/containers/SignUpContainer";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<SignInContainer />} />
          <Route path="signup" element={<SignUpContainer />} />
          <Route path="home" element={<HomeContainer />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
