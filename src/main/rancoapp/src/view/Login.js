import React from "react";
import "../styles/login.css"
import { Button, Form, FormGroup, Label, Input} from 'reactstrap';
import ReactDOM from 'react-dom';

class Cadastro extends React.Component {
    render() {
        return (
            <div className="container_login">
                <form className="formulario">
                    <FormGroup >
                        <legend className="titulo">login</legend>
                        <label className="label" for="email">Email</label>
                        <Input type="email" name="email" id="Email" placeholder="escreva seu email"/>
                    </FormGroup>
                    <FormGroup >
                        <label className="label" for="password">Senha</label>
                        <Input type="password" name="password" id="Password" placeholder="escreva sua senha"/>
                    </FormGroup>
                </form>
                <Button className="botao" size="lg" > Login </Button>{' '}
            </div>           
        );
    };
};

export default Cadastro;