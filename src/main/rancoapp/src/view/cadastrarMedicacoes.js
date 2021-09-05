import React, { useEffect, useState } from "react";
import ReactDOM from 'react-dom';
import "../styles/adicionar.css"


export default ({ match }) => {

    return (
        <div className='listaMedicamento'>
            <textarea rows="1" cols="80" id="nome" placeholder='Nome'></textarea>

            <div className='colunas' id='colunas'>
                <div className='primeiraColuna'>
                    <div className='blocoEvento' name="descricao" id='descricao'>
                        <textarea rows="21" cols="80" id="novoProjeto" placeholder='descrição'></textarea>

                    </div>
                    <div className='blocoEvento' name="observacao" id='observacao'>
                        <textarea rows="21" cols="80" id="novoProjeto" placeholder='observacao'></textarea>

                    </div>
                </div>

                <div className='segundaColuna'>
                    <div className='blocoEvento' name="intervalo">
                        <h3>Intervalo</h3>
                        <input type={Number} id="intervalo" name="intervalo" placeholder="intervalo">
                        </input>
                    </div>
                    <div className='blocoEvento' name="ultimaDosagem">
                        <h3>Última Dosagem</h3>
                        <input type="date" id="data" name="ultimaDosagem" placeholder="Ultima Dosagem">
                        </input>
                    </div>
                    <div className='blocoEvento' name="posologia" id='posologia'>
                        <textarea id="novoProjeto" placeholder='posologia'></textarea>

                    </div>

                    <a className='botao' id='salvar'>Salvar</a>
                </div>



            </div>
        </div>

    );








}