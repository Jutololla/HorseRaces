import React, { useEffect } from 'react'
import { connect } from 'react-redux'
import { Link } from 'react-router-dom'

//import { fetchQuestions } from '../actions/questionActions'
import { Player ,PlayerGame } from '../components/Player'

const StartGamePage = ({ dispatch, loading, hasErrors }) => {
    useEffect(() => {
        //dispatch(fetchQuestions())
    }, [dispatch])
    
    let player=[
        {
            id:1,
            nombre:"yhomi"
        },
        {
            id:2,
            nombre:"alexandra"
        },
        {
            id:51,
            nombre:"alexandra"
        }
    ]
    const renderQuestions = () => {
        if (loading) return <p>Loading player...</p>
        if (hasErrors) return <p>Unable to display player.</p>

        //return questions.map(question => <Question key={question.id} question={question} excerpt />)
        return player.map(player => <PlayerGame player={player} />)
    }

    return (
        <section>
            <h1>The Players in Game</h1>
            <table className="table table-striped">
            <thead>
                <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Update Name</th>
                <th scope="col">Delete Player</th>
                </tr>
            </thead>
            <tbody>
            {renderQuestions()}
            </tbody>
            </table>

            <div>
            <Link to="/crearjugadores" className="button-normal">
            Crear Jugadores
            </Link>
            
            <Link to="/start" className="button-normal">
            Iniciar
            </Link>
            </div>

            
            
        </section>
    )
}

const mapStateToProps = state => ({
    loading: state.question.loading,
    questions: state.question.questions,
    hasErrors: state.question.hasErrors,
})

export default StartGamePage