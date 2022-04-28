import './Menu.css'
import { Link } from "react-router-dom";
import Size9 from '../../images/9.png';
import Size11 from '../../images/11.png';
import Size15 from '../../images/15.png';
import Size19 from '../../images/19.png';

function Menu(){
    return (
        <div className="App">
          <section  className = "App-section"  >

            <h2 className='title-section'>Select your game mode</h2>
            
            <div className='container align-middle'>
              <div className='row'>
                <div className = 'col-6 col-md-3'>
                <figure class="figure">
                  <Link to ="/play/9">
                    <img src={Size9} class="figure-img img-fluid rounded img-thumbnail " alt="Game mode 9 x 9"/>
                  </Link> 
                </figure>
                </div>
                <div className = 'col-6 col-md-3'>
                <figure class="figure">
                  <Link to ="/play/11">
                    <img src={Size11} class="figure-img img-fluid rounded img-thumbnail " alt="Game mode 11 x 11"/>
                  </Link> 
                </figure>
                </div>
                <div className = 'col-6 col-md-3'>
                <figure class="figure">
                  <Link to ="/play/15">
                    <img src={Size15} class="figure-img img-fluid rounded img-thumbnail " alt="Game mode 15 x 15"/>
                  </Link> 
                </figure>
                </div>
                <div className = 'col-6 col-md-3'>
                <figure class="figure">
                  <Link to ="/play/19">
                    <img src={Size19} class="figure-img img-fluid rounded img-thumbnail " alt="Game mode 19 x 19"/>
                  </Link> 
                </figure>
                </div>
              </div>
            </div>
          </section>
        </div>
      );

}export default Menu;