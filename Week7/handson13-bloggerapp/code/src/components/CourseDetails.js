import React from 'react';

const courses = [
  { id: 1, name: 'Angular', date: '2025-07-28' },
  { id: 2, name: 'React', date: '2025-08-01' },
];

function CourseDetails({ show }) {
  const shouldRender = show;

  if (shouldRender) {
    return (
      <div>
        <h2>📚 Course Details</h2>
        <ul>
          {courses.map(course => (
            <li key={course.id}>
              {course.name} - {course.date}
            </li>
          ))}
        </ul>
      </div>
    );
  } else {
    return <p>Course details hidden</p>;
  }
}

export default CourseDetails;
