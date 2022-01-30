import React from 'react'
import { Link } from 'react-router-dom'
import styled, { css } from 'styled-components'
import logo from '../assets/logo.png'
import Button from './ButtonLink'
import { Exit } from 'styled-icons/boxicons-regular/Exit';
import {   logout , isAuthenticated} from '../services/base'

const Navbar = styled.div`
    height: 84px;
    background-color: #FFFFFF;
    flex: 1 1 auto;
    width: calc(100% - 80px);
    display: block;
    box-shadow: 0px 2px 4px -1px rgba(0, 0, 0, 0.2), 0px 4px 5px 0px rgba(0, 0, 0, 0.14), 0px 1px 10px 0px rgba(0, 0, 0, 0.12);
    padding: 0 40px;
    margin: 0;
    display: flex;
    position: fixed;
    top: 0;
    left: 0;
    z-index: 1;
    align-items: center;
`;

const Grow = styled.div`
    flex-grow: 1 !important;
`;

const Logo = styled.img`
    height: 60px;
    width: 60px;
`;
const navbarIconStyle = css`
    color: #fff;
    height: 24px;
    width: 24px;
`;
const ExitIcon = styled(Exit)`
    ${navbarIconStyle}
`;

export default class NavbarFixedTop extends React.Component {
    logout = () => {
     
        localStorage.removeItem('TOKEN');
        localStorage.removeItem('USER_ID');
        logout();
        window.location.href = "/portal/login";
    }
    render() {
        return (
            <Navbar style={{ visibility: isAuthenticated() ? 'visible' : 'hidden' }}>
                <Link to='/home'>
                    <Logo src={logo} alt='TCC' />
                </Link>
                <Grow />
                <Button to="#" title='Sair' icon={<ExitIcon />} click={() => this.logout() } />
            </Navbar>
        )
    }
}