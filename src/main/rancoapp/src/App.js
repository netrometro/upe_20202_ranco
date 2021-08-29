import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Switch, Route, useParams } from 'react-router-dom';
import EventoDetalhes from './view/EventoDetalhes';
import { Navigation } from './components/navigation';
import EventoLista from './view/EventoLista';

function App() {
  return (
    <Router>
      <div>
        <Navigation />
        <Switch>
          {/* <Route path='/' exact component={Login} ></Route> */}
          <Route path='/eventos' exact component={EventoLista} ></Route>
          <Route path='/eventos/:id' exact component={EventoDetalhes} ></Route>
        </Switch>

      </div>
    </Router>
  );
}

function Child() {
  // We can use the `useParams` hook here to access
  // the dynamic pieces of the URL.
  let { id } = useParams();

  return (
    <div>
      <h3>ID: {id}</h3>
    </div>
  );
}

export default App;
