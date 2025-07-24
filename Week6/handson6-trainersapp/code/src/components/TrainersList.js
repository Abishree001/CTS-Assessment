import React from 'react';
import { Link } from 'react-router-dom';
import './TrainersList.css';

const trainers = [
  { id: 1, name: 'John Doe', expertise: 'React', experience: 5 },
  { id: 2, name: 'Jane Smith', expertise: 'Spring Boot', experience: 7 },
  { id: 3, name: 'David Lee', expertise: 'Salesforce', experience: 4 }
];

function TrainersList() {
  return (
    <div className="trainer-list-container">
      <h1>Trainer List</h1>
      <div className="trainer-grid">
        {trainers.map(trainer => (
          <div className="trainer-card" key={trainer.id}>
            <h3>{trainer.name}</h3>
            <p><strong>Expertise:</strong> {trainer.expertise}</p>
            <p><strong>Experience:</strong> {trainer.experience} years</p>
            <Link to={`/trainer/${trainer.id}`} className="view-button">View Profile</Link>
          </div>
        ))}
      </div>
    </div>
  );
}

export default TrainersList;
