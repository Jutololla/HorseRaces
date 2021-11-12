import React, { useEffect ,useState} from "react";
import { connect } from 'react-redux'
import { useHistory } from "react-router-dom";
import { postGame, postSettingGame,postSettingRace } from "../actions/gameActions";
const SettingGamePage = ({ dispatch, loading, redirect, numberplayer,tracklength,idgame}) => {
    console.log(idgame)
    const [formState, setformState] = useState({
        length:3,
    })
    const onSubmit = e => {
        e.preventDefault();
        const data = {...formState,  
        }
        console.log(data)
        const player={
            "gameId":idgame,
            "length":formState.length*1000
        }
        //validateInput(data) && dispatch(postQuestion(data));
        //dispatch(postGame())
        console.log(player)
        dispatch(postSettingRace(player))
    }

    const handleInputChange = ({target}) => {
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
    return(<section>
        <h1>Configuracion del Juego</h1>

        <form onSubmit={onSubmit}>

            <div >
                <label for="length" className="form-label">Tamaño de pista</label>
                <input id="length" name="length" type="number" min="3" max="10"  placeholder="Escriba el tamaño de la pista" className="form-control" onChange={handleInputChange} required/>
                
            </div>

            <div >
                <label for="players" className="form-label">Numero de jugadores</label>
                <input id="players" name="players" type="number" min="3" max="10" className="form-control" onChange={handleInputChange} required/>
                
            </div>       
            
            <button type="submit" className="btn btn-success">
                Guardar
            </button>
        </form>
    </section>)
}
const mapStateToProps = state => ({
    loading: state.game.loading,
    redirect: state.game.redirect,
    hasErrors: state.game.hasErrors,
    numberplayer:state.game.numberplayer,
    tracklength:state.game.tracklength,
    idgame:state.game.idgame
})
export default connect(mapStateToProps)(SettingGamePage);;