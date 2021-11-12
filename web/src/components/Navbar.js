import React from 'react'
import { Link } from 'react-router-dom'



export const PublicNavbar = () => (
    <nav>
        <section>
        <Link to="/">Inicio</Link> 
        
        <Link to="/CrearJugadores">Crear Jugadores</Link>
        <Link to="/listarjugadores">Lista de Jugadores</Link>
        <Link to="/configurarjuego">Configurar Juego</Link> 
        <Link to="/iniciarjuego">Iniciar Juego</Link>

        </section>
    </nav>
)
