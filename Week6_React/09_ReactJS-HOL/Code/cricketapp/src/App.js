import React from 'react';
import './App.css';
import PlayersList from './PlayersList';
import IndianPlayers from './IndianPlayers';

function App() {
  const flag = true; // Change flag to false for testing second component

  if (flag) {
    return (
      <div className="App">
        <PlayersList />
      </div>
    );
  } else {
    return (
      <div className="App">
        <IndianPlayers />
      </div>
    );
  }
}

export default App;