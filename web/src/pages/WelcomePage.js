import gif from '../saludo.gif'
import { Link } from 'react-router-dom'
import { connect } from 'react-redux'
import { postGame } from '../actions/gameActions'
import { useHistory } from "react-router-dom";
import { useEffect } from 'react';
const WelcomePage=({ dispatch, loading, redirect, idgame})=>{
    const onSubmit = e => {
        e.preventDefault();
        const data={}
        dispatch(postGame(data))
        
    }
    const history = useHistory();
    useEffect(() => {
        if (redirect) {
            history.push(redirect);
        }
    }, [redirect, history])
    return(
        <section>
            <form onSubmit={onSubmit}>
            <img src={gif} alt="gif" className="imageninicio"/>
            <div >
            <center>
            <button type="submit" className="btn btn-success">
                    Continuar
            </button>
            </center>
            </div>
            </form>
        </section>
    )


}
const mapStateToProps = state => ({
    loading: state.game.loading,
    redirect: state.game.redirect,
    hasErrors: state.game.hasErrors,
    idgame:state.game.idgame
})
export default connect(mapStateToProps)(WelcomePage);
