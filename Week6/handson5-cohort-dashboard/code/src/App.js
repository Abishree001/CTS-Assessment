import React from "react";
import CohortDetails from "./components/CohortDetails";

function App() {
  const cohorts = [
    { name: "Java Fullstack", startDate: "2025-07-10", status: "ongoing" },
    { name: "Python Automation", startDate: "2025-06-01", status: "completed" },
    { name: "React UI", startDate: "2025-07-15", status: "ongoing" },
    { name: "Spring Boot", startDate: "2025-05-20", status: "completed" },
  ];

  return (
    <div style={{ padding: "20px" }}>
      <h2>Cohort Dashboard</h2>
      {cohorts.map((cohort, index) => (
        <CohortDetails
          key={index}
          name={cohort.name}
          startDate={cohort.startDate}
          status={cohort.status}
        />
      ))}
    </div>
  );
}

export default App;
