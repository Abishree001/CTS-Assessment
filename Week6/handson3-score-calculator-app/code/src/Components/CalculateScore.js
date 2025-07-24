import React from "react";
import "../Stylesheets/App.css";

function CalculateScore(props) {
  const percentage = (props.total / props.goal) * 100;

  return (
    <div>
      <h1 className="heading">Student Details:</h1>
      <p><span className="label">Name:</span> <span className="value">{props.name}</span></p>
      <p><span className="label">School:</span> <span className="school">{props.school}</span></p>
      <p><span className="label">Total:</span> {props.total}Marks</p>
      <p><span className="score">Score:</span> {percentage.toFixed(2)}%</p>
    </div>
  );
}

export default CalculateScore;
