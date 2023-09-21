/* eslint-disable react/jsx-no-undef */
import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { BrowserRouter } from 'react-router-dom';
import axios from 'axios';
import { UserdetailsProvider } from './Components/UserContext';

axios.defaults.baseURL = 'http://172.16.18.91:8080'
axios.defaults.headers.post["Content-Type"] = 'application/json'
axios.defaults.headers.post["Accept"] = '*/*'
axios.defaults.headers.post["Access-Control-Allow-Origin"] = "*"
axios.defaults.headers.post["Access-Control-Allow-Headers"] = "*"

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(

  <React.StrictMode>
    <UserdetailsProvider>
    <BrowserRouter>
      <App/>
    </BrowserRouter>
    </UserdetailsProvider>
  </React.StrictMode>
);


reportWebVitals();
