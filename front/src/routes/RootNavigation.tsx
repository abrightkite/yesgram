import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import HeaderContainer from "../components/Header/containers/HeaderContainer";
import HomeNavigationContainer from "./containers/HomeNavigationContainer";
import SignInNavigationContainer from "./containers/SignInNavigationContainer";

type Props = {
  root: "signin" | "home";
  popUp: boolean;
};

const RootNavigation = ({ root, popUp }: Props) => {
  return (
    <BrowserRouter>
      {root === "home" && <HeaderContainer />}
      <Routes>
        <Route
          path="*"
          element={
            root === "signin" ? (
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
