import React, { useState } from "react";
import GuestPage from "./components/GuestPage";
import UserPage from "./components/UserPage";
import FlightDetails from "./components/FlightDetails";
import "./App.css";

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = () => setIsLoggedIn(true);
  const handleLogout = () => setIsLoggedIn(false);

  return (
    <div className="App">
      <h1>✈️ Ticket Booking App</h1>
      <div className="button-group">
        {!isLoggedIn ? (
          <button onClick={handleLogin} className="login-btn">Login</button>
        ) : (
          <button onClick={handleLogout} className="logout-btn">Logout</button>
        )}
      </div>

      {isLoggedIn ? <UserPage /> : <GuestPage />}
      <FlightDetails />
    </div>
  );
}

export default App;
