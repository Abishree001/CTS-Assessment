import React from 'react';
import { useParams, Link } from 'react-router-dom';
import './TrainerDetail.css';

const trainers = [
  { id: 1, name: 'John Doe', expertise: 'React', experience: 5 },
  { id: 2, name: 'Jane Smith', expertise: 'Spring Boot', experience: 7 },
  { id: 3, name: 'David Lee', expertise: 'Salesforce', experience: 4 }
];

function TrainerDetail() {
  const { id } = useParams();
  const trainer = trainers.find(t => t.id === parseInt(id));

  if (!trainer) {
    return <p>Trainer not found</p>;
  }

  return (
    <div className="trainer-detail">
      <h2>{trainer.name}</h2>
      <p><strong>Expertise:</strong> {trainer.expertise}</p>
      <p><strong>Experience:</strong> {trainer.experience} years</p>
      <Link to="/" className="back-button">Back to List</Link>
    </div>
  );
}

export default TrainerDetail;
