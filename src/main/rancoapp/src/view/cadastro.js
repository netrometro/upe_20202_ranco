import React from "react";
import style from "../styles/cadastro.css"
import { Button, Form, FormGroup, Label, Input} from 'reactstrap';
import ReactDOM from 'react-dom';

class Cadastro extends React.Component {
    render() {
        return (
            <div className="container">
                <div className="conteudo">
                    <form className="formulario">
                        <FormGroup >
                            <legend className="texto">Cadastro</legend>
                            <label className="label" for="email">Email</label>
                            <Input type="email" name="email" id="Email" placeholder="escreva seu email"/>
                        </FormGroup>
                        <FormGroup >
                            <label className="label" for="password">Senha</label>
                            <Input type="password" name="password" id="Password" placeholder="escreva sua senha"/>
                        </FormGroup>

                        <FormGroup tag="fieldset">
                            <legend className="texto">Tipo de Usuario</legend>
                            <FormGroup check >
                                <label className="texto" check>
                                <input  type="radio" name="tipo"/>{' '}
                                Psicologo
                                </label>
                            </FormGroup>
                            <FormGroup check>
                                <label className="texto" check>
                                <input type="radio" name="tipo"/>{' '}
                                Paciente
                                </label>
                            </FormGroup>
                        </FormGroup>
                    </form>
                    <div className="descricao">
                        <text className="texto">Tipo de Usuario</text>
                        <text>Descrição</text>
                    </div>
                </div>
                <div className="botoes">
                    <Button className="botao" size="lg" > Cadastrar </Button>{' '}
                </div>
                                
            </div>
        );
    };
};

export default Cadastro;