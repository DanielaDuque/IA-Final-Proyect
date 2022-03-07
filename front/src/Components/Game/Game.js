import "./Game.css"
import GameControler from "../../controlers/GameControler";
import Ficha from "./ficha";
import { Component } from "react";
import { Link } from "react-router-dom";

class Game extends Component{
    constructor(props){
        super(props)
        this.controlers = new GameControler();
        this.state = {
            src : this.controlers.game,
            win : this.controlers.win
        }
        this.makeMove = this.makeMove.bind(this);
    }
    async makeMove(row, col ){
        if(this.controlers.game[row][col] === "C") {
            await this.controlers.makeMove(row, col);
            this.setState({
                win: this.controlers.win
            });
            await this.controlers.makeMoveBack("W",row,col);
            this.setState({
                src: this.controlers.game,
                win: this.controlers.win
            });
            console.log(this.state.win)
        }
     }
      
    columns(idx){
        let table = [];
        for (let index = 0; index < 9; index++) {
            let val = idx*9 + index;
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
        for (let index = 0; index < 9; index++) {
            table.push(
                <div className="row row-cols-9" >
                    {this.columns(index)}
                </div>  
            )
        }
        return table;
    }

    show(){
        if(this.state === "C") return "window-close";
        else return "";
    }
    render(){
        return(
        <div>
            <h1> Game </h1>
            <section className = "container">
                {this.rows()}
            </section>

            <section className={
                            this.state.win === "C" ? 'window-close ' : ''
                        }>
                <div class="window-notice" id="window-notice">
                    <div class="content">
                        <div class="content-text">
                            This game is over. The winner is : {this.state.win==="W" ? "White" : "Black"}
                        </div>
                        <div class="content-buttons">
                            <div className = "btn-group" role="group">
                                <button type="button" className = "btn btn-outline-danger"> 
                                    <Link to ="/">
                                        Back to menu
                                    </Link> 
                                </button>
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