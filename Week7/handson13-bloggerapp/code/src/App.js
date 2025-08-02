import React, { useState } from 'react';
import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';

function App() {
  const [showBooks, setShowBooks] = useState(true);
  const [showBlogs, setShowBlogs] = useState(true);
  const [showCourses, setShowCourses] = useState(true);

  return (
    <div style={{ padding: '20px' }}>
      <h1>📝 Blogger App</h1>

      <button onClick={() => setShowCourses(!showCourses)}>
        Toggle Course Details
      </button>
      <button onClick={() => setShowBooks(!showBooks)}>
        Toggle Book Details
      </button>
      <button onClick={() => setShowBlogs(!showBlogs)}>
        Toggle Blog Details
      </button>

      <hr />

      <CourseDetails show={showCourses} />
      <BookDetails show={showBooks} />
      <BlogDetails show={showBlogs} />
    </div>
  );
}

export default App;
