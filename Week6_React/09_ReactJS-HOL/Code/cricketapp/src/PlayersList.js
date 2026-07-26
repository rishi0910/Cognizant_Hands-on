import React from 'react';

function PlayersList() {
  const players = [
    { name:'Will',score: 55 },
    { name:'Smith',score: 70 },
    { name:'Bairstow',score: 40 },
    { name:'Warner',score: 80 },
    { name:'Parker',score: 65 },
    { name:'Sterling',score: 90 },
    { name:'Huews',score: 30 },
    { name:'Robert',score: 85 },
    { name:'Jackson',score: 45 },
    { name:'Kane',score: 95 },
    { name:'Gleeson',score: 60 }
  ];

  // Filtering players with score < 70
  const lowScores = players.filter(p =>p.score < 70);

  return (
    <div>
      <h1>List of Players</h1>
      {players.map((item,idx) => (
        <div key={idx}>
          Mr. {item.name} {item.score}
        </div>
      ))}

      <hr />

      <h1>List of Players having score below 70</h1>
      {lowScores.map((item,idx) => (
        <div key={idx}>
          Mr.{item.name} {item.score}
        </div>
      ))}
    </div>
  );
}

export default PlayersList;