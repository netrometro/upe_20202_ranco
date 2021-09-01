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
                            <div >
                                <legend className="texto">Cadastro</legend>
                                <label className="label" >Email</label>
                                <input type="email" name="email" id="Email" placeholder="escreva seu email"/>
                            </div>
                            <div >
                                <label className="label">Senha</label>
                                <input type="password" name="password" id="Password" placeholder="escreva sua senha"/>
                            </div>

                            <div tag="fieldset">
                                <legend className="texto">Tipo de Usuario</legend>
                                <div >
                                    <label className="texto">
                                    <input  type="radio" name="tipo"/>{' '}
                                    Psicologo
                                    </label>
                                </div>
                                <div>
                                    <label className="texto">
                                    <input type="radio" name="tipo"/>{' '}
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
                        <button className="botao" size="lg" > Cadastrar </button>{' '}
                    </div>
                </div>
            </div>
        );
    };
};

export default Cadastro;