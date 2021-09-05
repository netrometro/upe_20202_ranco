import React, { useEffect, useState } from "react";
import ReactDOM from 'react-dom';
import "../styles/lista.css"
import { Link } from "react-router-dom";
import { useAuthDispatch, useAuthState } from "../context";

export default () => {
    useEffect(() => {
        getEventos();
    }, [])
    const state = useAuthState();
    const dispatch = useAuthDispatch()

    const [eventos, setEventos] = useState([]);

    const getEventos = () => {
        fetch('http://localhost:5000/api/eventos')
            .then(async response => {
                const data = await response.json();

                // check for error response
                if (!response.ok) {
                    // get error message from body or default to response statusText
                    const error = (data && data.message) || response.statusText;
                    return Promise.reject(error);
                }
                console.log(data);
                setEventos(data);
            })
    }

    if (state.userDetails) {

        return (
            <div>
                <div className='listaEvento'>
                    <h1 id='eventos'>Dashboard</h1>
                    <a href='/adicionarEvento'>Adicionar Evento</a>
                    {eventos.map((evento) => (
                        <Link to={`/eventos/${evento.id}`} key={evento.id}>
                            <div className='blocoEvento'>
                                <h3>{evento.titulo}</h3>
                                <h3>Categoria : {evento.categoria}</h3>
                                {/* se o status for false bloco vermelho, se for true, verde */}
                            </div>
                        </Link>
                    ))}

                </div>

            </div>
        )
    }
    else{
        window.location.href = '/login';
    }
}
