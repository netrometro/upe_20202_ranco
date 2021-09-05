import React, { useEffect, useState } from "react";
import ReactDOM from 'react-dom';
import "../styles/adicionar.css"

export default ({match}) => {
    return (
        <div className='listaEvento' >
            <div className= 'header'>
            <h1>titulo</h1>
                <div className='blocoEvento' name="status" id='status'>
                    <p>status</p>
                </div>
            </div>
            <div className='colunas'>
                <div className='coluna1'>
                    <div className='blocoEvento' name="descricao" id='descricao'>
                        <h3> Descrição</h3>
                        <textarea rows="3" cols="50" name="projectname" id="novoProjeto" placeholder= 'descrição'></textarea>
                </div>
                <div className='blocoEvento' name="sentimentos">
                        <h3>Sentimentos</h3>
                </div>
                <div className='blocoEvento' name="pontosDeMelhoria">
                    <h3>Pontos de melhoria</h3>
                </div>
                </div>
                <div className='coluna2'>
                    <div id='detalhes'>
                    <div  className='blocoEvento' name="categoria">
                        <h3> Categoria</h3>
                    </div>
                    
                    <div className='blocoEvento' name="motivo">
                        <h3> Motivo</h3>
                    </div>
                    <div className='blocoEvento' name="data">
                        <h3> Data</h3>
                    </div>
                    <div className='blocoEvento' name="expectativa">
                        <h3> Expectativa</h3>
                    </div>
                    <div className='blocoEvento' name="local">
                        <h3> local</h3>
                    </div>
                    <div className='blocoEvento' name="pessoasEnvolvidas">
                        <h3>Pessoas envolvidas</h3>
                    </div>
                    <div className='blocoEvento' name="feedback">
                        <h3> feedback</h3>
                    </div>
                    
                    
            </div>
            
            
                </div>
            </div>
        </div>
    );
}