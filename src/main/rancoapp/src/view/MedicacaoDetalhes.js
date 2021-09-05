import React, { useEffect, useState } from "react";
import ReactDOM from 'react-dom';

export default ({match}) => {
    useEffect(() => {        
        getMedicacao(match.params.id);
    }, [])

    const [medicacoes, setMedicacao] = useState({});

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
    return (
        <div>
            <h1>{medicacoes.nome}</h1>
            <div name="descricao">
                <h3>Descricao</h3>
                <p>{medicacoes.descricao}</p>
            </div>
            <div name="observacao">
                <h3>Observação</h3>
                <p>{medicacoes.observacao}</p>
            </div>
            <div name="intervalo">
                <h3>Intervalo</h3>
                <p>{medicacoes.intervalo}</p>
            </div>
            <div name="ultimaDosagem">
                <h3>Última Dosagem</h3>
                <p>{medicacoes.ultimaDosagem}</p>
            </div>
            <div name="posologia">
                <h3> Posologia</h3>
                <p>{medicacoes.posologia}</p>
            </div>
        </div>
    );
}