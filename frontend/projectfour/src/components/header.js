import React, { useContext } from 'react';
import { NavLink } from 'react-router-dom';
import { Context } from '../Context'
import './header.css'

const MainHeader = () => {
  const [context, setContext] = useContext(Context);

  const logOut = () => {
    setContext({ "authed": false })
  }

  return (<ul className="nav-links">
    {!context.authed &&
      <>
        <li>
          <NavLink to="/" exact>Home</NavLink>
        </li>
        <li>
          <NavLink to="/signin">Sign In</NavLink>
        </li>
        <li>
          <NavLink to="/signup">Sign Up</NavLink>
        </li>
      </>
    }
    {context.authed &&
      <>
        <li>
          <NavLink to="/entersymptoms" exact>Enter Symptoms</NavLink>
        </li>
        <li>
          <NavLink to="/seetrends" exact>See Trends</NavLink>
        </li>
        <li>
          <NavLink to="/" onClick={logOut} exact>Log Out</NavLink>
        </li>
      </>
    }
  </ul>);
};

export default MainHeader;
