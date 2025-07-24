import React from "react";
import styles from "../styles/CohortDetails.module.css";

const CohortDetails = ({ name, startDate, status }) => {
  const statusColor = status === "ongoing" ? "green" : "blue";

  return (
    <div className={styles.box}>
      <h3 style={{ color: statusColor }}>{name}</h3>
      <dl>
        <dt>Start Date:</dt>
        <dd>{startDate}</dd>
        <dt>Status:</dt>
        <dd>{status}</dd>
      </dl>
    </div>
  );
};

export default CohortDetails;
