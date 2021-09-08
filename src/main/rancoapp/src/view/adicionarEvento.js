import React, { useEffect, useState } from "react";
import ReactDOM from 'react-dom';
import "../styles/adicionar.css"
import { logout, useAuthDispatch, useAuthState } from "../context";

export default ({ match }) => {
    const state = useAuthState();
    const [eventResponse, setEventResponse] = useState({});
    const [titulo, setTitulo] = useState();
    const [descricao, setDescricao] = useState();
    const [pontoMelhoria, setPontoMelhoria] = useState();
    const [expectativa, setExpectativa] = useState();
    const [feedback, setFeedback] = useState();
    const [categoria, setCategoria] = useState();
    const [motivo, setMotivo] = useState();
    const [date, setDate] = useState();
    const [local, setLocal] = useState();
    const [pessoasEnvolvidas, setPessoasEnvolvidas] = useState();
    const [sentimentos, setSentimentos] = useState([
        { data: '', descarrego: '', tipoSentimento: '', grauSentimento: '' }
    ]);

    const handleSentimentoslist = (e, index) => {
        const { name, value } = e.target;        
        const list = [...sentimentos];
        list[index][name] = value;
        setSentimentos(list);
    }
    const handleADDSentimentos = () => {
        setSentimentos([...sentimentos, { data: "", descarrego: '', tipoSentimento: '', grauSentimento: '' }]);
    }

    const handleRemoveSentimentos = index => {
        const list = [...sentimentos]
        list.splice(index, 1)
        setSentimentos(list);
    }
    const handleCategoria = (e) => {
        const { name, value } = e.target
        setCategoria(value)
    }
    const handleMotivo = (e) => {
        const { name, value } = e.target
        setMotivo(value)
    }

    const handleCreation = () => {
        const event = {
            titulo: titulo,
            local: local,
            data: date,
            pessoaEnvolvida: pessoasEnvolvidas,
            expectativa: expectativa,
            descricao: descricao,
            pontoMelhoria: pontoMelhoria,
            feedback: feedback,
            status: true,
            categoria: categoria,
            motivo: motivo,
            sentimentos: sentimentos
        }
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(event)
        };
        console.log(event)
        console.log(JSON.parse(state.userDetails).id)
        fetch(`http://localhost:5000/api/eventos/${JSON.parse(state.userDetails).id}`, requestOptions)
            .then(async response => {
                const isJson = response.headers.get('content-type')?.includes('application/json');
                const data = isJson && await response.json();

                console.log(data)
                // check for error response
                if (!response.ok) {
                    // get error message from body or default to response status
                    const error = (data && data.message) || response.status;
                    console.log(error);
                    return Promise.reject(error);
                }

                setEventResponse(data)        
                window.location.href = '/eventos'        
            })       
    }

    if (state.userDetails) {
        return (
            <div className='listaEvento' >
                <div className='header'>
                    <textarea rows="1" cols="80" id="tituloInput" placeholder='Titulo'
                        required
                        value={titulo}
                        onChange={(e) => setTitulo(e.target.value)}
                    ></textarea>
                    <div className='status'>
                        <p>status</p>
                        <div className='blocoEvento' name="status" id='status'/>
                    </div>
                </div>
                <div className='colunas'>
                    <div className='coluna1'>
                        <div className='blocoEvento' name="descricao" id='descricao'>
                            <textarea rows="21" cols="80" id="novoProjeto" placeholder='descrição'
                                required
                                value={descricao}
                                onChange={(e) => setDescricao(e.target.value)}
                            ></textarea>
                        </div>
                        <div className='blocoEvento' name="sentimentos">
                            <div className='sentimentoField'>
                                <h3> Sentimentos</h3>
                                <button onClick={handleADDSentimentos} className='sentimentoButton'>Adicionar sentimento</button>
                            </div>
                            {sentimentos.map((item, i) => {
                                return (
                                    <div id='data' key={i} className="sentimentoField">
                                        <div className="sentimentoItem">
                                            <legend htmlFor="data">Data</legend>
                                            <input type="date" name='data'
                                                value={item.data}
                                                onChange={(e) => handleSentimentoslist(e, i)}
                                            />
                                        </div>
                                        <div className="sentimentoItem">
                                            <legend htmlFor="tipoSentimento">Sentimento</legend>
                                            <select name="tipoSentimento" id="select" value={item.tipoSentimento}
                                                required
                                                onChange={(e) => handleSentimentoslist(e, i)}
                                            >
                                                <option value={null} hidden>Selecione</option>
                                                <option value="RAIVA">Raiva</option>
                                                <option value="VERGONHA">Vergonha</option>
                                                <option value="TRISTEZA">Tristeza</option>
                                                <option value="CULPA">Culpa</option>
                                                <option value="FRUSTRACAO">Frustração</option>
                                                <option value="CHATEACAO">Chateação</option>
                                                <option value="MEDO">Medo</option>
                                            </select>
                                        </div>
                                        <div className="sentimentoItem">
                                            <legend htmlFor="grauSentimento">Intensidade</legend>
                                            <select className='custom-select' id="select" name="grauSentimento" value={item.grauSentimento}
                                                required
                                                onChange={(e) => handleSentimentoslist(e, i)}
                                            >
                                                <option value={null} hidden>Selecione</option>
                                                <option value="LEVE">Leve</option>
                                                <option value="MODERADO">Moderado</option>
                                                <option value="INTENSO">Intenso</option>
                                                <option value="INCONTROLAVEL">Incontrável</option>
                                                <option value="TRANQUILO">Tranquilo</option>
                                                <option value="MUITO">Muito</option>
                                                <option value="POUCO">Pouco</option>
                                            </select>
                                        </div>
                                        <textarea rows="3" cols="30" id="novoProjeto" placeholder='Descarrego ... desabafar faz bem'
                                            name='descarrego'
                                            value={item.descarrego}
                                            onChange={(e) => handleSentimentoslist(e, i)}
                                        ></textarea>
                                        <button className="sentimentoButton" onClick={i => handleRemoveSentimentos(i)}>Remover</button>
                                    </div>
                                )
                            })}
                        </div>
                        <div className='blocoEvento' name="pontosDeMelhoria">
                            <textarea rows="3" cols="80" id="novoProjeto" placeholder='Pontos de melhoria'
                                value={pontoMelhoria}
                                onChange={(e) => setPontoMelhoria(e.target.value)}
                            ></textarea>
                        </div>
                        <div className='blocoEvento' name="expectativa">
                            <textarea rows="3" cols="80" id="novoProjeto" placeholder='Expectativa'
                                value={expectativa}
                                onChange={(e) => setExpectativa(e.target.value)}
                            ></textarea>
                        </div>
                        <div className='blocoEvento' name="feedback">
                            <textarea rows="3" cols="80" id="novoProjeto" placeholder='Feedback'
                                value={feedback}
                                onChange={(e) => setFeedback(e.target.value)}
                            ></textarea>
                        </div>
                    </div>
                    <div className='coluna2'>
                        <div id='detalhes'>
                            <div className='blocoEvento' name="categoria">
                                <h3> Categoria</h3>
                                <div tag="fieldset">
                                    <div >
                                        <label className="texto">
                                            <input type="radio" name="categoria" value='AMIGOS' onChange={handleCategoria} />{' '}
                                            Amigos
                                        </label>
                                    </div>
                                    <div >
                                        <label className="texto">
                                            <input type="radio" name="categoria" value='DESCONHECIDOS' onChange={handleCategoria} />{' '}
                                            Desconhecidos
                                        </label>
                                    </div>
                                    <div >
                                        <label className="texto">
                                            <input type="radio" name="categoria" value='ESCOLA' onChange={handleCategoria} />{' '}
                                            Escola
                                        </label>
                                    </div>
                                    <div >
                                        <label className="texto">
                                            <input type="radio" name="categoria" value="FACULDADE" onChange={handleCategoria} />{' '}
                                            Faculdade
                                        </label>
                                    </div>
                                    <div>
                                        <label className="texto">
                                            <input type="radio" name="categoria" value='FAMILIA' onChange={handleCategoria} />{' '}
                                            Familia
                                        </label>
                                    </div>
                                    <div >
                                        <label className="texto">
                                            <input type="radio" name="categoria" value='TRABALHO' onChange={handleCategoria} /> {' '}
                                            Trabalho
                                        </label>
                                    </div>
                                </div>
                            </div>

                            <div className='blocoEvento' name="motivo">
                                <h3> Motivo</h3>
                                <div tag="fieldset">
                                    <div >
                                        <label className="texto">
                                            <input type="radio" name="motivo" value='CULPA' onChange={handleMotivo} />{' '}
                                            Culpa
                                        </label>
                                    </div>
                                    <div >
                                        <label className="texto">
                                            <input type="radio" name="motivo" value='MEDO' onChange={handleMotivo} />{' '}
                                            Medo
                                        </label>
                                    </div>
                                    <div >
                                        <label className="texto">
                                            <input type="radio" name="motivo" value='TIMIDEZ' onChange={handleMotivo} />{' '}
                                            Timidez
                                        </label>
                                    </div>
                                    <div >
                                        <label className="texto">
                                            <input type="radio" name="motivo" value='TRISTEZA' onChange={handleMotivo} />{' '}
                                            Tristeza
                                        </label>
                                    </div>
                                    <div>
                                        <label className="texto">
                                            <input type="radio" name="motivo" value='VERGONHA' onChange={handleMotivo} />{' '}
                                            Vergonha
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div className='blocoEvento' name="data">
                                <h3> Data</h3>
                                <input type="date" id="data" name="data" placeholder="Data"
                                    value={date}
                                    onChange={(e) => setDate(e.target.value)}>
                                </input>
                            </div>

                            <div className='blocoEvento' name="local">
                                <textarea rows="1" cols="20" id="novoProjeto" placeholder='Local'
                                    value={local}
                                    onChange={(e) => setLocal(e.target.value)}
                                ></textarea>
                            </div>
                            <div className='blocoEvento' name="pessoasEnvolvidas">
                                <textarea rows="3" cols="20" id="novoProjeto" placeholder='Pessoas Envolvidas'
                                    value={pessoasEnvolvidas}
                                    onChange={(e) => setPessoasEnvolvidas(e.target.value)}
                                ></textarea>
                            </div>

                            <button className='botao' id='salvar' onClick={handleCreation}>Salvar</button>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
    else {
        window.location.href = '/login';
    }
}