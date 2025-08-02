import React, { useEffect, useState } from 'react';

const Getuser = () => {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetch('https://randomuser.me/api/')
      .then(res => res.json())
      .then(data => {
        setUser(data.results[0]);
        setLoading(false);
      })
      .catch(() => setLoading(false));
  }, []);

  if (loading) return <p>Loading...</p>;

  return (
    <div>
      <h2>User Details</h2>
      <p>Name: {user.name.title} {user.name.first}</p>
      <img src={user.picture.medium} alt="user" />
    </div>
  );
};

export default Getuser;
