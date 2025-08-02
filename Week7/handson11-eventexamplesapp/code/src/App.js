import React from 'react';
import Counter from './components/Counter';
import WelcomeButton from './components/WelcomeButton';
import SyntheticEventDemo from './components/SyntheticEventDemo';
import CurrencyConvertor from './components/CurrencyConvertor';
import './App.css';

function App() {
  return (
    <div className="App">
      <h1>Event Examples App</h1>
      <Counter />
      <WelcomeButton />
      <SyntheticEventDemo />
      <CurrencyConvertor />
    </div>
  );
}

export default App;
