import React, { useState } from "react";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import "./SignUp.css";

const SignUp = () => {
  const navigate = useNavigate();

  const [inputId, setInputId] = useState("");
  const [inputPw, setInputPw] = useState("");
  const [inputPwCheck, setInputPwCheck] = useState("");
  const [inputEmail, setInputEmail] = useState("");

  return (
    <div className="sign-up-wrap">
      <h1>MONOGRAM</h1>
      <form className="sign-up-form">
        <input
          autoFocus
          className="sign-up-input"
          type="text"
          name="input_id"
          value={inputId}
          onChange={(e) => setInputId(e.target.value)}
          placeholder="아이디"
        />
        <input
          className="sign-up-input"
          type="text"
          name="input_id"
          value={inputPw}
          onChange={(e) => setInputPw(e.target.value)}
          placeholder="비밀번호"
        />
        <input
          className="sign-up-input"
          type="text"
          name="input_id"
          value={inputPwCheck}
          onChange={(e) => setInputPwCheck(e.target.value)}
          placeholder="비밀번호 확인"
        />
        <input
          className="sign-up-input"
          type="text"
          name="input_id"
          value={inputEmail}
          onChange={(e) => setInputEmail(e.target.value)}
          placeholder="이메일"
        />
      </form>
      <button className="sign-up-button" onClick={() => navigate("/")}>
        Sign Up
      </button>
      <div className="move-to-signin">
        이미 계정이 있으신가요?{" "}
        <Link className="link" to="/">
          로그인
        </Link>
      </div>
    </div>
  );
};

export default SignUp;
