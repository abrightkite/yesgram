import React from "react";
import "./css/header.css";

const Header = () => {
  return (
    <header className="header-wrap">
      <div className="header-inner">
        <h1 className="logo">
          <button>MONOGRAM</button>
        </h1>
        <nav className="gnb">
          <button className="profile">profile</button>
          <button className="ucc">ucc</button>
        </nav>
      </div>
    </header>
  );
};

export default Header;
