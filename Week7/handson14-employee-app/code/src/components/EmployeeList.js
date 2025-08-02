// src/components/EmployeeList.js
import React from 'react';
import EmployeeCard from './EmployeeCard';

const employees = [
  { id: 1, name: 'John Doe', role: 'Developer' },
  { id: 2, name: 'Jane Smith', role: 'Designer' },
];

function EmployeeList() {
  return (
    <div>
      {employees.map((emp) => (
        <EmployeeCard key={emp.id} employee={emp} />
      ))}
    </div>
  );
}

export default EmployeeList;
