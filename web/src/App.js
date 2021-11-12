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
import ConfigurarJuegoPage from './pages/SettingsGamePage'
import StartGamePage from './pages/StartGamePage'
import bestPlayerPage from './pages/BestPlayerPage'
import Footer from "./components/Footer"
import Header from './components/Header'
import StartPage from './pages/StartPage'
import PodioPage from './pages/PodioPage'

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
      <Route exact path="/mejoresjugadores" component={bestPlayerPage} />
      <Route exact path="/start" component={StartPage} />
      <Route exact path="/podio" component={PodioPage} />
      <Redirect to="/"/>
    </Switch>

    </Router>

    


    </>
  )
}

export default App
