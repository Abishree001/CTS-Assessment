import React, { Component } from 'react';

class Getuser extends Component {
  constructor(props) {
    super(props);
    this.state = {
      title: '',
      firstname: '',
      image: '',
      loading: true,
    };
  }

  async componentDidMount() {
    try {
      const response = await fetch('https://api.randomuser.me/');
      const data = await response.json();
      const user = data.results[0];

      this.setState({
        title: user.name.title,
        firstname: user.name.first,
        image: user.picture.large,
        loading: false,
      });
    } catch (error) {
      console.error('Error fetching user:', error);
    }
  }

  render() {
    const { title, firstname, image, loading } = this.state;

    return (
      <div style={{ textAlign: 'center', padding: '20px' }}>
        <h1>Random User Info</h1>
        {loading ? (
          <p>Loading...</p>
        ) : (
          <div>
            <h2>
              {title} {firstname}
            </h2>
            <img src={image} alt="User" style={{ borderRadius: '50%' }} />
          </div>
        )}
      </div>
    );
  }
}

export default Getuser;
