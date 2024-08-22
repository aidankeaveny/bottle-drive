import React from 'react';
import './App.css';
import UserComponent from './components/userComponent/UserComponent';
import FooterComponent from './components/footerComponent/FooterComponent';
import HeaderComponent from './components/headerComponent/HeaderComponent';
import ListUserComponent from './components/listUserComponent/ListUserComponent';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import HomeComponent from './components/homeComponent/HomeComponent';

function App() {
  
  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
        <Routes>
          <Route path='/' element={ <HomeComponent /> }></Route>
          <Route path='/users' element={ <ListUserComponent /> }></Route>
          <Route path='/add-user' element={ <UserComponent /> }></Route>
          <Route path='/donate' element={ <UserComponent /> }></Route>
          <Route path='/edit-user/:id' element={ <UserComponent /> }></Route>
        </Routes>
        <FooterComponent />
      </BrowserRouter>
    </>
  );
};

export default App;
