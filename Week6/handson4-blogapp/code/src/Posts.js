// src/Posts.js
import React, { Component } from 'react';
import Post from './Post';
import './Posts.css';


class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false
    };
  }

  componentDidMount() {
    this.loadPosts();
  }

  loadPosts = async () => {
    try {
      const response = await fetch("https://jsonplaceholder.typicode.com/posts");
      const data = await response.json();
      this.setState({ posts: data.slice(0, 5) }); // Limiting to 5 posts
    } catch (error) {
      console.error("Error fetching posts:", error);
      this.setState({ hasError: true });
    }
  };

  componentDidCatch(error, info) {
    alert("Something went wrong: " + error);
    this.setState({ hasError: true });
  }

  render() {
    if (this.state.hasError) {
      return <h2 style={{ color: "red" }}>Error loading posts. Please try again later.</h2>;
    }

    return (
      <div style={{ padding: '20px' }}>
        <h2>Blog Posts</h2>
        {this.state.posts.map((post) => (
          <Post key={post.id} title={post.title} body={post.body} />
        ))}
      </div>
    );
  }
}

export default Posts;
