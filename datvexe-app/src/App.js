import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import cookie from "react-cookies";
import Header from './layout/Header';
import Footer from './layout/Footer';
import Home from './components/Home';
import Login from './components/Login';
import SignUp from './components/SignUp';
import MainPage from './components/FindWithFilter';
import { createContext, useReducer } from 'react';
import MyUserReducer from './reducer/MyUserReducer';
import ForgotPassword from './components/ForgotPassword';
export const MyUserContext = createContext()
function App() {
  const [user, dispatch] = useReducer(MyUserReducer, cookie.load("user") || null);
  return (
    <>
 <MyUserContext.Provider value={[user, dispatch]}>


      <BrowserRouter>
        <Header withBackground={true} />
        <Routes>
          <Route index element={<Home />} />
          <Route path='/forgotPassword' element={<ForgotPassword />} />
          <Route path='/login' element={<Login />} />
          <Route path='/register' element={<SignUp />} />
          <Route path='/search' element={<MainPage />} />
        </Routes>
        <Footer />
      </BrowserRouter>
      </MyUserContext.Provider>

    </>
  );
}

export default App;
