import React from 'react'
import { Link } from 'react-router-dom'

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