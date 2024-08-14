import React from 'react';
import './Footer.css';
import logo from '../assets/footer-logo.png';
import facebook_icon from '../assets/facebook-icon.png';
import x_icon from '../assets/x-icon.png';
import youtube_icon from '../assets/youtube-icon.png';
import instagram_icon from '../assets/instagram-icon.png';

function Footer() {
  return (
    <footer className="footer">
      <div className="container">
        <div className="links">
          <div className="column ">
            <a href ="/"><img src={logo} alt="Logo" className="logo" /></a>
            <div className="additional-logos">
              <a href ="/"><img src={facebook_icon} alt="Facebook Logo" className="additional-logo" /></a>
              <a href ="/"><img src={x_icon} alt="X Logo" className="additional-logo" /></a>
              <a href ="/"><img src={youtube_icon} alt="Youtube Logo" className="additional-logo" /></a>
              <a href ="/"><img src={instagram_icon} alt="Instagram Logo" className="additional-logo" /></a>
            </div>
          </div>


          <div className="column">
            <h3>About Us</h3>
            <ul>
              <li>Our Story</li>
              <li>Work with us</li>
              <li>News and event</li>
            </ul>
          </div>
          <div className="column">
            <h3>Contact Us</h3>
            <ul>
              <li>Contact Form</li>
              <li>Support</li>
              <li>Tutorial</li>
            </ul>
          </div>
        </div>
      </div>
    </footer>
  );
}

export default Footer;
