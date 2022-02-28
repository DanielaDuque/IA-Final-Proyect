
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Menu from './Components/Menu/Menu';
import Game from './Components/Game/Game';


function App() {
  return (
    <BrowserRouter>
      <Routes>
          <Route exact path="/" element={<Menu />} />
          <Route path="/play" element={<Game />} />  
      </Routes>
    </BrowserRouter>
  )
}

export default App;
