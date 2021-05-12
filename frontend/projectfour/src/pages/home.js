import React from 'react';
import './home.css'
import CovidImage from '../static/cvd19.jpg'
  
const Home = () => {
    return(
      <>
      <img src={CovidImage}/>
      <h1 className="welcome-text">Welcome to COVID Tracking Portal</h1>
      </>
    )
}

export default Home;