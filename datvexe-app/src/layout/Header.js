import React, { useEffect, useState } from 'react';
import { Form, Button } from 'react-bootstrap';
import Flatpickr from 'react-flatpickr';
import 'flatpickr/dist/themes/material_green.css'; // Import CSS cho Flatpickr
import './Header.css';
import logo from '../assets/header-logo.png';
import { format } from 'date-fns';

function Header({ withBackground = true }) {
  const [trip, setTrip] = useState({
    from: '',
    to: '',
    date: format(new Date(), 'yyyy-MM-dd'),
  });

  const [station, setStation] = useState([
    { id: 1, name: 'Hà Nội' },
    { id: 2, name: 'Hồ Chí Minh' },
    // Thêm các trạm khác vào đây
  ]);

  const updateField = (field, value) => {
    setTrip({
      ...trip,
      [field]: value,
    });
  };

  const findTrip = () => {
    console.log('Searching for trip:', trip);
    // Thêm logic tìm kiếm chuyến đi tại đây
  };

  useEffect(() => {
    const header = document.querySelector('.header');

    if (!withBackground) {
      header.classList.add('white-background');
      header.style.height = '90px';
    } else {
      header.classList.remove('white-background');

      const image = new Image();
      image.src = require('../assets/header-background.png');

      image.onload = () => {
        header.style.height = `${image.height}px`;
      };
    }
  }, [withBackground]);

  return (
    <div className={withBackground ? "header-background" : ""}>
      <header className="header">
        <div className="container">
          <a href='/'><img src={logo} alt="Logo" className="logo" /></a>
          <nav className="nav">
            {/* Thêm nội dung nav nếu cần */}
          </nav>
          <div className="auth">
            <a href="#" className="login">Login</a>
            <button className="sign-up">Sign up</button>
          </div>
        </div>
        <div className="header-text">
            <h1 className="main-heading">Helping Others</h1>
            <h2 className="sub-heading">Live & Travel</h2>
            <p className="description">Special offers to suit your plan</p>
        </div>
       
      </header>
    </div>
  );
}

export default Header;
