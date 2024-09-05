import React, { useContext, useState } from 'react';
import { TextField, Button, Checkbox, FormControlLabel, Link, IconButton } from '@mui/material';
import logo from '../assets/account-flow-icon.png';
import loginBackground from '../assets/account-flow-background.png'; // Đảm bảo đường dẫn đúng
import { Image } from 'react-bootstrap';
import eyeIcon from '../assets/eye-open-icon.png';
import eyeOffIcon from '../assets/eye-close-icon.png';
import facebookIcon from '../assets/facebook-login-icon.png';
import googleIcon from '../assets/google-login-icon.png';
import appleIcon from '../assets/apple-login-icon.png';
import Apis, { endpoint } from '../configs/Apis';
import cookie from "react-cookies";
import { MyUserContext } from "../App";
import { useNavigate } from 'react-router-dom';
import Spinner from '../layout/Spinner';

// Inline styles
const styles = {
  container: {
    display: 'flex',
    height: '100vh',
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#f4f4f4',
  },
  loginContainer: {
    display: 'flex',
    width: 'auto%',
    minWidth: '800px',
    boxShadow: '0 4px 20px rgba(0,0,0,0.1)',
    borderRadius: '8px',
    backgroundColor: '#fff',
    overflow: 'hidden',
    height: '95%',
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
    alignItems: 'center', // Center content vertically if needed
    justifyContent: 'center', // Center content horizontally if needed
    margin: 'auto 0px',
  },
  sideImage: {
    height: '80%',
  },
  logo: {
    marginBottom: '20px',
    fontSize: '24px',
    fontWeight: 'bold',
    color: '#4caf50',
  },
  title: {
    margin: '20px 0px',
    fontSize: '24px',
    fontWeight: 'bold',
  },
  input: {
    marginBottom: '20px',
  },
  rememberMeContainer: {
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
    marginBottom: '20px',
  },
  rememberMe: {
    marginBottom: 0,
  },
  forgotPassword: {
    color: '#FF8682',
    textDecoration: 'none',
  },
  loginButton: {
    backgroundColor: '#8DD3BB',
    color: '#112211',
    padding: '10px',
    width: '100%',
    marginBottom: '10px',
    textTransform: 'none',
    fontWeight: 'bold',
  },
  signUpContainer: {
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
  },
  noAccount: {
    color: '#112211',
    textDecoration: 'none',
    marginRight: '8px',
  },
  signUp: {
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
  errorText: {
    color: 'red',
    fontSize: '14px',
    margin: '10px 0',
  },
};

function App() {
  // State để quản lý giá trị và lỗi
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [emailError, setEmailError] = useState('');
  const [passwordError, setPasswordError] = useState('');
  const [showPassword, setShowPassword] = useState(false);
  const [user, dispatch] = useContext(MyUserContext);
  const nav = useNavigate();
  const [loading, setLoading] = useState(false)

  // Hàm để thay đổi trạng thái hiển thị mật khẩu
  const handleClickShowPassword = () => {
    setShowPassword(!showPassword);
  };

  // Hàm để xử lý sự thay đổi giá trị của trường email
  const handleEmailChange = (event) => {
    setEmail(event.target.value);
    // Clear error when user starts typing
    if (emailError) {
      setEmailError('');
    }
  };

  // Hàm để xử lý sự thay đổi giá trị của trường mật khẩu
  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
    // Clear error when user starts typing
    if (passwordError) {
      setPasswordError('');
    }
  };

  // Hàm để xử lý khi nhấn nút Login
  const handleLogin = async () => {
    let hasError = false;

    // Kiểm tra email hợp lệ
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!email) {
      setEmailError('Email is required.');
      hasError = true;
    } else if (!emailPattern.test(email)) {
      setEmailError('Please enter a valid email address.');
      hasError = true;
    }

    // Kiểm tra mật khẩu không trống
    if (!password) {
      setPasswordError('Password is required.');
      hasError = true;
    }

    // Nếu không có lỗi, thực hiện đăng nhập
    if (!hasError) {

      try {
        setLoading(true)
        let res = await Apis.post(endpoint['login'], {
          "email": email,
          "password": password
        });

        cookie.save("user", res.data.userDetails);
        cookie.save("token", res.data.accessToken);
        dispatch({
          "type": "login",
          "payload": res.data.userDetails
        });
        nav("/");

      } catch (error) {
        setLoading(false)
        alert("Sai email hoặc mật khẩu")

      }

    }
  };

  return (
    <div style={styles.container}>
      <div style={styles.loginContainer}>
        {/* Phần Form */}
        <div style={styles.formContainer}>
          <Image src={logo} />
          <div style={styles.title}>Login</div>
          <p>Login to access your Globle account</p>

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
          <TextField
            style={styles.input}
            label="Password"
            placeholder="..................."
            variant="outlined"
            type={showPassword ? "text" : "password"}
            fullWidth
            value={password}
            onChange={handlePasswordChange}
            error={!!passwordError}
            helperText={passwordError}
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
          />

          <div style={styles.rememberMeContainer}>
            <FormControlLabel
              control={<Checkbox />}
              label="Remember me"
              style={styles.rememberMe}
            />
            <Link href="/forgot-password" style={styles.forgotPassword}>Forgot Password</Link>
          </div>
          
          {loading == true ?
           
              <Spinner />
            :
            <Button style={styles.loginButton} onClick={handleLogin}>
              Login
            </Button>
          }
          <div style={styles.orContainer}>
            <div style={styles.orLine}>
              <div style={styles.orLineBefore}></div>
              <div style={styles.orLineText}>Or Login With</div>
              <div style={styles.orLineAfter}></div>
            </div>
          </div>

          <div style={styles.signUpContainer}>
            <p style={styles.noAccount}>Don't have an account?</p>
            <Link href="/sign-up" style={styles.signUp}>Sign up</Link>
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

        {/* Phần Ảnh */}
        <div style={styles.imageContainer}>
          <img src={loginBackground} alt="" style={styles.sideImage} />
        </div>
      </div>
    </div>
  );
}

export default App;
