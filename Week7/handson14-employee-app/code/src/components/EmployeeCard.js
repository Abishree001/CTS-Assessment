// src/components/EmployeeCard.js
import React, { useContext } from 'react';
import ThemeContext from '../ThemeContext';
import './EmployeeCard.css';

function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext);

  return (
    <div className={`card ${theme}`}>
      <h3>{employee.name}</h3>
      <p>{employee.role}</p>
      <button className={`btn ${theme}`}>View</button>
    </div>
  );
}

export default EmployeeCard;
