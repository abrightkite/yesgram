import React from "react";
import usePopUp from "../../hooks/usePopUp";
import HomeNavigation from "../components/HomeNavigation";

const HomeNavigationContainer = () => {
  const { popUp } = usePopUp();

  return <HomeNavigation popUp={popUp} />;
};

export default HomeNavigationContainer;
