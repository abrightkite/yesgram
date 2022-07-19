import React, { useCallback, useEffect } from "react";
import RootNavigation from "../RootNavigation";

const RootNavigationContainer = () => {
  const root = "home";
  const popUp = false;
  const token = "";

  const checkToken = useCallback(() => {}, [token]);

  useEffect(() => {
    checkToken();
  }, [checkToken]);

  return <RootNavigation root={root} popUp={popUp} />;
};

export default RootNavigationContainer;
