import React from 'react'
import { Link } from 'react-router-dom'

const HomePage = ({children}) => (
    <section className="contentHome">
        <h1>Welcome to the game</h1>
        
        <p>choose an option</p>
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
    
    </section>
)
export default HomePage