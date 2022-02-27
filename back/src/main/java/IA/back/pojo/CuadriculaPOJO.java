package IA.back.pojo;

import IA.back.Modelos.Position;

import java.util.ArrayList;

public class CuadriculaPOJO {
    private ArrayList<ArrayList<String>> tablero;
    private Position position;

    public ArrayList<ArrayList<String>> getTablero() {
        return tablero;
    }

    public void setTablero(ArrayList<ArrayList<String>> tablero) {
        this.tablero = tablero;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
