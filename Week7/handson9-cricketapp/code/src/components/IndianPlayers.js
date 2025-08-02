import React from 'react';

const IndianPlayers = () => {
  const allPlayers = [
    "Dhoni", "Kohli", "Raina", "Bumrah", "Pandya",
    "Gill", "Sundar", "Iyer", "Ashwin", "Shami", "Siraj"
  ];

  const oddPlayers = allPlayers.filter((_, index) => index % 2 !== 0);
  const evenPlayers = allPlayers.filter((_, index) => index % 2 === 0);

  // Destructuring
  const [first, second, ...rest] = allPlayers;

  // Merging arrays
  const T20Players = ["Surya", "Ishan"];
  const RanjiPlayers = ["Jadeja", "Pujara"];
  const mergedPlayers = [...T20Players, ...RanjiPlayers];

  return (
    <div style={{ padding: '10px', background: '#e8f7ff' }}>
      <h2>Odd Team Players</h2>
      <ul>
        {oddPlayers.map((p, i) => <li key={i}>{p}</li>)}
      </ul>

      <h2>Even Team Players</h2>
      <ul>
        {evenPlayers.map((p, i) => <li key={i}>{p}</li>)}
      </ul>

      <h2>Destructured Values</h2>
      <p>First: {first}</p>
      <p>Second: {second}</p>

      <h2>Merged Team</h2>
      <ul>
        {mergedPlayers.map((p, i) => <li key={i}>{p}</li>)}
      </ul>
    </div>
  );
};

export default IndianPlayers;
