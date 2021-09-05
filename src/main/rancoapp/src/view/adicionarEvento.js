import React, { useEffect, useState } from "react";
import ReactDOM from 'react-dom';
import "../styles/adicionar.css"

export default ({match}) => {
    return (
        <div className='listaEvento' >
            <div className= 'header'>
            <textarea rows="1" cols="80"  id="titulo" placeholder= 'Titulo'></textarea>
                <div className='blocoEvento' name="status" id='status'>
                    <p>status</p>
                   {/*  <div tag="fieldset">
                        <div >
                            <label className="texto">
                            <input  type="radio" name="tipo"/>{' '}
                            Aberto
                            </label>
                        </div>
                        <div >
                            <label className="texto">
                            <input  type="radio" name="tipo"/>{' '}
                            Fechado
                            </label>
                        </div>
                    </div> */}
                </div>
            </div>
            <div className='colunas'>
                <div className='coluna1'>
                    <div className='blocoEvento' name="descricao" id='descricao'>
                        <textarea rows="21" cols="80" id="novoProjeto" placeholder= 'descrição'></textarea>
                </div>
                <div className='blocoEvento' name="sentimentos">
                    <h3> Sentimentos</h3>
                    <a href='/adicionarSentimento' >Adicionar sentimento</a>
                </div>
                <div className='blocoEvento' name="pontosDeMelhoria">
                    <textarea rows="3" cols="80"  id="novoProjeto" placeholder= 'Pontos de melhoria'></textarea>
                </div>
                <div className='blocoEvento' name="expectativa">
                        <textarea rows="3" cols="80"  id="novoProjeto" placeholder= 'Expectativa'></textarea>
                    </div>
                <div className='blocoEvento' name="feedback">
                        <textarea rows="3" cols="80"  id="novoProjeto" placeholder= 'Feedback'></textarea>
                    </div>
                </div>
                <div className='coluna2'>
                    <div id='detalhes'>
                    <div  className='blocoEvento' name="categoria">
                        <h3> Categoria</h3> 
                        <div tag="fieldset">
                                <div >
                                    <label className="texto">
                                    <input  type="radio" name="tipo"/>{' '}
                                    Amigos
                                    </label>
                                </div>
                                <div >
                                    <label className="texto">
                                    <input  type="radio" name="tipo"/>{' '}
                                    Desconhecidos
                                    </label>
                                </div>
                                <div >
                                    <label className="texto">
                                    <input  type="radio" name="tipo"/>{' '}
                                    Escola
                                    </label>
                                </div>
                                <div >
                                    <label className="texto">
                                    <input  type="radio" name="tipo"/>{' '}
                                    Faculdade
                                    </label>
                                </div>
                                <div>
                                    <label className="texto">
                                    <input type="radio" name="tipo"/>{' '}
                                    Familia
                                    </label>
                                </div>
                                <div >
                                    <label className="texto">
                                    <input  type="radio" name="tipo"/>{' '}
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
                                    <input  type="radio" name="tipo"/>{' '}
                                    Culpa
                                    </label>
                                </div>
                                <div >
                                    <label className="texto">
                                    <input  type="radio" name="tipo"/>{' '}
                                    Medo
                                    </label>
                                </div>
                                <div >
                                    <label className="texto">
                                    <input  type="radio" name="tipo"/>{' '}
                                    Timidez
                                    </label>
                                </div>
                                <div >
                                    <label className="texto">
                                    <input  type="radio" name="tipo"/>{' '}
                                    Tristeza
                                    </label>
                                </div>
                                <div>
                                    <label className="texto">
                                    <input type="radio" name="tipo"/>{' '}
                                    Vergonha
                                    </label>
                                </div>
                            </div>
                    </div>
                    <div className='blocoEvento' name="data">
                        <h3> Data</h3>
                        <input type="date" id="data" name="data" placeholder="Data">
                        </input>
                    </div>
                    
                    <div className='blocoEvento' name="local">
                        <textarea rows="1" cols="20" id="novoProjeto" placeholder= 'Local'></textarea>
                    </div>
                    <div className='blocoEvento' name="pessoasEnvolvidas">
                        <textarea rows="3" cols="20"  id="novoProjeto" placeholder= 'Pessoas Envolvidas'></textarea>
                    </div>
                    
                    
                    
            </div>
            
            
                </div>
            </div>
        </div>
    );
}