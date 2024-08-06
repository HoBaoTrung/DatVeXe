import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';

import Header from './layout/Header';
import Footer from './layout/Footer';
import Home from './components/Home';
import StarRating from './components/StarRating';
import ViewTrip from './components/ViewTrip';

function App() {
  return (
    <>
    {/* <MyUserContext.Provider value={[user, dispatch]}> */}
      <BrowserRouter>
        <Header/>
         <Routes>
          <Route path='/' element={<Home/>}/>
          <Route path='/StarRating' element={<StarRating/>}/>
          <Route path='/viewtrip' element={<ViewTrip/>}/>
          {/*<Route path='/product/:productId' element={<ProductDetail/>}/>
          
          <Route path='/login' element={<Login/>}/>
          <Route path='/register' element={<Register/>}/>
          <Route path='/product' element={<ViewProduct/>}/>*/}
        </Routes> 
        <Footer /> 

      </BrowserRouter>
      {/* </MyUserContext.Provider> */}
    </>

  );
}

export default App;
