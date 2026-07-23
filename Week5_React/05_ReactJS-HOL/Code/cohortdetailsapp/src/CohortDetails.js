import React from 'react';
import styles from './CohortDetails.module.css';

function CohortDetails({ title, status, duration, mentor }) {
  const headingStyle = {
    color: status.toLowerCase() === 'ongoing' ? 'green' : 'blue'
  };

  return (
    <div className={styles.box}>
      <h3 style={headingStyle}>{title}</h3>
      <dl>
        <dt>Status:</dt>
        <dd>{status}</dd>
        <dt>Duration:</dt>
        <dd>{duration}</dd>
        <dt>Mentor:</dt>
        <dd>{mentor}</dd>
      </dl>
    </div>
  );
}

export default CohortDetails;