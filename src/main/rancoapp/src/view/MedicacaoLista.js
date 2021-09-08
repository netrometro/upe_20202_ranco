import React, { useEffect, useState } from "react";
import ReactDOM from 'react-dom';
import "../styles/lista.css"
import { Link } from "react-router-dom";
import { useAuthState } from "../context";

export default () => {
    useEffect(() => {
        getMedicacao();
    }, [])

    const state = useAuthState();
    const [medicacoes, setMedicacao] = useState([]);
    const getMedicacao = () => {
        fetch(`http://localhost:5000/medicacoes/${JSON.parse(state.userDetails).id}`)
            .then(async response => {
                const data = await response.json();

                // check for error response
                if (!response.ok) {
                    // get error message from body or default to response statusText
                    const error = (data && data.message) || response.statusText;
                    return Promise.reject(error);
                }
                console.log(data);
                setMedicacao(data.medicacoes);
            })
    }
    if (state.userDetails) {
        return (
            <div className="listaEvento">
                <div className='header'>
                <h1 id='medicacao'>Minhas Medicações</h1>
                    <a class="sentimentoButton" href='/cadastrarmedicacoes' >Adicionar Medicações</a>
                </div>


                {medicacoes.map((medicacao) => (
                    <Link to={`/medicacoes/${medicacao.id}`} key={medicacao.id}>
                        <div className="blocoEvento">
                            <h3>{medicacao.nome}</h3>
                            <h3>Intervalo: {medicacao.intervalo}</h3>
                        </div>
                    </Link>
                ))}
            </div>
        )
    }
    else {
        window.location.href = '/login'
    }
}
