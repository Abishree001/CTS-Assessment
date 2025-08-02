// src/ComplaintRegister.js
import React, { useState } from 'react';

function ComplaintRegister() {
  const [employeeName, setEmployeeName] = useState('');
  const [complaint, setComplaint] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    const referenceNumber = Math.floor(100000 + Math.random() * 900000); // 6-digit ref
    alert(
      `Complaint submitted successfully!\n\nReference No: ${referenceNumber}\nEmployee Name: ${employeeName}\nComplaint: ${complaint}`
    );
    setEmployeeName('');
    setComplaint('');
  };

  return (
    <div style={styles.container}>
      <h2>Complaint Registration Form</h2>
      <form onSubmit={handleSubmit} style={styles.form}>
        <div style={styles.field}>
          <label htmlFor="employeeName">Employee Name:</label>
          <input
            type="text"
            id="employeeName"
            value={employeeName}
            onChange={(e) => setEmployeeName(e.target.value)}
            required
          />
        </div>

        <div style={styles.field}>
          <label htmlFor="complaint">Complaint:</label>
          <textarea
            id="complaint"
            rows="4"
            value={complaint}
            onChange={(e) => setComplaint(e.target.value)}
            required
          ></textarea>
        </div>

        <button type="submit">Submit Complaint</button>
      </form>
    </div>
  );
}

const styles = {
  container: {
    width: '500px',
    margin: '50px auto',
    padding: '20px',
    border: '1px solid #ccc',
    borderRadius: '10px',
    fontFamily: 'Arial',
    backgroundColor: '#f9f9f9'
  },
  form: {
    display: 'flex',
    flexDirection: 'column',
  },
  field: {
    marginBottom: '15px',
  },
};

export default ComplaintRegister;
