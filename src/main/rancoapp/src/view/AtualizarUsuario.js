import React, { useState, useEffect } from "react";
import "../styles/usuario.css"
import ReactDOM from 'react-dom';
import { loginUser, logout, useAuthDispatch, useAuthState } from "../context";

function AtualizarUsuario() {

    const state = useAuthState();

    const [user, setUser] = useState()
    const [nome, setNome] = useState()
    const [email, setEmail] = useState()
    const [password, setPassword] = useState()
    const dispatch = useAuthDispatch()

    useEffect(() => {
        setUser(JSON.parse(state.userDetails));
        setNome(JSON.parse(state.userDetails).nome)
        setEmail(JSON.parse(state.userDetails).email)
        setPassword(JSON.parse(state.userDetails).senha)
    }, [])

    const handleUpdate = () => {
        const usuario = { nome: nome, email: email, senha: password }
        const requestOptions = {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(usuario)
        };
        console.log(usuario)
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
                updateFront(data)
            })
    }

    const updateFront = async (data) => {
        localStorage.setItem('currentUser', JSON.stringify(data)); 
        window.location.reload();     
    }

    return (
        <div className='container'>
            <div id='usuario'>
                <h1 id='titulo'>Informações</h1>
                <legend>Nome</legend>
                <textarea id='perfil' value={nome} onChange={e => setNome(e.target.value)}></textarea>

                <legend>Email</legend>
                <textarea id='perfil' value={email} onChange={e => setEmail(e.target.value)}></textarea>

                <legend>Senha</legend>
                <input type='password' id='perfil' value={password} onChange={e => setPassword(e.target.value)}></input>
                <button className='botaoAlterar' id='alterar' onClick={handleUpdate}>
                    Alterar
                </button>
            </div>

        </div>
    );
};

export default AtualizarUsuario;