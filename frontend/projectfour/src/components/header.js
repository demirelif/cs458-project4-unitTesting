import React from 'react';
import {NavLink} from 'react-router-dom';
import './header.css'

const MainHeader = () => {
    return (<ul className="nav-links">
    <li>
      <NavLink to="/" exact>Home</NavLink>
    </li>
    <li>
      <NavLink to="/signin">Sign In</NavLink>
    </li>
    <li>
      <NavLink to="/signup">Sign Up</NavLink>
    </li>
    <li>
      <NavLink to="/entersymptoms">Enter Symptoms</NavLink>
    </li>
    <li>
      <NavLink to="/seetrends">See Trends</NavLink>
    </li>
  </ul>);
};

export default MainHeader;
