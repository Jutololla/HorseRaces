import React, { useEffect ,useState} from "react";
const CreatePlayersPage = () => {


    const [formState, setformState] = useState({
        horse:'CABALLO 1',
        nameplayer:''
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

    const [namePlayer, setNamePlayer] = useState('');
    return(
        <section>
            <h1>Crear jugadores</h1>

            <form onSubmit={onSubmit}>

                <div>
                    <label for="nameplayer" className="form-label">Nombre de jugador</label>
                    <input id="nameplayer" name="namePlayer" className="form-control" onChange={handleInputChange} placeholder="Escriba el nombre del jugador"/>
                </div>

                <div>
                    <label for="horse" className="form-label">Caballos Disponibles</label>
                    <select name="horse" onChange={handleInputChange} id="horse" className="form-select">
                        <option value="CABALLO 1">CABALLO 1</option>
                        <option value="CABALLO 2 ">CABALLO 2</option>
                        <option value="CABALLO 3">CABALLO 3</option>
                        <option value="CABALLO 4">CABALLO 4</option>
                    </select>
                </div>
                

                <button type="submit" className="btn btn-success">
                    Guardar
                </button>
            </form>
        </section>

    );
}
export default CreatePlayersPage;
