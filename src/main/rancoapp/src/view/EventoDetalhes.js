import React, { useEffect, useState } from "react";
import ReactDOM from 'react-dom';
import { Link } from "react-router-dom";
import { useAuthState } from "../context";
<script crossorigin src="..."></script>
export default ({ match, history }) => {
    useEffect(() => {
        getEvento(match.params.id);
    }, [])
    const state = useAuthState();
    const [evento, setEvento] = useState({});
    const [sentimentos, setSentimentos] = useState([]);
    const [date, setDate] = useState();
    const getEvento = (id) => {
        fetch(`http://localhost:5000/api/eventos/${id}`)
            .then(response => response.json())
            .then((response) => {
                setEvento(response)
                setSentimentos(response.sentimentos)
                setDate(response.data)
            })

    }

    const returnDate = () => {
        let dataString = date
        if (typeof dataString === 'string') {
            dataString = dataString.slice(0, 10)
        }
        return dataString
    }

    function setStatusColor(status) {
        try {
            if (status == false) {
                document.getElementById('status').style.background = 'red';

            }
            else {
                document.getElementById('status').style.background = 'green';
            }
        } catch (e) {
            console.log(e)
        }
    }

    const deleteEvent = (id) => {
        const requestOptions = {
            method: 'DELETE',
        };
        fetch(`http://localhost:5000/api/eventos/${id}`, requestOptions)
            .then(response => response.json())
            .then((response) => {
                if (response.id) {
                    window.location.href = '/eventos'
                }
            })
    }

    if (state.userDetails) {
        return (
            <div className='listaEvento' >
                <div className='header'>
                    <h1>{evento.titulo}</h1>
                    <div className='blocoEvento' name="status" id='status'>
                        <p>{(setStatusColor(evento.status))}</p>
                    </div>
                </div>
                <div className='colunas'>
                    <div className='coluna1'>
                        <div className='blocoEvento' name="descricao" id='descricao'>
                            <h3> Descrição</h3>
                            <p>{evento.descricao}</p>
                        </div>
                        <div className='blocoEvento' name="sentimentos">
                            <div className='sentimentoField'>
                                <h3> Sentimentos</h3>
                            </div>
                            {sentimentos? sentimentos.map((item, i) => {
                                return (
                                    <div id='data' key={i} className="sentimentoField">
                                        <div className="sentimentoItem">
                                            <legend htmlFor="data">Data</legend>
                                            <input type="date" name='data'
                                                value={item.data.slice(0, 10)}
                                                readOnly
                                            />
                                        </div>
                                        <div className="sentimentoItem">
                                            <legend htmlFor="tipoSentimento">Sentimento</legend>
                                            <p>{item.tipoSentimento}</p>
                                        </div>
                                        <div className="sentimentoItem">
                                            <legend htmlFor="grauSentimento">Intensidade</legend>
                                            <p>{item.grauSentimento}</p>
                                        </div>
                                        <textarea rows="3" cols="30" id="novoProjeto" placeholder='Descarrego ... desabafar faz bem'
                                            name='descarrego'
                                            value={item.descarrego}
                                            readOnly
                                        ></textarea>
                                    </div>
                                )
                            }): <></>}
                        </div>
                        <div className='blocoEvento' name="pontosDeMelhoria">
                            <h3>Pontos de melhoria</h3>
                            <p>{evento.pontoMelhoria}</p>
                        </div>
                    </div>
                    <div className='coluna2'>
                        <div id='detalhes'>
                            <div className='blocoEvento' name="categoria">
                                <h3> Categoria</h3>
                                <p>{evento.categoria}</p>
                            </div>

                            <div className='blocoEvento' name="motivo">
                                <h3> Motivo</h3>
                                <p>{evento.motivo}</p>
                            </div>
                            <div className='blocoEvento' name="data">
                                <h3> Data</h3>
                                <p>{returnDate()}</p>
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
                                <p>{evento.pessoaEnvolvida}</p>
                            </div>
                            <div className='blocoEvento' name="feedback">
                                <h3> feedback</h3>
                                <p>{evento.feedback}</p>
                            </div>


                        </div>


                    </div>
                </div>
                <div className="header">
                    <button className="sentimentoButtonDanger sentimentoItem" onClick={() => deleteEvent(evento.id)}>Remover</button>
                    <Link to={`/eventos/update/${evento.id}`}>
                        <button className="sentimentoButton sentimentoItem">Alterar</button>
                    </Link>
                </div>
            </div>
        );
    }
    else {
        window.location.href = '/login';
    }
    console.log(evento)
}