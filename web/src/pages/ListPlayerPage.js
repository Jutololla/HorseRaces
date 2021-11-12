import React, { useEffect ,useState} from "react";
import { connect } from 'react-redux'
import { fetchHorses, postPlayer ,fetchPlayers} from "../actions/gameActions";
import { PlayerGame } from "../components/Player";
const ListPlayersPage = ({ dispatch, loading,hasErrors, redirect,players}) => {

    useEffect(() => {
        dispatch(fetchPlayers())
    }, [dispatch])
    
    const renderPlayers = () => {
        if (loading) return <p>Loading player...</p>
        if (hasErrors) return <p>Unable to display player.</p>

        //return questions.map(question => <Question key={question.id} question={question} excerpt />)
        console.log(players)
        return players.map(player => <PlayerGame player={player}/>)

    }
    const [namePlayer, setNamePlayer] = useState('');
    return(
        <section>
            <h1>Crear jugadores</h1>
            <table className="table table-striped">
            <thead>
                <tr>
                <th scope="col">#</th>
                <th scope="col">Nombre</th>
                <th scope="col">Update Name</th>
                <th scope="col">Delete Player</th>
                </tr>
            </thead>
            <tbody>
                {renderPlayers()}
            </tbody>
            </table>
        </section>

    );
    
}

const mapStateToProps = state => ({
    loading: state.game.loading,
    redirect: state.game.redirect,
    hasErrors: state.game.hasErrors,
    players:state.game.players
})

export default connect(mapStateToProps)(ListPlayersPage);
