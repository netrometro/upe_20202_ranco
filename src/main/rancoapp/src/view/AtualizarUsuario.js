import React, { useState, useEffect } from "react";
import "../styles/usuario.css"
import ReactDOM from 'react-dom';
import { useAuthDispatch, useAuthState } from "../context";

function AtualizarUsuario() {
    
    const state = useAuthState();

    const [user, setUser] = useState()
    useEffect(() => {
        setUser(JSON.parse(state.userDetails));
    }, [])

    const handleCreation = () => {
        
        const requestOptions = {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(user)
        };
        console.log(user)
        // console.log(JSON.parse(event).id)
        fetch(`http://localhost:5000/api/pacientes/${JSON.parse(state.userDetails).id}`, requestOptions)
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

                setUser(data)
                handleLogin(user)
            })
    }

    const returnName = () =>{
        let name = JSON.parse(state.userDetails).nome? JSON.parse(state.userDetails).nome : " "
        return name
    }

    const returnEmail = () =>{
        let email = JSON.parse(state.userDetails).email? JSON.parse(state.userDetails).email : " "
        return email
    }

    const returnSenha = () =>{
        let email = JSON.parse(state.userDetails).email? JSON.parse(state.userDetails).senha : " "
        return email
    }

    return (
        <div className='container'>
            <div id='usuario'>
                <h1 id='titulo'>Informações</h1>
                <legend>Nome</legend>
                <textarea id='perfil' value={returnName()} ></textarea>

                <legend>Email</legend>
                <textarea id='perfil' value={returnEmail()} ></textarea>
                
                <legend>Senha</legend>
                <input type='password' id='perfil' ></input>
                <a className='botaoAlterar'>
                    Alterar
                </a>
            </div>
            
        </div>
    );
};

export default AtualizarUsuario;