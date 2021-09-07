import React, { useState } from "react";
import "../styles/usuario.css"
import ReactDOM from 'react-dom';


function Perfil() {


    return (
        <div className='container'>
            <div id='usuario'>
                <legend>Nome</legend>
                <legend>Email</legend>
                <legend>Senha</legend>
                <a className='botao'>
                    Alterar
                </a>
            </div>
            
        </div>
    );
};

export default Perfil;