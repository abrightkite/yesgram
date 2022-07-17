import React, { useState } from "react";

const useInput = (validate: Function) => {
  const [value, setValue] = useState("");
  const [showError, setShowError] = useState(false);
  const [errorMsg, setErrorMsg] = useState("");
  const [valid, setValid] = useState(false);
  const className = showError ? "sign-up-input error-input" : "sign-up-input";
  const onChangeHandler = (e: React.FormEvent<HTMLInputElement>) => {
    setValue(e.currentTarget.value);
    if (valid) {
      setValid(false);
    }
    if (showError) {
      setShowError(false);
    }
  };
  const onBlurHandler = (event: React.FormEvent<HTMLInputElement>) => {
    const msg: string = validate(value);
    if (msg) {
      setErrorMsg(msg);
      setValid(false);
      setShowError(true);
      return;
    }
    setValid(true);
    setShowError(false);
  };

  return {
    value,
    showError,
    errorMsg,
    valid,
    className,
    onChangeHandler,
    onBlurHandler,
  };
};

export default useInput;
