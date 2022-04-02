import cruz from '../../images/plus.png'
import black from '../../images/black.png'
import white from '../../images/white.png'

function Ficha(props){
    let getSrc = () =>{
        switch(props.img) {
            case 2:
                return black;
            case 1:
                return white;
            default:
                return cruz;
        }
    }
    return(
        <img src={getSrc()} onClick ={() => props.makeMove(props.row, props.col)}/>
    )
}export default Ficha;
