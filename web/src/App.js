import React from 'react'
import { Route, BrowserRouter as Router, Switch } from 'react-router-dom'
import GestaoPessoasScreen from './screens/GestaoPessoasScreen'
import ModuloBI from './screens/ModuloBI'
import ModuloCidadao from './screens/ModuloCidadao'
import ModuloGeorreferenciamento from './screens/ModuloGeorreferenciamento'
import ModuloGestaoEstrategica from './screens/ModuloGestaoEstrategica'
import ModuloIntegracaoGeral from './screens/ModuloIntegracaoGeral'
import LoginScreen from './screens/LoginScreen'
import PortalScreen from './screens/PortalScreen'

import './App.css'

const routes = [
  {
    path: '/',
    component: PortalScreen
  },
  {
    path: '/login',
    component: LoginScreen
  },
  {
    path: '/home',
    component: GestaoPessoasScreen
  },
  {
    path: '/bi',
    component: ModuloBI
  },
  {
    path: '/cidadao',
    component: ModuloCidadao
  },
  {
    path: '/gestao',
    component: ModuloGestaoEstrategica
  },
  {
    path: '/integracao',
    component: ModuloIntegracaoGeral
  },
  {
    path: '/mapas',
    component: ModuloGeorreferenciamento
  }
];


// <Button to='/home' title='Gestão de Pessoas'  icon={<ListUlIcon />} />
// <Button to='/mapas' title='Mapas   ' icon={<ListUlIcon />} />
// <Button to='/cidadao' title='Cidadão' icon={<ListUlIcon />} />
// <Button to='/gestao' title='Gestão Estratégica' icon={<ListUlIcon />} />
// <Button to='/bi' title='BI' icon={<ListUlIcon />} />
// <Button to='/integracao' title='Integração Geral' icon={<ListUlIcon />} />

function App() {
  return (
    <Router basename="portal">
      <div className='App'>
        <Switch >
          {routes.map((route) => (
            <Route
              exact
              key={route.path}
              path={route.path}
              component={route.component}
            />
          ))}
        </Switch>
      </div>
    </Router>
  );
}

export default App;
