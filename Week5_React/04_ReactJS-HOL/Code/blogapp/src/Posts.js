import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false
    };
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then((response) => response.json())
      .then((data) => {
        const postList = data.map(
          (item) => new Post(item.id, item.title, item.body)
        );
        this.setState({ posts: postList });
      })
      .catch((error) => {
        console.error('Error fetching posts:', error);
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    alert('An error occurred in component: ' + error);
    this.setState({ hasError: true });
  }

  render() {
    if (this.state.hasError) {
      return <h2>Something went wrong displaying posts.</h2>;
    }

    return (
      <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
        <h1>Blog Posts</h1>
        {this.state.posts.map((post) => (
          <div
            key={post.id}
            style={{
              borderBottom: '1px solid #ccc',
              marginBottom: '15px',
              paddingBottom: '10px'
            }}
          >
            <h3 style={{ textTransform: 'capitalize' }}>{post.title}</h3>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;