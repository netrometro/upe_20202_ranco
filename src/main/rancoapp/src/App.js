
import './App.css';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import EventoDetalhes from './view/EventoDetalhes';
import Cadastro from './view/cadastro';
import Login from './view/Login';
import { Navigation } from './components/navigation';

function App() {
  return (
    <Router>
      <div>
        <Navigation />
        <Switch>
          {/* <Route path='/' exact component={Login} ></Route> */}
          <Route path='/eventos' exact component={EventoDetalhes} ></Route>
          <Route path='/cadastro' exact component={Cadastro} ></Route>
          <Route path='/login' exact component={Login} ></Route>
        </Switch>

      </div>
    </Router>
  );
}

export default App;
