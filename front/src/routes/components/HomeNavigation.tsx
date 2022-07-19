import React from "react";
import { Route, Routes } from "react-router-dom";
import HomeContainer from "../../components/Home/containers/HomeContainer";
import SingleGameContainer from "../../components/SingleGame/containers/SingleGameContainer";
import SingleGameListContainer from "../../components/SingleGameList/containers/SingleGameListContainer";

const HomeNavigation = () => {
  return (
    <div>
      <Routes>
        <Route path="*" element={<HomeContainer />} />
        <Route path="/single">
          <Route path="play/:uid" element={<SingleGameContainer />} />
          <Route path="list" element={<SingleGameListContainer />} />
        </Route>
      </Routes>
    </div>
  );
};

export default HomeNavigation;
