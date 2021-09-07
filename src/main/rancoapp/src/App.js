
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
import { AuthProvider } from "./context";
import cadastrarMedicacoes from './view/cadastrarMedicacoes';
import Dashboard from './view/Dashboard';
import AtualizarEvento from './view/AtualizarEvento';
import Perfil from './view/Perfil';

function App() {
  return (
    <AuthProvider>
      <Router>
        <div className='back'>
          <Navigation />
          <Switch>
            {/* <Route path='/' exact component={Login} ></Route> */}
            <Route path='/' exact component={Dashboard} ></Route>
            <Route path='/cadastro' exact component={Cadastro} ></Route>
            <Route path='/login' exact component={Login} ></Route>
            <Route path='/eventos' exact component={EventoLista} ></Route>
            <Route path='/eventos/:id' exact component={EventoDetalhes} ></Route>
            <Route path='/eventos/update/:id' component={AtualizarEvento} ></Route>
            <Route path='/medicacoes' exact component={MedicacaoLista} ></Route>
            <Route path='/medicacoes/:id' component={MedicacaoDetalhes} ></Route>
            <Route path='/adicionarEvento' component={adicionarEvento} ></Route>
            <Route path='/cadastrarmedicacoes' component={cadastrarMedicacoes} ></Route>
            <Route path='/perfil' component={Perfil} ></Route>
          </Switch>
        </div>
      </Router>
    </AuthProvider>
  );
}

export default App;
