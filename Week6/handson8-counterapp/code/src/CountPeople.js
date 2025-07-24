// src/CountPeople.js
import React, { Component } from "react";
import "./CountPeople.css";

class CountPeople extends Component {
  constructor(props) {
    super(props);
    this.state = {
      entryCount: 0,
      exitCount: 0,
    };
  }

  updateEntry = () => {
    this.setState({ entryCount: this.state.entryCount + 1 });
  };

  updateExit = () => {
    this.setState({ exitCount: this.state.exitCount + 1 });
  };

  render() {
    return (
      <div className="counter-container">
        <h1>🛍️ Mall People Counter</h1>
        <div className="count-display">
          <p><strong>People Entered:</strong> {this.state.entryCount}</p>
          <p><strong>People Exited:</strong> {this.state.exitCount}</p>
        </div>
        <div className="btn-group">
          <button onClick={this.updateEntry}>Login</button>
          <button onClick={this.updateExit}>Exit</button>
        </div>
      </div>
    );
  }
}

export default CountPeople;
