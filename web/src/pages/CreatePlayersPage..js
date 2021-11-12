import React, { useEffect ,useState} from "react";
import { connect } from 'react-redux'
import { fetchHorses, postPlayer ,fetchPlayers} from "../actions/gameActions";
import { PlayerGame } from "../components/Player";
import { useHistory } from "react-router-dom";
const CreatePlayersPage = ({ dispatch, loading,hasErrors, redirect,players}) => {
    

    /*
    useEffect(() => {
        dispatch(fetchHorses())
    }, [dispatch])

    const renderHorses = () => {
        if (loading) return <p>Loading horse...</p>
        if (hasErrors) return <p>Unable to display horses.</p>

        //return questions.map(question => <Question key={question.id} question={question} excerpt />)
        console.log(horses)
        return horses.map(horse => <option value={horse.name}>{horse.name}</option>)

    }
    */
   
    const [formState, setformState] = useState({
        //horse:'',
        namePlayer:''
    })
    const onSubmit = e => {
        e.preventDefault();
        const player={
            "name":formState.namePlayer
        }
        //const data = {...formState,
        //}
        //console.log(data)
        console.log(player)

        //validateInput(data) && dispatch(postQuestion(data));
        dispatch(postPlayer(player));
    }

    const handleInputChange = ({target}) => {
        console.log(target);
        setformState({...formState,
            [target.name]:target.value
            
        });
    }
    const history = useHistory();
    useEffect(() => {
        if (redirect) {
            history.push(redirect);
        }
    }, [redirect, history])
    const [namePlayer, setNamePlayer] = useState('');
    return(
        <section>
            <h1>Crear jugadores</h1>

            <form onSubmit={onSubmit}>

                <div>
                    <label for="nameplayer" className="form-label">Nombre de jugador</label>
                    <input id="nameplayer" name="namePlayer" className="form-control" onChange={handleInputChange} placeholder="Escriba el nombre del jugador"/>
                </div>

                
                {/*<div>
                    <label for="horse" className="form-label">Caballos Disponibles</label>
                    <select name="horse" onChange={handleInputChange} id="horse" className="form-select">
                    <option selected>Selecciona tu caballo</option>
                        {renderHorses()}
                    </select>
                </div>*/}
                

                <button type="submit" className="btn btn-success">
                    Guardar
                </button>
            </form>

        </section>

    );
    
}

const mapStateToProps = state => ({
    loading: state.game.loading,
    redirect: state.game.redirect,
    hasErrors: state.game.hasErrors,
    players:state.game.players
})

export default connect(mapStateToProps)(CreatePlayersPage);
