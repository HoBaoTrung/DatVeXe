import React, { useState } from 'react';
import { TextField, Button } from '@mui/material';
import logo from '../assets/account-flow-icon.png';
import forgotPasswordBackground from '../assets/account-flow-background.png'; // Adjust this path accordingly
import { Image } from 'react-bootstrap';
import facebookIcon from '../assets/facebook-login-icon.png';
import googleIcon from '../assets/google-login-icon.png';
import appleIcon from '../assets/apple-login-icon.png';
import { Link, useNavigate } from 'react-router-dom';
import Apis, { endpoint } from '../configs/Apis';

// Inline styles
const styles = {
  container: {
    display: 'flex',
    height: '100vh',
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#f4f4f4',
  },
  forgotPasswordContainer: {
    display: 'flex',
    width: 'auto%',
    minWidth: '800px',
    height: '80%',
    boxShadow: '0 4px 20px rgba(0,0,0,0.1)',
    borderRadius: '8px',
    backgroundColor: '#fff',
    overflow: 'hidden',
  },
  formContainer: {
    flex: 1,
    padding: '40px',
  },
  imageContainer: {
    flex: 1,
    backgroundSize: 'cover',
    backgroundPosition: 'center',
    borderRadius: '8px',
    display: 'flex',
    height: '100%',
    alignItems: 'center',
    justifyContent: 'center',
  },
  sideImage: {
    height: '90%',
    objectFit: 'cover',
  },
  logo: {
    marginBottom: '20px',
    fontSize: '24px',
    fontWeight: 'bold',
    color: '#4caf50',
  },
  backToLogin: {
    color: '#112211',
    textDecoration: 'none',
    margin: '30px 0 10px 0',
    display: 'block',
  },
  title: {
    margin: '0px 0px 20px 0',
    fontSize: '24px',
    fontWeight: 'bold',
  },
  input: {
    margin: '20px 0px',
  },
  submitButton: {
    backgroundColor: '#8DD3BB',
    color: '#112211',
    padding: '10px',
    width: '100%',
    margin: '10px 0px',
    textTransform: 'none',
    fontWeight: 'bold',
  },
  orContainer: {
    textAlign: 'center',
    margin: '10px 0',
    position: 'relative',
  },
  orLine: {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    marginTop: '10px',
  },
  orLineText: {
    position: 'relative',
    backgroundColor: '#fff',
    padding: '0 10px',
    color: '#888',
  },
  orLineBefore: {
    flex: 1,
    height: '1px',
    backgroundColor: '#ddd',
  },
  orLineAfter: {
    flex: 1,
    height: '1px',
    backgroundColor: '#ddd',
  },
  socialLogin: {
    display: 'flex',
    justifyContent: 'space-between',
    marginTop: '20px'
  },
  socialButton: {
    width: '30%',
    marginLeft: '15px',
    padding: '5px 0px',
    border: '1px solid #8DD3BB',
    borderRadius: '4px',
    textAlign: 'center',
    cursor: 'pointer',
  },
  socialButtonImage: {
    width: '24px',
    height: '24px',
  },
  errorText: {
    color: 'red',
    fontSize: '14px',
    margin: '10px 0',
  },
};

function ForgotPassword() {
  const [email, setEmail] = useState('');
  const [emailError, setEmailError] = useState('');
  const nav = useNavigate();
  const handleEmailChange = (event) => {
    setEmail(event.target.value);
    // Clear error when user starts typing
    if (emailError) {
      setEmailError('');
    }
  };

  const handleSubmit = async () => {
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailPattern.test(email)) {
      setEmailError('Please enter a valid email address.');
    } else {
      setEmailError('');
      // Handle valid email submission
      console.log('Email submitted:', email);

      try {
        let res = await Apis.post(endpoint['forgotPassword'], { email })
       console.info(res.status)
        if (res.status === 200) {nav('/login')}
        
        else { setEmailError(res.data) }


      } catch (error) {
        console.log(error.response)
      }

    }
  };

  return (
    <div style={styles.container}>
      <div style={styles.forgotPasswordContainer}>
        {/* Form Section */}
        <div style={styles.formContainer}>
          <Image src={logo} />
          <Link to="/login" style={styles.backToLogin}>
            &lt; Back to login
          </Link>
          <div style={styles.title}>Forgot your password?</div>
          <p>Don’t worry, happens to all of us. Enter your email below to recover your password.</p>

          <TextField
            style={styles.input}
            label="Email"
            variant="outlined"
            fullWidth
            placeholder="john.doe@gmail.com"
            value={email}
            onChange={handleEmailChange}
            error={!!emailError}
            helperText={emailError}
          />

          <Button style={styles.submitButton} onClick={handleSubmit}>
            Submit
          </Button>

          {/* Or Login With Section */}
          <div style={styles.orContainer}>
            <div style={styles.orLine}>
              <div style={styles.orLineBefore}></div>
              <div style={styles.orLineText}>Or Login With</div>
              <div style={styles.orLineAfter}></div>
            </div>
          </div>

          <div style={styles.socialLogin}>
            <div style={styles.socialButton}>
              <img src={googleIcon} alt="Google" style={styles.socialButtonImage} />
            </div>
            <div style={styles.socialButton}>
              <img src={facebookIcon} alt="Facebook" style={styles.socialButtonImage} />
            </div>
            <div style={styles.socialButton}>
              <img src={appleIcon} alt="Apple" style={styles.socialButtonImage} />
            </div>
          </div>
        </div>

        {/* Image Section */}
        <div style={styles.imageContainer}>
          <img src={forgotPasswordBackground} alt="Forgot Password Background" style={styles.sideImage} />
        </div>
      </div>
    </div>
  );
}

export default ForgotPassword;
