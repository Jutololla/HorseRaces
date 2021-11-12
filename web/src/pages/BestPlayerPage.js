import React, { useEffect } from 'react'
import { connect } from 'react-redux'
import { fetchPlayers } from '../actions/gameActions'

//import { fetchQuestions } from '../actions/questionActions'
import { Player } from '../components/Player'

const BestPlayerPage = ({ dispatch, loading, hasErrors,players}) => {
    useEffect(() => {
        dispatch(fetchPlayers())
    }, [dispatch])
    
    const renderPlayers = () => {
        if (loading) return <p>Loading player...</p>
        if (hasErrors) return <p>Unable to display player.</p>

        //return questions.map(question => <Question key={question.id} question={question} excerpt />)
        console.log(players)
        return players.map(player => <Player player={player}/>)

    }

    return (
        <section>
            <h1>Lista de mejores jugadores</h1>
            <table className="table table-striped">
            <thead>
                <tr>
                <th scope="col">#</th>
                <th scope="col">Primer Puesto</th>
                <th scope="col">Segundo Puesto</th>
                <th scope="col">Tercer Puesto</th>
                <th scope="col">Total</th>
                <th scope="col">Total</th>
                </tr>
            </thead>
    <tbody>
    {renderPlayers()}
    </tbody>
    </table>
            
        </section>
    )
}

const mapStateToProps = state => ({
    loading: state.game.loading,
    hasErrors: state.game.hasErrors,
    players: state.game.players,

})

export default connect(mapStateToProps)(BestPlayerPage)