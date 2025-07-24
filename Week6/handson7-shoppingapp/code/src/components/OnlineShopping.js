// src/components/OnlineShopping.js
import React, { Component } from 'react';
import Cart from './Cart';

class OnlineShopping extends Component {
  render() {
    const items = [
      { itemname: "Laptop", price: 65000 },
      { itemname: "Smartphone", price: 30000 },
      { itemname: "Bluetooth Speaker", price: 5000 },
      { itemname: "Smartwatch", price: 12000 },
      { itemname: "Headphones", price: 3500 },
    ];

    return (
      <div>
        <h2 style={{ textAlign: "center", marginTop: "20px", color: "#34495e" }}>My Shopping Cart</h2>
        <div style={{ display: 'flex', justifyContent: 'center', flexWrap: 'wrap' }}>
          {items.map((item, index) => (
            <Cart key={index} itemname={item.itemname} price={item.price} />
          ))}
        </div>
      </div>
    );
  }
}

export default OnlineShopping;
