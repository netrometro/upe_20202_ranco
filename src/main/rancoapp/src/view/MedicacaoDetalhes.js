import React, { useEffect, useState } from "react";
import ReactDOM from 'react-dom';
import { useAuthState } from "../context";

export default ({ match }) => {
    useEffect(() => {
        getMedicacao(match.params.id);
    }, [])

    const [medicacoes, setMedicacao] = useState({});
    const state = useAuthState();
    const getMedicacao = (id) => {
        fetch(`http://localhost:5000/api/medicacoes/${id}`)
            .then(async response => {
                const data = await response.json();

                // check for error response
                if (!response.ok) {
                    // get error message from body or default to response statusText
                    const error = (data && data.message) || response.statusText;
                    return Promise.reject(error);
                }
                setMedicacao(data);
            })
    }
    if(state.userDetails){
    return (
        <div className='listaMedicamento'>
            <h1>{medicacoes.nome}</h1>
            <div className = ''>
                <div className='colunas' id='colunas'>
                    <div className='primeiraColuna'>
                        <div className='blocoMedicamento' name="descricao" id="descricao">
                            <h3>Descrição:</h3>
                            <p>{medicacoes.descricao}</p>
                        </div>
                        <div className='blocoMedicamento' name="observacao" id="observacao">
                            <h3>Observação:</h3>
                            <p>{medicacoes.observacao}</p>
                        </div>
                    </div>

                    <div className='segundaColuna'>
                        <div className='blocoMedicamento' name="intervalo" id="intervalo">
                            <h3>Intervalo:</h3>
                            <p>{medicacoes.intervalo}</p>
                        </div>
                        <div className='blocoMedicamento' name="ultimaDosagem" id="ultimaDosagem">
                            <h3>Última Dosagem:</h3>
                            <p>{medicacoes.ultimaDosagem}</p>
                        </div>
                    </div>

                </div>





            </div>
        </div>
    );
    }
    else{
        window.location.href = '/login'
    }
}