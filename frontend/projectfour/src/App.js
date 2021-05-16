import React,{useState} from 'react'
import MainHeader from '../src/components/header';
import {
  BrowserRouter as Router,
  Route,
  Redirect,
  Switch,createContext
} from 'react-router-dom';
import SignUp from './pages/signup.js';
import SignIn from './pages/signin.js';
import Home from './pages/home.js';
import EnterSymptoms from './pages/entersymptom';
import TrendPage from './pages/trendpage';
import { Context } from "./Context.js";


const App = () => {
  // const [context, setContext] = useState({"authed":false});
  const [context, setContext] = useState({"authed":false});
  return (
    <Context.Provider value={[context, setContext]}>
      <Router>
        <MainHeader />
        <main>
          <Switch>
            <Route path="/" exact>
              <Home />
            </Route>
            <Route path="/signup" exact>
              <SignUp />
            </Route>
            <Route path="/signin" exact>
              <SignIn />
            </Route>
            {context.authed &&
            <>
            <Route path="/entersymptoms" exact>
              <EnterSymptoms />
            </Route>
            <Route path="/seetrends" exact>
              <TrendPage />
            </Route>
            </>
            }
            <Redirect to="/" />
          </Switch>
        </main>
      </Router>
    </Context.Provider>
  );
}

export default App;
