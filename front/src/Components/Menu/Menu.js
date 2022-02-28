import './Menu.css'
import { Link } from "react-router-dom";

function Menu(){
    return (
        <div className="App">
          <header className="App-header">
            <h1>Final project</h1>
            <p> By:</p>
            <p>Daniela DUQUE</p>
            <p>Cristian MARTINEZ</p>
          </header>

          <section  className = "App-section"  >
                <div className = "btn-group" role="group">
                    <button type="button" className = "btn btn-outline-danger"> Train</button>
                    <button type="button"className = "btn btn-outline-success"> 
                      <Link to ="/play">
                        Play
                      </Link> 
                    </button>
                </div>
          </section>
        </div>
      );

}export default Menu;