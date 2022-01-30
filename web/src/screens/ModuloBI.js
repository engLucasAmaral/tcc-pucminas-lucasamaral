import React from 'react'
import styled from 'styled-components'
import NavbarTop from '../components/NavbarFixedTop'
import NavbarLeft from '../components/NavbarLeft'
import {isAuthenticated } from "../services/base";
import { Redirect } from 'react-router-dom'

const Container = styled.div`
    flex: 1;
`;

const Content = styled.div`
    flex: 1;
    display: flex;
    flex-direction: column;
    margin-left: 280px;
    padding: 0 50px;
    padding-top: 124px;
`;

const CardTitle = styled.div`
    font-size: 24px;
    text-align: left;
    line-height: 2rem;
    font-family: 'Roboto', sans-serif;
    padding: 16px;
    background-color: #091E40;
    border-color: #091E40;
    border-radius: 4px;
    color: #fff;
`;

const CardContainer = styled.div`
    display: flex;
    background-color: #fff;
    border-radius: 4px;
    margin-top: 40px;
    padding: 20px;
    align-items: flex-end;
`;

export default class AuditoriaScreen extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            showModal: false,
            loading: false,
            data: []
        }
    }

    
    render() {
        if (!isAuthenticated()) {
            return <Redirect to='/login' />
        } else {
              return (
            <Container>
                <NavbarTop />
                <NavbarLeft />
                <Content>
                    <CardTitle>Business Intelligence</CardTitle>
                    <CardContainer>
                    <div>Este módulo do sistema deverá utilizar ferramentas adequadas
                                para mineração dos dados sócio-econômicos e de gestão, que estão persistidos em diferentes bases de dados,<br/>
                                utilizando Sistemas Gerenciadores de Bancos de Dados (SGBDs) relacionais e/ou noSQL (algumas dessas
                                tecnologias ainda estão em aberto) O uso de recursos de Data Warehouse (DW), nesse contexto, será
                                essencial para o sucesso desta iniciativa;
                    </div>
                                                    

                    </CardContainer>
                    
                </Content>                
            </Container>
        )
}
    }
}