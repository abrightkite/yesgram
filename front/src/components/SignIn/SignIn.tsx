import React from "react";
import { useNavigate } from "react-router-dom";

const SignIn = () => {
  const navigate = useNavigate();
  return (
    <div className="sign-in-wrap">
      SignIn page
      <button className="move-to-home-button" onClick={() => navigate("/home")}>
        home
      </button>
      <button
        className="move-to-home-button"
        onClick={() => navigate("/signup")}
      >
        signup
      </button>
    </div>
  );
};

export default SignIn;
