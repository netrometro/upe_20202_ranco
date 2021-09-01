import React, { useState } from "react";
import "../styles/login.css"
import ReactDOM from 'react-dom';

function Login() {

    const [user, setUser] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");    
    const [errorText, setErrorText] = useState("");

    const login = () => {
        console.log("Login chamado")
        const account = {email: email, password: password}
        console.log(account)
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(account)            
        };
        fetch('http://localhost:5000/login', requestOptions)
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
                // console.log(data.toString())
            })
            .catch(error => {
                setErrorText(error.toString());
                console.error('There was an error!', error);
            });
    }

    const handleSubmit = (e) => {
        e.preventDefault();        
        login();
    }

    return (
        <div className='container'>
            <div className="container_login">
                <form className="formulario" onSubmit={handleSubmit}>
                    <div >
                        <legend className="titulo">login</legend>
                        <label className="label">Email</label>
                        <input type="email" name="email" id="Email" placeholder="escreva seu email" required 
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                        />
                    </div>
                    <div >
                        <label className="label">Senha</label>
                        <input type="password" name="password" id="Password" placeholder="escreva sua senha" required 
                            value={password}
                            onChange={(e)=> setPassword(e.target.value)}
                        />
                    </div>
                    {/* <button className="botao" size="lg" > Login </button>{' '} */}
                    <button> Login </button>
                    { user !== null && user !== "" ? <p>{user.nome}</p>
                        : <p>{errorText}</p>
                    }
                </form>
                
            </div>
        </div>
    );
};

export default Login;