package IA.back.controlers;

import IA.back.Modelos.Position;
import IA.back.Modelos.Tablero;
import IA.back.pojo.CuadriculaPOJO;
import IA.back.pojo.PositionPOJO;
import IA.back.pojo.chagePosPOJO;
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
        Position pos = new Position(cuadriculaPOJO.getPosition().getRow(), cuadriculaPOJO.getPosition().getCol());
        Tablero tablero = new Tablero(cuadriculaPOJO.getTablero(), pos);
        Tablero newTablero = this.gameService.updateTablero(tablero);
        return new ResponseEntity( new chagePosPOJO(newTablero.getTablero(), new PositionPOJO(newTablero.getChangePos())), HttpStatus.CREATED );
    }
    @PostMapping( value = { "/isWining" } )
    public ResponseEntity isWinning(@RequestBody CuadriculaPOJO cuadriculaPOJO ) {
        Position pos = new Position(cuadriculaPOJO.getPosition().getRow(), cuadriculaPOJO.getPosition().getCol());
        Tablero tablero = new Tablero(cuadriculaPOJO.getTablero(), pos);
        Boolean win = this.gameService.isWinig(tablero, cuadriculaPOJO.getType());
        return new ResponseEntity( win, HttpStatus.CREATED );
    }


}
