package IA.back.IAModel;

import IA.back.Modelos.Position;

public class retourMinMax {
    private int value;
    private Position pos;

    public retourMinMax(int value, Position pos) {
        this.value = value;
        this.pos = pos;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        return "retourMinMax{" +
                "value=" + value +
                ", pos=" + pos +
                '}';
    }
}
