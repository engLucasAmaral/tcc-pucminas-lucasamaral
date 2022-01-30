import React from 'react'
import {isAuthenticated } from "../services/base";
import { Redirect } from 'react-router-dom'


export default class AuditoriaScreen extends React.Component {
    render() {
        if (!isAuthenticated()) {
            return <Redirect to='/login' />
        } else {
            return <Redirect to='/home' />
         
        }
    }
}