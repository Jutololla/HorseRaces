import React from 'react'
import { Link } from 'react-router-dom'

const HomePage = ({children}) => (
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
export default HomePage