import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import EventoDetalhes from './view/EventoDetalhes';

function App() {
  return (
    <Router>
      {/* <Navigation /> */}
      <Switch>
        <Route path='/' exact component={EventoDetalhes} ></Route>
      </Switch>
    </Router>
  );
}

export default App;
