import React, { useEffect, useState } from "react";
import ReactDOM from 'react-dom';
import { Link } from "react-router-dom";

export default () => {
    useEffect(() => {
        getMedicacao();
    }, [])

    const [medicacoes, setMedicacao] = useState([]);

    const getMedicacao = () => {
        fetch('http://localhost:5000/api/medicacoes') 
            .then(async response => {
                const data = await response.json();

                // check for error response
                if (!response.ok) {
                    // get error message from body or default to response statusText
                    const error = (data && data.message) || response.statusText;
                    return Promise.reject(error);
                }
                console.log(data);
                setMedicacao(data);
            })
    }

    return (
        <div className= "listaEvento">
            <h1>Minhas Medicações</h1>
            {medicacoes.map((medicacao) => (                
                <Link to={`/medicacoes/${medicacao.id}`} key={medicacao.id}>
                    <div className= "blocoEvento">
                        <h3>{medicacao.nome}</h3>
                        <h3>Posologia: {medicacao.posologia}</h3>
                    </div>
                </Link>
            ))}
        </div>
    )
}
