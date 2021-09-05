
import './App.css';
import { BrowserRouter as Router, Switch, Route, useParams } from 'react-router-dom';
import EventoDetalhes from './view/EventoDetalhes';
import Cadastro from './view/cadastro';
import Login from './view/Login';
import { Navigation } from './components/navigation';
import EventoLista from './view/EventoLista';
import MedicacaoLista from './view/MedicacaoLista';
import MedicacaoDetalhes from './view/MedicacaoDetalhes';
import './styles/navegacao.css'
import adicionarEvento from './view/adicionarEvento';

function App() {
  return (
    <div className='back'>
      <Router>
        <Navigation />
        <Switch>
          {/* <Route path='/' exact component={Login} ></Route> */}
          <Route path='/cadastro' exact component={Cadastro} ></Route>
          <Route path='/login' exact component={Login} ></Route>
          <Route path='/eventos' exact component={EventoLista} ></Route>
          <Route path='/eventos/:id' component={EventoDetalhes} ></Route>
          <Route path='/medicacoes' exact component={MedicacaoLista} ></Route>
          <Route path='/medicacoes/:id' component={MedicacaoDetalhes} ></Route>
          <Route path='/adicionarEvento' component={adicionarEvento} ></Route>
        </Switch>

      </Router>
    </div>
  );
}

export default App;
