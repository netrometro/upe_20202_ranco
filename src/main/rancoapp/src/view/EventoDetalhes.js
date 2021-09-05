import React, { useEffect, useState } from "react";
import ReactDOM from 'react-dom';

export default ({match}) => {
    useEffect(() => {        
        getEvento(match.params.id);
    }, [])

    const [evento, setEvento] = useState({});

    const getEvento = (id) => {
        fetch(`http://localhost:5000/api/eventos/${id}`)
            .then(async response => {
                const data = await response.json();

                // check for error response
                if (!response.ok) {
                    // get error message from body or default to response statusText
                    const error = (data && data.message) || response.statusText;
                    return Promise.reject(error);
                }
                setEvento(data);
            })
    }

    return (
        <div className='listaEvento' id='detalhes'>
            <h1>{evento.titulo}</h1>
            <div className='blocoEvento' name="status">
                <h3> Status</h3>
                <p>{evento.status}</p>
            </div>
            <div className='blocoEvento' name="descricao" id='descricao'>
                <h3> Descrição</h3>
                <p>{evento.descricao}</p>
            </div>
            <div  className='blocoEvento' name="categoria">
                <h3> Categoria</h3>
                <p>{evento.categoria}</p>
            </div>
            
            <div className='blocoEvento' name="motivo">
                <h3> Motivo</h3>
                <p>{evento.motivo}</p>
            </div>
            <div className='blocoEvento' name="data">
                <h3> Data</h3>
                <p>{evento.data}</p>
            </div>
            <div className='blocoEvento' name="expectativa">
                <h3> Expectativa</h3>
                <p>{evento.expectativa}</p>
            </div>
            <div className='blocoEvento' name="local">
                <h3> local</h3>
                <p>{evento.local}</p>
            </div>
            <div className='blocoEvento' name="pessoasEnvolvidas">
                <h3>Pessoas envolvidas</h3>
                <p>{evento.pessoasEnvolvidas}</p>
            </div>
            <div className='blocoEvento' name="feedback">
                <h3> feedback</h3>
                <p>{evento.feedback}</p>
            </div>
            <div className='blocoEvento' name="pontosDeMelhoria">
                <h3>Pontos de melhoria</h3>
                <p>{evento.pontosDeMelhoria}</p>
            </div>
            <div className='blocoEvento' name="sentimentos">
                <h3>Sentimentos</h3>
            </div>
        </div>
    );
}