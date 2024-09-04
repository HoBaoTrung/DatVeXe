import React, { useEffect } from 'react';
import './css/Header.css';
import logo from '../assets/header-logo.png';

function Header({ isTransparentBackground = true }) {
  useEffect(() => {
    const header = document.querySelector('.header');
    if (isTransparentBackground) {
      header.classList.add('transparent-background');
      header.classList.remove('white-background');
    } else {
      header.classList.add('white-background');
      header.classList.remove('transparent-background');
    }
  }, [isTransparentBackground]);

  return (
    <header className={`header ${isTransparentBackground ? 'transparent-background' : 'white-background'}`}>
      <div className="container">
        <a href='/'><img src={logo} alt="Logo" className="logo" /></a>
        <div className="auth">
          <a href="/log-in" className="login">Login</a>
          <a href="/sign-up"><button className="sign-up">Sign up</button></a> 
        </div>
      </div>
    </header>
  );
}

export default Header;
