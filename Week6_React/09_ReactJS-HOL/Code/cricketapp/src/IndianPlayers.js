import React from 'react';

function IndianPlayers() {
  const team = ['Sachin','Dhoni','Virat','Rohit','Yuvraj','Raina'];

  // Destructuring for odd and even players
  const [p1,p2,p3,p4,p5,p6] = team;
  const oddTeam = [p1,p3,p5];
  const evenTeam = [p2,p4,p6];

  // Merging arrays using ES6 spread operator
  const T20players = ['First Player','Second Player','Third Player'];
  const RanjiTrophyplayers = ['Fourth Player','Fifth Player','Sixth Player'];
  const mergedPlayers = [T20players,RanjiTrophyplayers];

  return (
    <div>
      <h2>Odd Team Players</h2>
      {oddTeam.map((player,index) => (
        <p key={index}>Player : {player}</p>
      ))}

      <h2>Even Team Players</h2>
      {evenTeam.map((player,index) => (
        <p key={index}>Player:{player}</p>
      ))}

      <hr />

      <h2>Merged List of Players</h2>
      {mergedPlayers.map((player,index) => (
        <p key={index}>Mr. {player}</p>
      ))}
    </div>
  );
}

export default IndianPlayers;