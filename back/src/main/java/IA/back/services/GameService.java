package IA.back.services;


import IA.back.IAModel.MinMax;
import IA.back.Modelos.Tablero;
import org.springframework.stereotype.Service;


@Service
public class GameService {

    public Tablero updateTablero(Tablero tablero){
//        Random rand = new Random();
//        int pos = rand.nextInt(tablero.getPosibles().size());
//        Position newPos = tablero.getPosibles().get(pos);
//        tablero.setTablero(newPos,"W");
//        return tablero;
        MinMax minMax = new MinMax(tablero);
        return minMax.getNextMove();
    }

    public boolean isWinig (Tablero tablero, Byte type){
        return tablero.isWining(type);
    }
}
