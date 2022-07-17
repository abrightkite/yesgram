import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import HomeContainer from "./components/Home/containers/HomeContainer";
import SignInContainer from "./components/SignIn/containers/SignInContainer";
import SignUpContainer from "./components/SignUp/containers/SignUpContainer";
import SingleGameContainer from "./components/SingleGame/containers/SingleGameContainer";
import SingleGameListContainer from "./components/SingleGameList/containers/SingleGameListContainer";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<SignInContainer />} />
          <Route path="/signup" element={<SignUpContainer />} />
          <Route path="/home" element={<HomeContainer />} />
          <Route path="/single/*">
            <Route path="/single/*" element={<SingleGameContainer />} />
            <Route path="list" element={<SingleGameListContainer />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
