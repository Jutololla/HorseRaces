import React, { useEffect ,useState} from "react";
const CreatePlayersPage = () => {


    const [formState, setformState] = useState({
        horse:'CABALLO 1'
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
            <h1>New Player</h1>

            <form onSubmit={onSubmit}>

                <div>
                    <label for="nameplayer">Name Player</label>
                    <input id="nameplayer" className="form-control" setContent={setNamePlayer}/>
                </div>

                <div>
                    <label for="type">Caballos Disponibles</label>
                    <select name="type" onChange={handleInputChange} id="type" className="form-select">
                        <option value="CABALLO 1">CABALLO 1</option>
                        <option value="CABALLO 2 ">CABALLO 2</option>
                        <option value="CABALLO 3">CABALLO 3</option>
                        <option value="CABALLO 4">CABALLO 4</option>
                    </select>
                </div>
                

                <button type="submit" className="btn btn-success">
                    Save
                </button>
            </form>
        </section>

    );
}
export default CreatePlayersPage;
