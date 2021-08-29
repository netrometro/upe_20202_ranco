import React from "react";
import ReactDOM from 'react-dom';

class EventoDetalhes extends React.Component {
    constructor(props) {
        super(props);

        // this.state = { evento: null };
    }

    async componentDidMount() {        
        const response = await fetch('http://localhost:5000/api/eventos/43');
        const evento = await response.json();
        this.setState({ evento: evento });            
    }

    render() {
        return (
            <div>
                <h1>Evento</h1>
                <div name="status">
                    <p> Status</p>
                </div>
                <div name="categoria">
                    <p> Categoria</p>
                </div>
                <div name="descricao">
                    <p> Descrição</p>
                </div>
                <div name="motivo">
                    <p> Motivo</p>
                </div>
                <div name="data">
                    <p> Data</p>
                </div>
                <div name="expectativa">
                    <p> Expectativa</p>
                </div>
                <div name="local">
                    <p> local</p>
                </div>
                <div name="pessoasEnvolvidas">
                    <p>Pessoas envolvidas</p>
                </div>
                <div name="feedback">
                    <p> feedback</p>
                </div>
                <div name="pontosDeMelhoria">
                    <p>Pontos de melhoria</p>
                </div>
                <div name="sentimentos">
                    <p>Sentimentos</p>
                </div>
            </div>
        );
    }
}

export default EventoDetalhes;