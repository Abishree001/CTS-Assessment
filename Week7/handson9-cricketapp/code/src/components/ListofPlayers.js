import React from 'react';

const ListofPlayers = () => {
  const players = [
    { name: "Virat Kohli", score: 90 },
    { name: "Rohit Sharma", score: 85 },
    { name: "KL Rahul", score: 65 },
    { name: "Rishabh Pant", score: 40 },
    { name: "Hardik Pandya", score: 72 },
    { name: "Jasprit Bumrah", score: 35 },
    { name: "Shubman Gill", score: 78 },
    { name: "Axar Patel", score: 50 },
    { name: "Shreyas Iyer", score: 60 },
    { name: "Kuldeep Yadav", score: 25 },
    { name: "Ravindra Jadeja", score: 80 }
  ];

  const filtered = players.filter(p => p.score < 70);

  return (
    <div style={{ padding: '10px', background: '#f3f3f3' }}>
      <h2>All Players</h2>
      <ul>
        {players.map((p, index) => (
          <li key={index}>{p.name} - Score: {p.score}</li>
        ))}
      </ul>

      <h2>Filtered (Score &lt; 70)</h2>
      <ul>
        {filtered.map((p, index) => (
          <li key={index}>{p.name} - Score: {p.score}</li>
        ))}
      </ul>
    </div>
  );
};
export default ListofPlayers;
