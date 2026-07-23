import React from 'react';
import './App.css';
import CohortDetails from './CohortDetails';

function App() {
  const cohorts = [
    { id: 1, title: 'Java Full Stack', status: 'Ongoing', duration: '12 Weeks', mentor: 'Rahul Sharma' },
    { id: 2, title: 'React JS Developer', status: 'Completed', duration: '8 Weeks', mentor: 'Ananya Roy' },
    { id: 3, title: 'Cloud & DevOps', status: 'Ongoing', duration: '10 Weeks', mentor: 'Vikas Gupta' }
  ];

  return (
    <div className="App" style={{ padding: '20px' }}>
      <h2>Cognizant Academy Cohorts</h2>
      {cohorts.map((cohort) => (
        <CohortDetails
          key={cohort.id}
          title={cohort.title}
          status={cohort.status}
          duration={cohort.duration}
          mentor={cohort.mentor}
        />
      ))}
    </div>
  );
}

export default App;