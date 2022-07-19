import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import HomeNavigationContainer from "./containers/HomeNavigationContainer";
import SignInNavigationContainer from "./containers/SignInNavigationContainer";

type Props = {
  root: "login" | "home";
  popUp: boolean;
};

const RootNavigation = ({ root, popUp }: Props) => {
  return (
    <BrowserRouter>
      <Routes>
        <Route
          path="*"
          element={
            root === "login" ? (
              <SignInNavigationContainer />
            ) : (
              <HomeNavigationContainer />
            )
          }
        />
      </Routes>
    </BrowserRouter>
  );
};

export default RootNavigation;
