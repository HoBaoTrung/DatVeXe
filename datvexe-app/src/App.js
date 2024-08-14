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
      <BrowserRouter>
        <Header withBackground={true} />
        <Routes>
          <Route index element={<Home />} />
          <Route path='/StarRating' element={<StarRating />} />
          <Route path='/viewtrip' element={<ViewTrip />} />
        </Routes> 
        <Footer /> 
      </BrowserRouter>
    </>
  );
}

export default App;
