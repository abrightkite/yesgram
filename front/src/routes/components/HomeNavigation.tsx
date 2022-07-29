import React from "react";
import { Route, Routes } from "react-router-dom";
import PopUp from "../../components/common/PopUp/PopUp";
import HomeContainer from "../../components/Home/containers/HomeContainer";
import SingleGameContainer from "../../components/SingleGame/containers/SingleGameContainer";
import SingleGameListContainer from "../../components/SingleGameList/containers/SingleGameListContainer";
import { PopUpType } from "../../typedef/common/common.types";

type Props = {
  popUp: PopUpType;
};

const HomeNavigation = ({ popUp }: Props) => {
  return (
    <div>
      <Routes>
        <Route path="*" element={<HomeContainer />} />
        <Route path="/single">
          <Route path="play/:uid" element={<SingleGameContainer />} />
          <Route path="list" element={<SingleGameListContainer />} />
        </Route>
      </Routes>
      {popUp.isShown && <PopUp child={popUp.popUp} />}
    </div>
  );
};

export default HomeNavigation;
