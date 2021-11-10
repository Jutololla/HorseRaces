import React from 'react'
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Redirect,
} from 'react-router-dom'

import { PublicNavbar} from './components/Navbar'
import HomePage from './pages/HomePage'
import CrearJugadoresPage from './pages/CreatePlayersPage.'
import ConfigurarJuegoPage from './pages/ConfigurarJuegoPage'
import StartGamePage from './pages/StartGamePage'
import Footer from "./components/Footer"
import Header from './components/Header'

const App = ({ dispatch }) => {
  return(
    <>
    <Header></Header>
    <Router>
    
    <Switch>
      <Route exact path="/" component={() => {
                return <HomePage></HomePage>
              }} />
      <Route exact path="/crearjugadores" component={CrearJugadoresPage} />
      <Route exact path="/configurarjuego" component={ConfigurarJuegoPage} />
      <Route exact path="/iniciarjuego" component={StartGamePage} />
      <Redirect to="/"/>
    </Switch>

    </Router>

    <Footer></Footer>


    </>
  )
}

export default App
