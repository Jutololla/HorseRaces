import React, { useEffect } from 'react'
import { connect } from 'react-redux'

//import { fetchQuestions } from '../actions/questionActions'
import { Player } from '../components/Player'

const QuestionsPage = ({ dispatch, loading, hasErrors }) => {
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
        }
    ]
    const renderQuestions = () => {
        if (loading) return <p>Loading player...</p>
        if (hasErrors) return <p>Unable to display player.</p>

        //return questions.map(question => <Question key={question.id} question={question} excerpt />)
        return player.map(player => <Player player={player}/>)
    }

    return (
        <section>
            <h1>The Best Players</h1>
            <table className="table table-striped">
            <thead>
                <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">First Place</th>
                <th scope="col">Second Place</th>
                <th scope="col">three Place</th>
                <th scope="col">Total</th>
                </tr>
            </thead>
    <tbody>
    {renderQuestions()}
    </tbody>
    </table>
            
        </section>
    )
}

const mapStateToProps = state => ({
    loading: state.question.loading,
    questions: state.question.questions,
    hasErrors: state.question.hasErrors,
})

export default QuestionsPage