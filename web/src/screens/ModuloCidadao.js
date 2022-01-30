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
                    <CardTitle>Serviços ao Cidadão</CardTitle>
                    <CardContainer>
                    <div>Esta parte do sistema é um módulo com um grande número de serviços
                        a serem oferecidos aos munícipes, sendo os principais: consultas a informações de interesse do cidadão –
                        Imposto Predial e Territorial Urbano (IPTU), Imposto Territorial Rural (ITR). Deverá possibilitar acesso
                        seletivo ao STUR, fazendo diferenciação entre o tipo de pessoa (física, jurídica, rural) na recuperação de
                        dados. Os fluxos dos principais processos realizados pelo executivo municipal também constarão deste
                        módulo, podendo-se assim conhecer o catálogo de serviços realizados pelos órgãos municipais e seu
                        workflow;</div>
                       

                    </CardContainer>
                    
                </Content>                
            </Container>
        )
    }}
}