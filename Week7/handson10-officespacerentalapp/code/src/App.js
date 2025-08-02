import React from "react";

function App() {
  // Featured Office
  const featuredOffice = {
    name: "Skyline Co-Working",
    rent: 48000,
    address: "MG Road, Bengaluru",
    image: "https://via.placeholder.com/400x200?text=Skyline+Office",
  };

  // List of Office Spaces
  const offices = [
    {
      name: "TechNest Hub",
      rent: 55000,
      address: "Whitefield, Bengaluru",
      image: "https://via.placeholder.com/400x200?text=TechNest",
    },
    {
      name: "EcoSpace",
      rent: 75000,
      address: "HSR Layout, Bengaluru",
      image: "https://via.placeholder.com/400x200?text=EcoSpace",
    },
    {
      name: "InnoZone",
      rent: 59000,
      address: "Indiranagar, Bengaluru",
      image: "https://via.placeholder.com/400x200?text=InnoZone",
    },
  ];

  // CSS styles
  const containerStyle = {
    fontFamily: "Arial, sans-serif",
    padding: "30px",
    backgroundColor: "#f8f9fa",
  };

  const cardStyle = {
    backgroundColor: "#fff",
    padding: "20px",
    marginBottom: "20px",
    borderRadius: "10px",
    boxShadow: "0 2px 5px rgba(0,0,0,0.1)",
  };

  const rentStyle = (amount) => ({
    color: amount > 60000 ? "green" : "red",
    fontWeight: "bold",
  });

  return (
    <div style={containerStyle}>
      <h1 style={{ textAlign: "center", color: "#2c3e50" }}>
        🏢 Office Space Rental App
      </h1>

      {/* Featured Office */}
      <div style={cardStyle}>
        <img src={featuredOffice.image} alt={featuredOffice.name} />
        <h2>{featuredOffice.name}</h2>
        <p><strong>Address:</strong> {featuredOffice.address}</p>
        <p style={rentStyle(featuredOffice.rent)}>
          Rent: ₹{featuredOffice.rent}
        </p>
      </div>

      {/* List of Office Spaces */}
      <h2 style={{ marginTop: "40px" }}>📋 Available Offices:</h2>
      {offices.map((office, index) => (
        <div key={index} style={cardStyle}>
          <img src={office.image} alt={office.name} />
          <h3>{office.name}</h3>
          <p><strong>Address:</strong> {office.address}</p>
          <p style={rentStyle(office.rent)}>Rent: ₹{office.rent}</p>
        </div>
      ))}
    </div>
  );
}

export default App;
