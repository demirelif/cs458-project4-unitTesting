import React, { useContext } from 'react';
import { NavLink } from 'react-router-dom';
import { Context } from '../Context'
import './header.css'

const MainHeader = () => {
  const [context, setContext] = useContext(Context);

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
    {context.authed &&
      <>
        <li>
          <NavLink to="/entersymptoms">Enter Symptoms</NavLink>
        </li>
        <li>
          <NavLink to="/seetrends">See Trends</NavLink>
        </li>
      </>
    }
  </ul>);
};

export default MainHeader;
