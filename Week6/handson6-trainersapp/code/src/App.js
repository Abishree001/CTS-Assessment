import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import TrainersList from './components/TrainersList';
import TrainerDetail from './components/TrainerDetail';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<TrainersList />} />
        <Route path="/trainer/:id" element={<TrainerDetail />} />
      </Routes>
    </Router>
  );
}

export default App;
