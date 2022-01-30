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
                    <CardTitle>Informações Municipais de Georreferenciamento</CardTitle>
                    <CardContainer>
                    <div>Trata-se de um módulo prioritário, cujo escopo
                        consiste em obter, via imagens de satélites e informações de órgãos como o Instituto Brasileiro de Geografia
                        e Estatística (IBGE) - www.ibge.gov.br e outros, manter e tornar disponíveis dados geográficos de diversas
                        naturezas. Os dados a serem mantidos serão utilizados para compor uma Infraestrutura de Dados Espaciais
                        (IDE), devendo seguir as diretrizes nacionais para a área, preconizadas pelo IBGE. A título de exemplo,
                        recomenda-se visitar as páginas de informações geográficas disponíveis na Prefeitura de Belo Horizonte
                        ( https://bhgeo.pbh.gov.br/apresentacao-da-infraestrutura-de-dados-espaciais-ide ).</div>
                       

                    </CardContainer>
                    
                </Content>                
            </Container>
        )
              }
    }
}