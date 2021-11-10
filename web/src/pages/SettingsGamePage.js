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
        <h1>Setting Game</h1>

        <form onSubmit={onSubmit}>

            <div >
                <label for="track" className="form-label">Track size</label>
                <input id="track" name="track" type="number" placeholder="track in KM" className="form-control" onChange={handleInputChange} />
                
            </div>

            <div >
                <label for="players" className="form-label">Number of players</label>
                <input id="players" name="players" type="number" min="3" max="10" className="form-control" onChange={handleInputChange} />
                
            </div>

            <div>
                    <label for="autoplay" className="form-label">Autoplay</label>
                    <select name="autoplay" onChange={handleInputChange} id="autoplay" className="form-select">
                        <option value={true}>SI</option>
                        <option value={false}>NO</option>
                    </select>
                </div>
            
            
            <button type="submit" className="btn btn-success">
                Save
            </button>
        </form>
    </section>)
}
export default SettingGamePage;