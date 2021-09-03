import React, { useEffect, useState } from "react";
import ReactDOM from 'react-dom';
import { Link } from "react-router-dom";

export default () => {
    useEffect(() => {
        getMedicacao();
    }, [])

    const [medicacoes, setMedicacao] = useState([]);

    const getMedicacao = () => {
        fetch('http://localhost:5000/api/medicações') 
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
        <div>
            <h1>Minhas Medicações</h1>
            {medicacoes.map((medicacao) => (                
                <Link to={`/medicações/${medicacao.id}`} key={medicacao.id}>
                    <div>
                        <h3>{medicacao.nome}</h3>
                    </div>
                </Link>
            ))}
        </div>
    )
}
