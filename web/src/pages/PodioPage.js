import l1 from '../medalla-de-oro.png'
import l2 from '../medalla-de-plata.png'
import l3 from '../medalla-de-bronce.png'
const PodioPage=()=>{
    return(
        <section>
        <h1>Podio</h1>
            <label htmlFor="">primer</label>
            <img src={l1} alt="m1" />
            <label htmlFor="">segundo</label>
            <img src={l2}alt="" />
            <label htmlFor="">tercer</label>
            <img src={l3} alt="" />
        </section>
    )
}
export default PodioPage