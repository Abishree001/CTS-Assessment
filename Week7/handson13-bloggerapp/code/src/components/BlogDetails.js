import React from 'react';

const blogs = [
  { id: 1, title: 'React Learning', author: 'Stephen Biz' },
  { id: 2, title: 'Installation', author: 'Schewzdenier' },
];

function BlogDetails({ show }) {
  return show && (
    <div>
      <h2>✍️ Blog Details</h2>
      <ul>
        {blogs.map(blog => (
          <li key={blog.id}>
            {blog.title} by <i>{blog.author}</i>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default BlogDetails;
