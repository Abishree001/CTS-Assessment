import React from 'react';

function SyntheticEventDemo() {
  const handleClick = (e) => {
    e.preventDefault(); // Synthetic event
    alert("I was clicked");
  };

  return (
    <button onClick={handleClick}>Click Me</button>
  );
}

export default SyntheticEventDemo;
