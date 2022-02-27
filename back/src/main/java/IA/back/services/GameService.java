package IA.back.services;


import IA.back.Modelos.Position;
import IA.back.Modelos.Tablero;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class GameService {

    public Tablero updateTablero(Tablero tablero){
        Random rand = new Random();
        int pos = rand.nextInt(tablero.getPosibles().size());
        Position newPos = tablero.getPosibles().get(pos);
        tablero.setTablero(newPos,"W");
        return tablero;
    }

}
