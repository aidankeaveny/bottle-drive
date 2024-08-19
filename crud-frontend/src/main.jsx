import { StrictMode } from 'react'// eslint-disable-line no-unused-vars
import { createRoot } from 'react-dom/client'
import App from './App.jsx'// eslint-disable-line no-unused-vars
import './index.css'
import 'bootstrap/dist/css/bootstrap.min.css'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <App />
  </StrictMode>,
)
