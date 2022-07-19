import React from "react";
import { Navigate, Route, Routes } from "react-router-dom";
import SignInContainer from "../../components/SignIn/containers/SignInContainer";
import SignUpContainer from "../../components/SignUp/containers/SignUpContainer";

const SignInNavigation = () => {
  return (
    <Routes>
      <Route path="*" element={<SignInContainer />} />
      <Route path="/signup" element={<SignUpContainer />} />
    </Routes>
  );
};

export default SignInNavigation;
