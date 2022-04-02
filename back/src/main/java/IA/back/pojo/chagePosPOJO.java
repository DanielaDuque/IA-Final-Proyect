package IA.back.pojo;

import java.util.ArrayList;

public class chagePosPOJO {
    private ArrayList<ArrayList<Byte>> tablero;
    private PositionPOJO position;

    public chagePosPOJO(ArrayList<ArrayList<Byte>> tablero, PositionPOJO position) {
        this.tablero = tablero;
        this.position = position;
    }

    public ArrayList<ArrayList<Byte>> getTablero() {
        return tablero;
    }

    public PositionPOJO getPosition() {
        return position;
    }
}
