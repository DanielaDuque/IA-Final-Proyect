import "./Game.css"
import GameControler from "../../controlers/GameControler";
import Ficha from "./ficha";
import { Component } from "react";
import { Link } from "react-router-dom";

class Game extends Component{
    constructor(props){
        super(props)
        this.size = props.variable
        this.controlers = new GameControler(this.size);
        this.state = {
            src : this.controlers.game,
            win : this.controlers.win,
            play : true
        }
        this.makeMove = this.makeMove.bind(this);
        this.columns = this.columns.bind(this);
        this.rows = this.rows.bind(this);
    }
    async makeMove(row, col ){
        if(this.controlers.game[row][col] === this.controlers.empty && this.state.play) {
            this.setState({
                play: false
            });
            await this.controlers.isWining(2,row,col)
            await this.controlers.makeMove(row, col).then(
                ()=>{
                    this.setState({
                        win: this.controlers.win
                    });
                    this.controlers.makeMoveBack(this.controlers.white,row,col).then(
                        ()=>{
                            this.setState({
                                src: this.controlers.game,
                                win: this.controlers.win,
                                play: true
                            });
                            console.log(this.state.win)
                        }
                    )
                }
            );
        }
     }


      
    columns(idx){
        let table = [];
        for (let index = 0; index < this.size; index++) {
            let val = idx*(this.size) + index;
            table.push(
                <div className="col-auto col-size fondo" key = {val} id={val} >
                    <Ficha
                        row = {idx}
                        col = {index}
                        img = {this.state.src[idx][index]}
                        makeMove = {this.makeMove}
                    />
                </div>   
            )
        }
        return table;
    }
    rows (){
        let table = [];
        for (let index = 0; index < this.size; index++) {
            table.push(
                <div className="row justify-content-center" >
                    {this.columns(index)}
                </div>  
            )
        }
        return table;
    }

    render(){
        return(
        <div>
            <h1 className = "title-section">  Game mode {this.size} x {this.size} </h1>
            <section className = "container sectionGame">
                {this.rows()}
                
            </section>

            <section className={
                            this.state.win === this.controlers.empty ? 'window-close ' : ''
                        }>
                <div class="window-notice" id="window-notice">
                    <div class="content">
                        <div class="content-text">
                            This game is over. The winner is : {this.state.win===1 ? "White" : "Black"}
                        </div>
                        <div class="content-buttons">
                            <div className = "btn-group" role="group">
                                <Link to ="/">
                                    <button type="button" className = "btn btn-outline-danger"> 
                                            Back to menu
                                    </button>
                                </Link> 
                                <button type="button"className = "btn btn-outline-success"
                                        onClick={()=> { window.location.reload()}}> 
                                        Re-play                                    
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    );
    }
}

export default Game;