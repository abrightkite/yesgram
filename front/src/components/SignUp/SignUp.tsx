import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import useInput from "./hooks/use-input";
import "./SignUp.css";

const SignUp = () => {
  const navigate = useNavigate();
  const {
    value: id,
    showError: idShowError,
    errorMsg: idErrorMsg,
    valid: idValid,
    className: idClassName,
    onChangeHandler: idOnChangeHandler,
    onBlurHandler: idOnBlurHandler,
  } = useInput((value: string): string => {
    function fetchUser(id: string) {
      const users = ["kiryanchi", "admin", "11111", "testt"];
      for (let user of users) {
        if (user === id) {
          return user;
        }
      }
      return "";
    }
    const trimedValue = value.trim();
    if (trimedValue === "") {
      return "아이디를 설정해주세요.";
    } else if (trimedValue.length < 5 || trimedValue.length > 16) {
      return "아이디는 5자 이상 16자 이하입니다.";
    } else if (fetchUser(trimedValue)) {
      return "중복된 아이디입니다.";
    }
    return "";
  });

  const {
    value: pw,
    showError: pwShowError,
    errorMsg: pwErrorMsg,
    valid: pwValid,
    className: pwClassName,
    onChangeHandler: pwOnChangeHandler,
    onBlurHandler: pwOnBlurHandler,
  } = useInput((value: string): string => {
    function checkPassword(pw: string): boolean {
      const reg = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])(?=.*[0-9]).+$/; // 대소문자숫자특수기호

      return reg.test(pw);
    }
    const trimedValue = value.trim();
    if (trimedValue === "") {
      return "비밀번호를 입력해주세요.";
    } else if (trimedValue.length < 8 || trimedValue.length > 16) {
      return "비밀번호는 8~16자 사이입니다.";
    } else if (!checkPassword(value)) {
      return "대문자, 소문자, 숫자, 특수기호 조합으로 입력해주세요";
    }
    return "";
  });

  const {
    value: pwCheck,
    showError: pwCheckShowError,
    errorMsg: pwCheckErrorMsg,
    valid: pwCheckValid,
    className: pwCheckClassName,
    onChangeHandler: pwCheckOnChangeHandler,
    onBlurHandler: pwCheckOnBlurHandler,
  } = useInput((value: string): string => {
    const trimedValue = value.trim();
    if (trimedValue !== pw.trim()) {
      return "비밀번호가 같지 않습니다.";
    }
    return "";
  });

  const {
    value: email,
    showError: emailShowError,
    errorMsg: emailErrorMsg,
    valid: emailValid,
    className: emailClassName,
    onChangeHandler: emailOnChangeHandler,
    onBlurHandler: emailOnBlurHandler,
  } = useInput((value: string): string => {
    function checkEmail(email: string) {
      const reg = /\w+@\w+\.[com|net|io]/;

      return reg.test(email);
    }
    const trimedValue = value.trim();
    if (!checkEmail(trimedValue)) {
      return "올바른 Email을 입력해주세요.";
    }
    return "";
  });

  const [showSignUpButton, setShowSignUpButton] = useState(false);

  useEffect(() => {
    setShowSignUpButton(idValid && pwValid && pwCheckValid && emailValid);
  }, [idValid, pwValid, pwCheckValid, emailValid, email]);

  return (
    <div className="sign-up-wrap">
      <h1>MONOGRAM</h1>
      <form className="sign-up-form">
        <input
          autoFocus
          className={idClassName}
          type="text"
          name="input_id"
          value={id}
          onChange={idOnChangeHandler}
          onBlur={idOnBlurHandler}
          placeholder="아이디*"
        />
        {idShowError && <p className="error-msg">{idErrorMsg}</p>}
        <input
          className={pwClassName}
          type="password"
          name="input_pw"
          value={pw}
          onChange={pwOnChangeHandler}
          onBlur={pwOnBlurHandler}
          placeholder="비밀번호*"
        />
        {pwShowError && <p className="error-msg">{pwErrorMsg}</p>}
        <input
          className={pwCheckClassName}
          type="password"
          name="input_pw_check"
          value={pwCheck}
          onChange={pwCheckOnChangeHandler}
          onBlur={pwCheckOnBlurHandler}
          placeholder="비밀번호 확인*"
        />
        {pwCheckShowError && <p className="error-msg">{pwCheckErrorMsg}</p>}
        <input
          className={emailClassName}
          type="text"
          name="input_email"
          value={email}
          onChange={emailOnChangeHandler}
          onBlur={emailOnBlurHandler}
          placeholder="이메일*"
        />
        {emailShowError && <p className="error-msg">{emailErrorMsg}</p>}
      </form>
      {showSignUpButton ? (
        <button className="sign-up-button" onClick={() => navigate("./home")}>
          Sign Up
        </button>
      ) : (
        <button
          className="sign-up-button"
          disabled
          onClick={() => navigate("./home")}
        >
          Sign Up
        </button>
      )}
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
