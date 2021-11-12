import React, { useEffect ,useState} from "react";

import { connect } from 'react-redux'
import { Link } from 'react-router-dom'
import { fetchHorses, fetchPlayers } from '../actions/gameActions'

//import { fetchQuestions } from '../actions/questionActions'
import { PlayerSelecionado ,PlayerGame } from '../components/Player'

const StartGamePage = ({ dispatch, loading, hasErrors ,players,horses}) => {
    
    const [formState, setformState] = useState({
        horse:'',
        namePlayer:''
    })

    useEffect(() => {
        dispatch(fetchPlayers())
        dispatch(fetchHorses())
    }, [dispatch])
    const handleInputChange = ({target}) => {
        console.log(target);
        setformState({...formState,
            [target.name]:target.value
            
        });
    }
    
    const renderPlayers = () => {
        if (loading) return <p>Loading player...</p>
        if (hasErrors) return <p>Unable to display player.</p>

        //return questions.map(question => <Question key={question.id} question={question} excerpt />)
        return players.map(player => <PlayerSelecionado player={player} renderHorses={renderHorses} handleInputChange={handleInputChange}/>)
    }
    const renderHorses = () => {
        if (loading) return <p>Loading horse...</p>
        if (hasErrors) return <p>Unable to display horses.</p>

        //return questions.map(question => <Question key={question.id} question={question} excerpt />)
        console.log(horses)
        return horses.map(horse => <option value={horse.name}>{horse.name}</option>)

    }

    return (
        <section>
            <h1>Seleccionar Jugadores para el juego</h1>
            <table className="table table-striped">
            <thead>
                <tr>
                <th scope="col">#</th>
                <th scope="col">Nombre</th>
                <th scope="col">Escoge tu caballo</th>
                <th scope="col">Escoge tu participante</th>
                
                </tr>
            </thead>
            <tbody>
            {renderPlayers()}
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
    loading: state.game.loading,
    questions: state.game.questions,
    hasErrors: state.game.hasErrors,
    players:state.game.players,
    horses:state.game.horses
})

export default connect(mapStateToProps)(StartGamePage)