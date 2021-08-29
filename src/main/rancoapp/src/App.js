import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import EventoDetalhes from './view/EventoDetalhes';
import { Navigation } from './components/navigation';

function App() {
  return (
    <Router>
      <div>
        <Navigation />
        <Switch>
          {/* <Route path='/' exact component={Login} ></Route> */}
          <Route path='/eventos' exact component={EventoDetalhes} ></Route>
        </Switch>

      </div>
    </Router>
  );
}

export default App;
