import React from 'react'
import { Link } from 'react-router-dom'
const PlayerUpdate = (e) => {
    console.log(e.target.id)
    console.log("actualizar jugador")
    //validateInput(data) && dispatch(postQuestion(data));
}
const PlayerDelete = ({e}) => {
    console.log(e.target.id)
    console.log("eliminar jugador")
    //validateInput(data) && dispatch(postQuestion(data));
}

export const Player = ({ player, excerpt, onDelete }) => (
    <tr>
        
        <td>{player.id}</td>
        <td>{player.nombre}</td>
        <td>@mdo</td>
        <td>Otto</td>
        <td>@mdo</td>
        <td>@mdo</td>
    </tr>
)

export const PlayerGame = ({ player, excerpt, onDelete }) => (
    <tr>
        
        <td>{player.id}</td>
        <td>{player.nombre}</td>
        <td><button type="button" className="btn btn-success" onClick={PlayerUpdate} id={player.id}>Update</button></td>
        <td><button type="button" className="btn btn-danger" onClick={PlayerDelete} >Delete</button></td>
    </tr>
)