// src/Register.js
import React, { useState } from 'react';

function Register() {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: '',
  });

  const [errors, setErrors] = useState({});

  const handleChange = (e) => {
    const { name, value } = e.target;

    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const validate = () => {
    let errorObj = {};

    if (formData.name.length < 5) {
      errorObj.name = 'Name must be at least 5 characters long';
    }

    if (!formData.email.includes('@') || !formData.email.includes('.')) {
      errorObj.email = 'Email must be valid';
    }

    if (formData.password.length < 8) {
      errorObj.password = 'Password must be at least 8 characters';
    }

    return errorObj;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const errorObj = validate();

    if (Object.keys(errorObj).length > 0) {
      setErrors(errorObj);
    } else {
      setErrors({});
      alert(
        `Registration Successful!\nName: ${formData.name}\nEmail: ${formData.email}`
      );
      setFormData({ name: '', email: '', password: '' });
    }
  };

  return (
    <div style={styles.container}>
      <h2>Register Form</h2>
      <form onSubmit={handleSubmit} noValidate>
        <div style={styles.inputGroup}>
          <label>Name:</label><br />
          <input
            type="text"
            name="name"
            value={formData.name}
            onChange={handleChange}
          />
          <div style={styles.error}>{errors.name}</div>
        </div>

        <div style={styles.inputGroup}>
          <label>Email:</label><br />
          <input
            type="text"
            name="email"
            value={formData.email}
            onChange={handleChange}
          />
          <div style={styles.error}>{errors.email}</div>
        </div>

        <div style={styles.inputGroup}>
          <label>Password:</label><br />
          <input
            type="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
          />
          <div style={styles.error}>{errors.password}</div>
        </div>

        <button type="submit" style={styles.button}>Register</button>
      </form>
    </div>
  );
}

const styles = {
  container: {
    maxWidth: '400px',
    margin: '40px auto',
    padding: '20px',
    border: '1px solid #ddd',
    borderRadius: '10px',
    backgroundColor: '#f9f9f9',
    fontFamily: 'Arial',
  },
  inputGroup: {
    marginBottom: '15px',
  },
  error: {
    color: 'red',
    fontSize: '0.9rem',
  },
  button: {
    padding: '10px 20px',
    backgroundColor: '#1976d2',
    color: '#fff',
    border: 'none',
    borderRadius: '5px',
    cursor: 'pointer',
  },
};

export default Register;
