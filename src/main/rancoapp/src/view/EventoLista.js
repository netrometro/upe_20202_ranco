import React, { useEffect, useState } from "react";
import ReactDOM from 'react-dom';
import "../styles/lista.css"
import { Link } from "react-router-dom";
import { useAuthDispatch, useAuthState } from "../context";

export default (props) => {
    useEffect(() => {
        getEventos();
    }, [])

    const state = useAuthState();
    const [eventos, setEventos] = useState([]);
    const getEventos = () => {
        fetch(`http://localhost:5000/eventos/${JSON.parse(state.userDetails).id}`)
            .then(async response => {
                const data = await response.json();
                // check for error response
                if (!response.ok) {
                    // get error message from body or default to response statusText
                    const error = (data && data.message) || response.statusText;
                    return Promise.reject(error);
                }
                console.log(data);
                setEventos(data.eventos);
            })
    }


    if (state.userDetails) {


        return (
            <div>
                <div className='listaEvento'>
                    <div className='header'>
                        <h1 id='eventos'>Meus Eventos</h1>
                        {/* <button className='sentimentoButton' onClick={() => { props.history.push('/adicionarEvento') }}>Adicionar Evento</button> */}
                        <a className='sentimentoButton' href='/adicionarEvento' >Adicionar Evento</a>
                    </div>
                    {eventos.map((evento, i) => (
                        <Link to={`/eventos/${evento.id}`} key={evento.id}>
                            <div className='blocoEvento'>
                                <h3>{evento.titulo}</h3>
                                <div className='blocoEvento' name="status" id={evento.status ? 'statusTRUE' : 'statusFALSE'}>
                                </div>
                                <h3>Categoria : {evento.categoria}</h3>
                                {/* se o status for false bloco vermelho, se for true, verde */}
                            </div>
                        </Link>
                    ))}
                </div>

            </div>
        )
    }
    else {
        window.location.href = '/login'
    }
}
