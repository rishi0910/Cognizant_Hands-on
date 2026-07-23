import React from 'react';
import './App.css';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div className="App">
      <CalculateScore
        Name={"Rishi"}
        School={"Lucknow Public School"}
        Total={284}
        Goal={300}
      />
    </div>
  );
}

export default App;