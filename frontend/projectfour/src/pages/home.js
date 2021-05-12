import React from 'react';
import './home.css'
import CovidImage from '../static/cvd19.jpg'
import { alignAuto } from 'react-charts/dist/react-charts.development';
  
const Home = () => {
    return(
      <>
      <img src={CovidImage} className="image"/>
      <h1 className="welcome-text">Welcome to COVID Tracking Portal</h1>
      </>
    )
}

export default Home;