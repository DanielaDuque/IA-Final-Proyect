package IA.back.pojo;

import IA.back.Modelos.Position;

import java.util.Objects;

public class PositionPOJO {
    private int row;
    private int col;

    public PositionPOJO(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public PositionPOJO(Position pos) {
        this.row = pos.getRow();
        this.col = pos.getCol();
    }
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionPOJO position = (PositionPOJO) o;
        return row == position.row && col == position.col;
    }
    public PositionPOJO clone (){
        return new PositionPOJO(this.getRow(), this.getCol());
    }
    @Override
    public String toString() {
        return "Position{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
