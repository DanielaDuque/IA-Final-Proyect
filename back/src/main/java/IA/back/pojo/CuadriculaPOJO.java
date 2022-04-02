package IA.back.pojo;

import java.util.ArrayList;

public class CuadriculaPOJO {
    private ArrayList<ArrayList<Byte>> tablero;
    private PositionPOJO position;
    private Byte type;

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public ArrayList<ArrayList<Byte>> getTablero() {
        return tablero;
    }

    public void setTablero(ArrayList<ArrayList<Byte>> tablero) {
        this.tablero = tablero;
    }

    public PositionPOJO getPosition() {
        return position;
    }

    public void setPosition(PositionPOJO position) {
        this.position = position;
    }
}
