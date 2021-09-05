import React, { useEffect, useState } from "react";
import ReactDOM from 'react-dom';
import "../styles/lista.css"
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
                console.log(data);
                setEventos(data);
            })
    }

    return (
<<<<<<< HEAD
        <div>
            <div className='listaEvento'>
                <h1>Meus Eventos</h1>
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

=======
        <div className="container">
            <div className='quadro'>
                <h1>Meus eventos</h1>
                {eventos.map((evento) => (                
                    <Link to={`/eventos/${evento.id}`} key={evento.id}>
                        <div>
                            <h3>{evento.titulo}</h3>
                        </div>
                    </Link>
                ))}
            </div>
>>>>>>> telas_cadastro_e_login
        </div>
    )
}
