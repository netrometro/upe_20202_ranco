import React, { useState, useEffect } from "react";
import "../styles/usuario.css"
import ReactDOM from 'react-dom';
import { useAuthDispatch, useAuthState } from "../context";

function Perfil() {
    
    const state = useAuthState();

    const [user, setUser] = useState()
    useEffect(() => {
        setUser(JSON.parse(state.userDetails));
    }, [])

    console.log(user)

    const returnName = () =>{
        let name = JSON.parse(state.userDetails).nome? JSON.parse(state.userDetails).nome : " "
        return name
    }

    const returnEmail = () =>{
        let email = JSON.parse(state.userDetails).email? JSON.parse(state.userDetails).email : " "
        return email
    }

    return (
        <div className='container'>
            <div id='usuario'>
                <h1 id='titulo'>Informações</h1>
                <legend>Nome</legend>
                <textarea id='perfil' readOnly value={returnName()} ></textarea>

                <legend>Email</legend>
                <textarea id='perfil' readOnly value={returnEmail()} ></textarea>
                <a className='botaoAlterar'>
                    Alterar
                </a>
            </div>
            
        </div>
    );
};

export default Perfil;