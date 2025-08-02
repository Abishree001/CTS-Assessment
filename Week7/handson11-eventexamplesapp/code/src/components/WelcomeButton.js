import React from 'react';

function WelcomeButton() {
  const sayWelcome = (message) => {
    alert(message);
  };

  return (
    <button onClick={() => sayWelcome("Welcome!")}>Say Welcome</button>
  );
}

export default WelcomeButton;
