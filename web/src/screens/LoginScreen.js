import React from 'react'
import styled from 'styled-components'
import { Link, withRouter } from 'react-router-dom'
import Input from '../components/InputText'
import Button from '../components/ButtonRounded'
import background from '../assets/login_background.jpg'
import logo from '../assets/logo.png'
import { Redirect } from 'react-router-dom'
import { isAuthenticated } from "../services/base";
const Container = styled.div`
    display: flex;
    flex: 1;
    justify-align: center;
    align-items: center;
    align-self: center;
`;

const ContainerForm = styled.form`
    display: flex;
    flex: 1;
    flex-direction: column;
    justify-align: center;
    align-items: center;
    align-self: center;
    width: 400px;
    z-index: 1;
    margin-top: 150px;
`;

const Filter = styled.div`
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100vh;
    background-color: rgba(218, 237, 213, 0.83);   
`;

const Background = styled.img`
    position: absolute;
    top: 0;
    left: 0;
    height: 100vh;
    width: 100%;
`;

const Logo = styled.img`
    height: 340px;
    width: auto;
    margin-bottom: 20px;
    margin-top: 150px;
`;

const Title = styled.h2`
    color: #5D483C;
`;

const Anchor = styled(Link)`
    color: #5D483C;
    text-decoration: none;
    margin: 10px 0;
`;

const Error = styled.div`
    color: #FF0000;
`;

class LoginScreen extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            email: '',
            password: '',
            error: null,
        }
    }

    componentDidMount() {

    }

    handleLogin = (event) => {
        event.preventDefault();
        if (this.state.email === 'tcc' && this.state.password === 'tcc123') {
            localStorage.setItem('USER_NAME', 'Usuário logado...');
            localStorage.setItem('TOKEN_PMBD', 'TCC');
            localStorage.setItem('COUNT', '1');
            this.props.history.push('/home');
            window.location.reload(false);
        } else {
            this.setState({ error: true });
        }
    }

    handleLoginVisitante = (event) => {
        event.preventDefault();

        localStorage.setItem('USER_NAME', 'Visitante');
        localStorage.setItem('TOKEN_PMBD', 'VISITANTE');
        localStorage.setItem('COUNT', '1');
        this.props.history.push('/home');
        window.location.reload(false);



    }


    handleChange = (event) => {
        this.setState({ [event.target.name]: event.target.value });
    }

    render() {
        const { email, password, error } = this.state;
        if (isAuthenticated()) {
            return <Redirect to='/home' />
        } else {
            return (
                <Container>
                    <Background src={background} />
                    <Filter />
                    <ContainerForm onSubmit={this.handleLogin}>
                        {/* <Logo src={logo} alt='Sifar WEB / NF3e' /> */}
                        <Title>LOGIN</Title>
                        <Input type='text' placeholder='Usuario' name='email' value={email} change={this.handleChange} required='required' />
                        <Input type='password' placeholder='Senha' name='password' value={password} change={this.handleChange} required='required' />
                        {error &&
                            <Error>Usuário e/ou Senha invalido!</Error>
                        }
                        <Button type='submit' title='entrar' />
                        <Anchor to="#" onClick={this.handleLoginVisitante}>Entrar como visitante</Anchor>
                    </ContainerForm>
                </Container>
            )
        }
    }
}

export default withRouter(LoginScreen);