import './App.css'
import UserComponent from './components/UserComponent'
import FooterComponent from './components/FooterComponent'
import HeaderComponent from './components/HeaderComponent'
import ListUserComponent from './components/ListUserComponent'
import { BrowserRouter, Route, Routes } from 'react-router-dom'

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
