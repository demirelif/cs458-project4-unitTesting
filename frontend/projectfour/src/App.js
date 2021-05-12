import MainHeader from '../src/components/header';
import {
  BrowserRouter as Router,
  Route,
  Redirect,
  Switch
} from 'react-router-dom';
import SignUp from './pages/signup.js';
import SignIn from './pages/signin.js';
import Home from './pages/home.js';
import EnterSymptoms from './pages/entersymptom';
import TrendPage from './pages/trendpage';

function App() {
  return (
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
          <Route path="/entersymptoms" exact>
            <EnterSymptoms />
          </Route>
          <Route path="/seetrends" exact>
            <TrendPage />
          </Route>
          <Redirect to="/" />
        </Switch>
      </main>
    </Router>
  );
}

export default App;
