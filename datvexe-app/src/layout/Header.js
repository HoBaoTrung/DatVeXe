<<<<<<< HEAD
import React, { useContext, useEffect, useState } from 'react';
import { Form, Button } from 'react-bootstrap';
import Flatpickr from 'react-flatpickr';
import 'flatpickr/dist/themes/material_green.css'; // Import CSS cho Flatpickr
import './Header.css';
import logo from '../assets/header-logo.png';
import { format } from 'date-fns';
import { Link } from 'react-router-dom';
import { MyUserContext } from '../App';

function Header({ withBackground = true }) {
  const [user, dispatch] = useContext(MyUserContext);
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
=======
import React, { useEffect } from 'react';
import './css/Header.css';
import logo from '../assets/header-logo.png';
>>>>>>> 91c8a07e3bb493afce5d95d86bff393f6492b1c5

function Header({ isTransparentBackground = true }) {
  useEffect(() => {
    const header = document.querySelector('.header');
    if (isTransparentBackground) {
      header.classList.add('transparent-background');
      header.classList.remove('white-background');
<<<<<<< HEAD

      const image = new Image();
      image.src = require('../assets/home-header-image.png');

      image.onload = () => {
        header.style.height = `${image.height}px`;
      };
=======
    } else {
      header.classList.add('white-background');
      header.classList.remove('transparent-background');
>>>>>>> 91c8a07e3bb493afce5d95d86bff393f6492b1c5
    }
  }, [isTransparentBackground]);

  return (
<<<<<<< HEAD

    <div className={withBackground ? "header-background" : ""}>

      <header className="header">
        <div className="container">
          <a href='/'><img src={logo} alt="Logo" className="logo" /></a>
          <nav className="nav">
            {/* Thêm nội dung nav nếu cần */}
          </nav>
          <div className="auth">
            {user === null ? <>
              <Link className="login" to="/login">Login</Link>
              <Link className="login" to="/register">
                <button className="sign-up">Sign up</button>
              </Link>
            </> : <Link onClick={() => dispatch({ "type": "logout" })} className="login">
              <button className="sign-up">Logout</button>
            </Link>}
          </div>
        </div>


      </header>
    </div>
=======
    <header className={`header ${isTransparentBackground ? 'transparent-background' : 'white-background'}`}>
      <div className="container">
        <a href='/'><img src={logo} alt="Logo" className="logo" /></a>
        <div className="auth">
          <a href="/log-in" className="login">Login</a>
          <a href="/sign-up"><button className="sign-up">Sign up</button></a> 
        </div>
      </div>
    </header>
>>>>>>> 91c8a07e3bb493afce5d95d86bff393f6492b1c5
  );
}

export default Header;
