import './App.css';
import UserComponent from './components/UserComponent'; // eslint-disable-line no-unused-vars
import FooterComponent from './components/FooterComponent';// eslint-disable-line no-unused-vars
import HeaderComponent from './components/HeaderComponent';// eslint-disable-line no-unused-vars
import ListUserComponent from './components/ListUserComponent';// eslint-disable-line no-unused-vars
import { BrowserRouter, Route, Routes } from 'react-router-dom';// eslint-disable-line no-unused-vars

function App() {
  
  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
        <Routes>
          <Route path='/' element={ <ListUserComponent /> }></Route>
          <Route path='/users' element={ <ListUserComponent /> }></Route>
          <Route path='/add-user' element={ <UserComponent /> }></Route>
          <Route path='/edit-user/:id' element={ <UserComponent /> }></Route>
        </Routes>
        <FooterComponent />
      </BrowserRouter>
    </>
  )
}

export default App
