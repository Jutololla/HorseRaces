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
        
        <td>{player.playerId}</td>
        <td>{player.name}</td>
        <td>{player.firstPlacePodiumId.length}</td>
        <td>{player.secondPlacePodiumId.length}</td>
        <td>{player.thirdPlacePodiumId.length}</td>
        <td>{player.firstPlacePodiumId.length+player.secondPlacePodiumId+player.thirdPlacePodiumId.length}</td>
    </tr>
)

export const PlayerGame = ({ player, excerpt, onDelete }) => (
    <tr>
        
        <td>{player.playerId}</td>
        <td>{player.name}</td>
        <td><button type="button" className="btn btn-success" onClick={PlayerUpdate} id={player.id}>Update</button></td>
        <td><button type="button" className="btn btn-danger" onClick={PlayerDelete} >Delete</button></td>
        
    </tr>
)