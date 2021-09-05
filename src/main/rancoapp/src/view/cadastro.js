import React, { useState } from "react";
import "../styles/cadastro.css"
import ReactDOM from 'react-dom';

function Cadastro(props) {
    const [user, setUser] = useState("");
    const [nome, setNome] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [tipoUsuario, setTipoUsuario] = useState("");
    const [CRP, setCRP] = useState("");
    const [errorText, setErrorText] = useState("");

    const gotToLogin = () => {
        window.location.href = '/login'
    }

    const handleRadioChange = (e) => {
        const { name, value } = e.target;
        setTipoUsuario(value);
    }

    const cadastrar = () => {
        const user = tipoUsuario === "PACIENTE" ? { nome: nome, email: email, senha: password, tipoUsuario: tipoUsuario }
            : { nome: nome, email: email, password: password, tipoUsuario: tipoUsuario, crp: CRP }
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(user)
        };
        console.log(user)
        const url = tipoUsuario === "PACIENTE" ? "pacientes" : "psicologos"
        console.log(url)
        fetch('http://localhost:5000/api/' + url, requestOptions)
            .then(async response => {
                const isJson = response.headers.get('content-type')?.includes('application/json');
                const data = isJson && await response.json();

                // check for error response
                if (!response.ok) {
                    // get error message from body or default to response status
                    const error = (data && data.message) || response.status;
                    console.log(error);
                    setErrorText(error);
                    return Promise.reject(error);
                }

                setUser(data)
                props.history.push("/login")
            })
            .catch(error => {
                setErrorText(error.toString());
                console.error('There was an error!', error);
            });
    }
    return (
        <div className="container">
            <div className="container_cadastro">
                <div className="conteudo">
                    <form className="formulario">
                        <h1>Cadastro</h1>
                        <label className="label" >Nome</label>
                        <input type="nome" name="nome" id="nome" placeholder="escreva seu nome" required
                            value={nome}
                            onChange={(e) => setNome(e.target.value)} />
                        <label className="label" >Email</label>
                        <input type="email" name="email" id="Email" placeholder="escreva seu email" required
                            value={email}
                            onChange={(e) => setEmail(e.target.value)} />
                        <label className="label">Senha</label>
                        <input type="password" name="password" id="Password" placeholder="escreva sua senha" required
                            value={password}
                            onChange={(e) => setPassword(e.target.value)} />
                        <div>
                            <legend className="texto">Tipo de Usuario</legend>
                            <div>
                                <label className="texto">
                                    <input type="radio" name="tipo" value="PACIENTE" selected="selected" onChange={handleRadioChange} />{' '}
                                    Paciente
                                </label>
                            </div>
                            <div >
                                <label className="texto">
                                    <input type="radio" name="tipo" value="PSICOLOGO" onChange={handleRadioChange} />{' '}
                                    Psicologo
                                </label>
                            </div>
                        </div>
                        {
                            tipoUsuario === "PSICOLOGO" ?
                                <div>
                                    <label className="label" htmlFor="crp">CRP</label>
                                    <input type="text" name="crp" id="crp" placeholder="escreva seu CRP" />
                                </div>
                                : <></>
                        }

                    </form>

                    <div className="descricao">
                        <p className="texto">Tipo de Usuario</p>
                        {
                            tipoUsuario === 'PACIENTE' ?
                                <p>
                                    Pacientes são usuários que possuem dificuldade com ranço. Eles podem adicionar eventos
                                    que causaram sentimentos negativos, monitorando e acompanhando a evolução de seus casos.
                                </p>
                                :
                                <p>
                                    Psicologos são usuários que podem acompanhar pacientes, ajudando-os em suas dificuldades com ranço.
                                    Eles podem visualizar eventos dos pacientes e deixar conselhos, auxiliando-os em seus casos.
                                </p>
                        }
                        <p>Descrição</p>
                    </div>
                </div>
                <div className="botoes">
                    <button className="botao" onClick={cadastrar}> Cadastrar </button>{' '}
                    <button className="botao" onClick={gotToLogin}> Login </button>{' '}
                </div>

            </div>

        </div>
    );
};


export default Cadastro;