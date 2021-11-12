import React, { useEffect ,useState} from "react";
const SettingGamePage = () => {
    const [formState, setformState] = useState({
        track:'1',
        player:'3',
        autoplay:true
    })
    const onSubmit = e => {
        e.preventDefault();
        const data = {...formState,
            
            
        }
        console.log(data)
        //validateInput(data) && dispatch(postQuestion(data));
    }

    const handleInputChange = ({target}) => {
        setformState({...formState,
            [target.name]:target.value
        });
    }
    return(<section>
        <h1>Configuracion del Juego</h1>

        <form onSubmit={onSubmit}>

            <div >
                <label for="track" className="form-label">Tamaño de pista</label>
                <input id="track" name="track" type="number" min="1" max="10"  placeholder="Escriba el tamaño de la pista" className="form-control" onChange={handleInputChange} />
                
            </div>

            <div >
                <label for="players" className="form-label">Numero de jugadores</label>
                <input id="players" name="players" type="number" min="3" max="10" className="form-control" onChange={handleInputChange} />
                
            </div>       
            
            <button type="submit" className="btn btn-success">
                Guardar
            </button>
        </form>
    </section>)
}
export default SettingGamePage;