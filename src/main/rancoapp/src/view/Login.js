import React, { useState } from "react";
import "../styles/login.css"
import ReactDOM from 'react-dom';
import { loginUser, useAuthDispatch, useAuthState } from "../context";
import { AuthReducer, initialState } from "../context/reducer";


function Login() {

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const dispatch = useAuthDispatch()
    const { loading, errorMessage } = useAuthState()

    const handleLogin = async (e) => {
        e.preventDefault();
        const payload = { email: email, password: password }
        try {
            let response = await loginUser(dispatch, payload)
            if (!response) return
            window.location.href = '/'
        } catch (error) {
            console.log(error)
        }
    }

    return (
        <div className='container'>
            <div className="container_login">
                <form className="formulario" onSubmit={handleLogin}>
                    <legend className="titulo">Login</legend>
                    <legend className="label">Email</legend>
                    <input type="email" name="email" id="Email" placeholder="escreva seu email" required
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                    />
                    <legend className="label">Senha</legend>
                    <input type="password" name="password" id="Password" placeholder="escreva sua senha" required
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                    {
                        loading
                            ? <p>Carregando ..</p>
                            : <button className="botao"> Login </button>
                    }
                    {/* {
                        errorMessage
                            ? <p>{errorMessage.}</p>
                            : <></>
                    } */}

                    <a id="subscribeLogin" href="/cadastro">Cadastre-se</a>
                </form>
            </div>
        </div>
    );
};

export default Login;