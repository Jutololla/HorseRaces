import React from 'react'
import { Link } from 'react-router-dom'
import { connect } from 'react-redux'
import { postGame } from '../actions/gameActions'
const HomePage = ({ dispatch, loading, redirect, numberplayer,tracklength,idgame}) => {
    console.log(idgame)
    return(
    <section className="contentHome">
        <h1>Bienvenido a la carrera de caballos</h1>
        
        <p>Escoja una opcion</p>
        <div>
        <Link to="/crearjugadores" className="button">
        ▶️ Crear Jugadores
        </Link>
        </div>
        <div>
        <Link to="/configurarjuego" className="button" >
        ▶️ Configurar Juego
        </Link>
        </div>

        <div>
        <Link to="/iniciarjuego" className="button">
        ▶️ Iniciar Juego
        </Link>
        </div>

        <div>
        <Link to="/mejoresjugadores" className="button">
        ▶️ Mejores Jugadores
        </Link>
        </div>
    
    </section>
    )
    }
const mapStateToProps = state => ({
    loading: state.game.loading,
    redirect: state.game.redirect,
    hasErrors: state.game.hasErrors,
    idgame:state.game.idgame
})
export default connect(mapStateToProps)(HomePage);