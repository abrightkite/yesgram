import React, { useState } from "react";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import "./SignIn.css";

interface User {
  id: string;
  pw: string;
}

const SignIn = () => {
  const navigate = useNavigate();

  const [inputId, setInputId] = useState("");
  const [inputPw, setInputPw] = useState("");

  // 추후에 백엔드 작업이 완료되면 수정할 함수
  const fetchUser = (id: string, pw: string): boolean => {
    const users: User[] = [
      { id: "test", pw: "test" },
      { id: "admin", pw: "admin" },
    ];

    console.log(`id: ${id} pw: ${pw}`);

    for (let user of users) {
      if (user.id === id && user.pw === pw) {
        return true;
      }
    }
    return false;
  };

  const handleSignInButton = () => {
    if (!fetchUser(inputId, inputPw)) {
      alert("ID와 PW가 맞지 않습니다."); // 경고문
      setInputPw(""); // 비밀번호를 초기화
    } else {
      navigate("/home"); // 유저정보가 확인되면 home 이동
    }
  };

  return (
    <div className="sign-in-wrap">
      <h1>MONOGRAM</h1>
      <form className="sign-in-form">
        <input
          autoFocus
          className="sign-in-input"
          type="text"
          name="input_id"
          value={inputId}
          onChange={(e) => setInputId(e.target.value)}
          placeholder="아이디"
        />
        <input
          className="sign-in-input"
          type="password"
          name="input_pw"
          value={inputPw}
          onChange={(e) => setInputPw(e.target.value)}
          placeholder="비밀번호"
          onKeyPress={(e) => {
            if (e.key === "Enter") {
              handleSignInButton();
            }
          }}
        />
      </form>
      <button className="move-to-home-button" onClick={handleSignInButton}>
        Sign In
      </button>
      <div className="move-to-signup">
        아직 계정이 없으신가요?{"  "}
        <Link className="link" to="/signup">
          회원가입
        </Link>
      </div>
    </div>
  );
};

export default SignIn;
