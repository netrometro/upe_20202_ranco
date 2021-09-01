import React from "react";
import "../styles/cadastro.css"
import ReactDOM from 'react-dom';

class Cadastro extends React.Component {
    render() {
        return (
            <div className="container">
                    
                <div className="container_cadastro">
                    <div className="conteudo">
                        <form className="formulario">
                                <h1>Cadastro</h1>
                                <label className="label" >Email</label>
                                <input type="email" name="email" id="Email" placeholder="escreva seu email"/>

                                <label className="label">Senha</label>
                                <input type="password" name="password" id="Password" placeholder="escreva sua senha"/>

                            <div>
                                <legend className="texto">Tipo de Usuario</legend>
                                <div >
                                    <label className="texto">
                                    <input  id='opcoes' type="radio" name="tipo"/>{' '}
                                    Psicologo
                                    </label>
                                </div>
                                <div>
                                    <label className="texto">
                                    <input id='opcoes' type="radio" name="tipo"/>{' '}
                                    Paciente
                                    </label>
                                </div>
                            </div>

                        </form>

                        <div className="descricao">
                            <p className="texto">Tipo de Usuario</p>
                            <p>Descrição</p>
                        </div>
                    </div>
                    <div className="botoes">
                        <button className="botao"> Cadastrar </button>{' '}
                        <a href='/login' className="botao"> Login </a>{' '}
                    </div>

                </div>

            </div>
        );
    };
};

export default Cadastro;