package IA.back.controlers;

import IA.back.Modelos.Position;
import IA.back.Modelos.Tablero;
import IA.back.pojo.CuadriculaPOJO;
import IA.back.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class GameControler {

    private GameService gameService;

    public GameControler(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping( value = { "/changePostions" } )
    public ResponseEntity changePostions(@RequestBody CuadriculaPOJO cuadriculaPOJO ) {
        Tablero tablero = new Tablero(cuadriculaPOJO.getTablero());
        Tablero newTablero = this.gameService.updateTablero(tablero);
        System.out.println("Entre");
        return new ResponseEntity( newTablero.getTablero(), HttpStatus.CREATED );
    }


}
