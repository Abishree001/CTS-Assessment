// src/Post.js
import React from 'react';

const Post = ({ title, body }) => {
  return (
    <div style={styles.postBox}>
      <h3>{title}</h3>
      <p>{body}</p>
    </div>
  );
};

const styles = {
  postBox: {
    padding: '15px',
    margin: '10px',
    backgroundColor: '#f0f0f0',
    border: '1px solid #ccc',
    borderRadius: '8px',
  }
};

export default Post;
