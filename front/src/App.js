
import {Link, Outlet} from "react-router-dom";

import logoInsa from "./images/Insalogo.png";



function App() {
  return (
    <div>
    <header className="App-header App">
    <div className='container'>
      <div className='row'>
        <div className='col-12 col-md-6'>
          <img className ='img' src={logoInsa}></img>
        </div>
        <div className='col-12 col-md-6 App-header'>
          <h1 className='title'>Gomoku</h1>
          <h2 className='subtitle'> Final Project Intelligence Artificial pour les Jeu</h2>
          <h3 className='subsubtitle'> Insa Rennes - 4 Info</h3>
          <h3 clasName = 'subsubtitle'>
            By:
          </h3>
          <h4 className = 'subsubtitle'>
            Daniela DUQUE
            Cristian MARTINEZ
          </h4>
          <Link to ='/'>
            <button type="button" className ="btn btn-outline-dark">
                Volver al Menu
            </button>
          </Link>
        </div>
      </div>
    </div>
  </header>
  <Outlet/>
  </div>
  )
}

export default App;
