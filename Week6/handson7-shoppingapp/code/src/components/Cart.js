// src/components/Cart.js
import React, { Component } from 'react';
import './Cart.css';

class Cart extends Component {
  static defaultProps = {
    itemname: "Unknown Item",
    price: 0
  };

  render() {
    const { itemname, price } = this.props;

    return (
      <div className="cart-card">
        <h3>{itemname}</h3>
        <p>Price: ₹{price}</p>
      </div>
    );
  }
}

export default Cart;
