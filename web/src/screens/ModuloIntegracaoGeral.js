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
                    <CardTitle>Integracao Geral</CardTitle>
                    <CardContainer>
                    <div>Este é o core, ou seja, o núcleo de todo o processo de integração entre as
                            diferentes tecnologias e aplicações existentes, de modo a prover transparência, disponibilidade e robustez
                            para esta integração geral. 
                            <br />Deverá fazer uso de tecnologias middleware, tais como: Remote Procedure Call
                            (RPC), serviços de mensageria, protocolos como HTTP, TCP/IP, SOAP, Rest, GraphQL, etc. 
                            <br/>A escolha
                            PUC Minas Virtual ▪ Escopo de Sistema 4das tecnologias deve se basear preferencialmente em produtos das empresas Apache e Red Hat, que
                            possuem contratos vigentes com a prefeitura para este tipo de solução.</div>
                                                

                    </CardContainer>
                    
                </Content>                
            </Container>
        )
              }
    }
}