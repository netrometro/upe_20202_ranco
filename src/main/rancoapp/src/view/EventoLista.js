import React, { useEffect, useState } from "react";
import ReactDOM from 'react-dom';
import { Link } from "react-router-dom";

export default () => {
    useEffect(() => {
        getEventos();
    }, [])

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
                setEventos(data);
            })
    }

    return (
        <div>
            <h1>Meus eventos</h1>
            {eventos.map(evento => (
                <Link to={`/eventos/${evento.id}`}>
                    <div key={evento.id}>
                        <h3>{evento.titulo}</h3>
                    </div>
                </Link>
            ))}
        </div>
    )
}
