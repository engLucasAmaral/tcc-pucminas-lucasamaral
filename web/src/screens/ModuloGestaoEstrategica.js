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
                    <CardTitle>Gestão Estratégica de Projetos</CardTitle>
                    <CardContainer>
                    <div>Tem como escopo prover a gestão estratégica de todos os
                        projetos municipais, na forma de uma Carteira de Projetos, com indicadores do andamento individual e
                        global dos projetos. Para este módulo será selecionada uma ferramenta de gerência de projetos que permita
                        fazer essa gestão de forma automática, sem a necessidade de muitas alterações, uma vez que não haverá
                        programadores disponíveis para tal;
                    </div>
                                            

                    </CardContainer>
                    
                </Content>                
            </Container>
        )
              }
    }
}