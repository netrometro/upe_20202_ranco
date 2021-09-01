import React from "react";
import "../styles/login.css"
import ReactDOM from 'react-dom';

class Login extends React.Component {
    render() {
        return (
            <div className='container'>
                <div className="container_login">
                    <form className="formulario">
                        <div >
                            <legend className="titulo">login</legend>
                            <label className="label">Email</label>
                            <input type="email" name="email" id="Email" placeholder="escreva seu email"/>
                        </div>
                        <div >
                            <label className="label">Senha</label>
                            <input type="password" name="password" id="Password" placeholder="escreva sua senha"/>
                        </div>
                    </form>
                    <button className="botao" size="lg" > Login </button>{' '}
                </div>           
            </div>
        );
    };
};

export default Login;