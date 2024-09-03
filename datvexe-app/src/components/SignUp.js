import React, { useState } from 'react';
import { TextField, Button, Checkbox, FormControlLabel, Link, IconButton } from '@mui/material';
import logo from '../assets/account-flow-icon.png';
import signUpBackground from '../assets/account-flow-background.png';
import { Image } from 'react-bootstrap';
import eyeIcon from '../assets/eye-open-icon.png';
import eyeOffIcon from '../assets/eye-close-icon.png';
import facebookIcon from '../assets/facebook-login-icon.png';
import googleIcon from '../assets/google-login-icon.png';
import appleIcon from '../assets/apple-login-icon.png';

// Inline styles
const styles = {
  container: {
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    padding:'1% 0',
    backgroundColor: '#f4f4f4',
  },
  signUpContainer: {
    display: 'flex',
    width: 'auto%',
    minWidth: '800px',
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
    alignItems: 'center',
    justifyContent: 'center',
  },
  sideImage: {
    height: '80%',
    margin: 'auto 0'
  },
  title: {
    margin: '20px 0px',
    fontSize: '24px',
    fontWeight: 'bold',
  },
  input: {
    marginBottom: '20px',
  },
  inputRow: {
    display: 'flex',
    justifyContent: 'space-between',
    gap: '10px',
  },
  passwordContainer: {
    display: 'flex',
    alignItems: 'center',
  },
  checkboxContainer: {
    display: 'flex',
    alignItems: 'center',
  },
  checkboxError: {
    color: 'red',
    marginTop: '5px',
  },
  signUpButton: {
    backgroundColor: '#8DD3BB',
    color: '#112211',
    padding: '10px',
    width: '100%',
    margin: '20px 0',
    textTransform: 'none',
    fontWeight: 'bold',
  },
  loginLinkContainer: {
    display: 'flex',
    justifyContent: 'center',
    marginTop: '20px',
  },
  loginLink: {
    color: '#FF8682',
    textDecoration: 'none',
    marginLeft: '5px',
  },
  termsLink: {
    color: '#FF8682',
    textDecoration: 'none',
  },
  socialLogin: {
    display: 'flex',
    justifyContent: 'space-between',
    marginTop: '20px',
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
  iconButton: {
    padding: 0,
    marginLeft: '8px',
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
};

function SignUp() {
  const [showPassword, setShowPassword] = useState(false);
  const [showConfirmPassword, setShowConfirmPassword] = useState(false);
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [phoneNumber, setPhoneNumber] = useState('');
  const [email, setEmail] = useState('');
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [termsAccepted, setTermsAccepted] = useState(false);
  const [formErrors, setFormErrors] = useState({});

  const handleClickShowPassword = () => {
    setShowPassword(!showPassword);
  };

  const handleClickShowConfirmPassword = () => {
    setShowConfirmPassword(!showConfirmPassword);
  };

  const validateForm = () => {
    const errors = {};
    if (!firstName) {
      errors.firstName = 'First Name is required';
    }
    if (!lastName) {
      errors.lastName = 'Last Name is required';
    }
    if (!email || !/^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/.test(email)) {
      errors.email = 'Please enter a valid email address';
    }
    if (!phoneNumber || phoneNumber.length < 10) {
      errors.phoneNumber = 'Please enter a valid phone number';
    }
    if (!password) {
      errors.password = 'Password is required';
    }
    if (password !== confirmPassword) {
      errors.confirmPassword = 'Passwords do not match';
    }
    if (!termsAccepted) {
      errors.termsAccepted = 'You must accept the Terms and Privacy Policies';
    }
    return errors;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const errors = validateForm();
    setFormErrors(errors);
    if (Object.keys(errors).length === 0) {
      // Submit form if no errors
      console.log('Form submitted');
    }
  };

  const handleTermsChange = (e) => {
    const isChecked = e.target.checked;
    setTermsAccepted(isChecked);

    // Xóa thông báo lỗi khi checkbox được chọn
    if (isChecked) {
      setFormErrors(prevErrors => ({
        ...prevErrors,
        termsAccepted: '', // Xóa thông báo lỗi khi checkbox được chọn
      }));
    }
  };

  return (
    <div style={styles.container}>
      <div style={styles.signUpContainer}>
        {/* Image Section */}
        <div style={styles.imageContainer}>
          <img src={signUpBackground} alt="Sign Up Background" style={styles.sideImage} />
        </div>
        {/* Form Section */}
        <div style={styles.formContainer}>
          <Image src={logo} />
          <div style={styles.title}>Sign Up</div>
          <p>Let us set up your personal account.</p>

          <div style={styles.inputRow}>
            <TextField
              style={{ ...styles.input, flex: 1 }}
              label="First Name"
              variant="outlined"
              placeholder="John"
              required
              value={firstName}
              onChange={(e) => {
                setFirstName(e.target.value);
                setFormErrors(prev => ({ ...prev, firstName: '' }));
              }}
              error={Boolean(formErrors.firstName)}
              helperText={formErrors.firstName}
            />
            <TextField
              style={{ ...styles.input, flex: 1 }}
              label="Last Name"
              variant="outlined"
              placeholder="Doe"
              required
              value={lastName}
              onChange={(e) => {
                setLastName(e.target.value);
                setFormErrors(prev => ({ ...prev, lastName: '' }));
              }}
              error={Boolean(formErrors.lastName)}
              helperText={formErrors.lastName}
            />
          </div>

          <div style={styles.inputRow}>
            <TextField
              style={{ ...styles.input, flex: 1 }}
              label="Email"
              variant="outlined"
              placeholder="john.doe@gmail.com"
              fullWidth
              type="email"
              value={email}
              onChange={(e) => {
                setEmail(e.target.value);
                setFormErrors(prev => ({ ...prev, email: '' }));
              }}
              error={Boolean(formErrors.email)}
              helperText={formErrors.email}
            />
            <TextField
              style={{ ...styles.input, flex: 1 }}
              label="Phone Number"
              variant="outlined"
              placeholder="0123456789"
              inputMode="numeric"
              value={phoneNumber}
              onChange={(e) => {
                setPhoneNumber(e.target.value.slice(0, 10));
                setFormErrors(prev => ({ ...prev, phoneNumber: '' }));
              }}
              inputProps={{ maxLength: 10 }}
              fullWidth
              error={Boolean(formErrors.phoneNumber)}
              helperText={formErrors.phoneNumber}
            />
          </div>

          <div style={styles.passwordContainer}>
            <TextField
              style={styles.input}
              label="Password"
              variant="outlined"
              fullWidth
              placeholder="........"
              type={showPassword ? 'text' : 'password'}
              value={password}
              onChange={(e) => {
                setPassword(e.target.value);
                setFormErrors(prev => ({ ...prev, password: '' }));
              }}
              InputProps={{
                endAdornment: password && (
                  <IconButton
                    onClick={handleClickShowPassword}
                    edge="end"
                    style={styles.iconButton}
                  >
                    <img src={showPassword ? eyeOffIcon : eyeIcon} alt="Toggle visibility" />
                  </IconButton>
                ),
              }}
              error={Boolean(formErrors.password)}
              helperText={formErrors.password}
            />
          </div>

          <div style={styles.passwordContainer}>
            <TextField
              style={styles.input}
              label="Confirm Password"
              variant="outlined"
              fullWidth
              placeholder="........"
              type={showConfirmPassword ? 'text' : 'password'}
              value={confirmPassword}
              onChange={(e) => {
                setConfirmPassword(e.target.value);
                setFormErrors(prev => ({ ...prev, confirmPassword: '' }));
              }}
              InputProps={{
                endAdornment: confirmPassword && (
                  <IconButton
                    onClick={handleClickShowConfirmPassword}
                    edge="end"
                    style={styles.iconButton}
                  >
                    <img src={showConfirmPassword ? eyeOffIcon : eyeIcon} alt="Toggle visibility" />
                  </IconButton>
                ),
              }}
              error={Boolean(formErrors.confirmPassword)}
              helperText={formErrors.confirmPassword}
            />
          </div>

          <div style={styles.checkboxContainer}>
            <FormControlLabel
              control={
                <Checkbox
                  checked={termsAccepted}
                  onChange={handleTermsChange}
                />
              }
              label={
                <span>
                  I agree to the <Link href="#" style={styles.termsLink}>Terms</Link> and <Link href="#" style={styles.termsLink}>Privacy Policy</Link>
                </span>
              }
            />
          </div>

          {formErrors.termsAccepted && <p style={styles.checkboxError}>{formErrors.termsAccepted}</p>}
          
          <Button style={styles.signUpButton} onClick={handleSubmit}>Create Account</Button>

          <div style={styles.loginLinkContainer}>
            <span>Already have an account?</span>
            <Link href="/log-in" style={styles.loginLink}>Login</Link>
          </div>

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
      </div>
    </div>
  );
}

export default SignUp;
