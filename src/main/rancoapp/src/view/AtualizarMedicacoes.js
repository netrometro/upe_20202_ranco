import React, { useEffect, useState } from "react";
import ReactDOM from 'react-dom';
import "../styles/adicionar.css"
import { logout, useAuthDispatch, useAuthState } from "../context";


export default ({ match, history}) => {
    const state = useAuthState();
    const [medicacoesResponse, setMedicacoesResponse] = useState();
    const [id, setId] = useState();
    const [nome, setNome] = useState("");
    const [descricao, setDescricao] = useState("");
    const [observacao, setObservacao] = useState("");
    const [intervalo, setIntervalo] = useState("");
    const [ultimaDosagem, setUltimaDosagem] = useState("");
    const [posologia, setPosologia] = useState("");
    const [medicacoes, setMedicacoes] = useState({});

    useEffect(() => {
        getMedicacao(match.params.id);
    }, [])
    const getMedicacao = (id) => {
        fetch(`http://localhost:5000/api/medicacoes/${id}`)
            .then(response => response.json())
            .then((response) => {
                setMedicacoes(response)
                setId(response.id)
                setNome(response.nome)
                setDescricao(response.descricao)
                setObservacao(response.observacao)
                setIntervalo(response.intervalo)
                setUltimaDosagem(response.ultimaDosagem)
                setPosologia(response.posologia)                
            })
    }

    const cadastrar = () => {
        console.log()
        const medicacoes = {            
            nome: nome,
            descricao: descricao,
            observacao: observacao,
            intervalo: intervalo,
            ultimaDosagem: ultimaDosagem,
            posologia: posologia
        }

        const requestOptions = {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(medicacoes)
        };

        console.log(medicacoes)
        fetch(`http://localhost:5000/api/medicacoes/${id}`, requestOptions)
            .then(async response => {
                const isJson = response.headers.get('content-type')?.includes('application/json');
                const data = isJson && await response.json();

                // check for error response
                if (!response.ok) {
                    // get error message from body or default to response status
                    const error = (data && data.message) || response.status;
                    console.log(error);
                    return Promise.reject(error);
                }
                setMedicacoesResponse(data)
                window.location.href= '/medicacoes'
            })

    }


    if (state.userDetails) {

        return (
            <div className='listaMedicamento'>
                <textarea rows="1" cols="80" id="nome" placeholder='Nome'
                    value={nome}
                    onChange={e => setNome(e.target.value)}
                ></textarea>

                <div className='colunas' id='colunas'>
                    <div className='primeiraColuna'>
                        <div className='blocoEvento' name="descricao" id='descricao'>
                            <textarea rows="21" cols="80" id="novoProjeto" placeholder='Descrição'
                                value={descricao}
                                onChange={e => setDescricao(e.target.value)}
                            ></textarea>

                        </div>
                        <div className='blocoEvento' name="observacao" id='observacao'>
                            <textarea rows="21" cols="80" id="novoProjeto" placeholder='Observação'
                                value={observacao}
                                onChange={e => setObservacao(e.target.value)}
                            ></textarea>

                        </div>
                    </div>

                    <div className='segundaColuna'>
                        <div className='blocoEvento' name="intervalo">
                            <h3>Intervalo</h3>
                            <input type={Number} id="intervalo" name="intervalo" placeholder="intervalo"
                                value={intervalo}
                                onChange={e => setIntervalo(e.target.value)}
                            ></input>
                        </div>
                        <div className='blocoEvento' name="ultimaDosagem">
                            <h3>Última Dosagem</h3>
                            <input type="date" id="data" name="ultimaDosagem" placeholder="Ultima Dosagem"
                                value={ultimaDosagem.slice(0, 10)}
                                onChange={e => setUltimaDosagem(e.target.value)}
                            ></input>
                        </div>
                        
                        <button className='botao' id='salvar' onClick={cadastrar} >Salvar</button>
                    </div>
                </div>
            </div>
        );



    } else {
        window.location.href = '/login';
    }

}