import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import reportWebVitals from './reportWebVitals';

import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Menu from './Components/Menu/Menu';
import Game from './Components/Game/Game';
import App from './App'

ReactDOM.render(
  <Router>
      <Routes>
          <Route exact path="" element={<App />}>
              <Route path='/'  element={<Menu />}/>
              <Route path="play/">
                <Route path='19'element={<Game variable = {19} />} />
                <Route path='15'element={<Game variable = {15} />} />
                <Route path='11'element={<Game variable = {11} />} />
                <Route path='9'element={<Game variable = {9} />} />
            </Route> 
          </Route> 
      </Routes>
    </Router>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
