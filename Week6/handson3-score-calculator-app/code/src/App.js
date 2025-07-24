import React from 'react';
import './App.css';

function App() {
  const student = {
    name: "Steeve",
    school: "DNV Public School",
    totalMarks: 284,
    scorePercentage: ((284 / 300) * 100).toFixed(2)
  };

  return (
    <div className="app-container">
      <div className="card">
        <h2 className="heading">Student Details</h2>
        <hr />
        <p className="name-line"><strong>Name:</strong> {student.name}</p>
        <p className="school-line"><strong>School:</strong> {student.school}</p>
        <p className="total-line"><strong>Total:</strong> {student.totalMarks} Marks</p>
        <p className="score-line"><strong>Score:</strong> {student.scorePercentage}%</p>
      </div>
    </div>
  );
}

export default App;
