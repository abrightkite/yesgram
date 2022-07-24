import React from "react";
import "./css/singleGame.css";

const SingleGame = () => {
  return (
    <div className="single-game-wrap">
      <section className="single-game-container">
        <header className="single-game-header">
          <h2>
            <span className="category">[혼자하기]</span>
            <p className="title">방제목</p>
          </h2>
          <span className="size">15x15</span>
        </header>
        <div className="puzzle-wrap">
          <div className="puzzle-container">
            <div className="game-box">
              <div className="top-task"></div>
              <div className="left-task"></div>
              <div className="cells-box"></div>
            </div>
            <div className="controllor">
              <button className="memo">memo</button>
              <button className="rule-out">x</button>
              <button className="fill">fill</button>
              <button className="reset">reset</button>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
};

export default SingleGame;
