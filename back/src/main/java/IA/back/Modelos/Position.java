package IA.back.Modelos;

import java.util.Objects;

public class Position implements Comparable<Position>{
    private int row;
    private int col;
    private float distance ;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
        this.distance = 0;
    }

    public Position(int row, int col, float distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
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
        Position position = (Position) o;
        return row == position.row && col == position.col;
    }
    public Position clone (){
        return new Position(this.getRow(), this.getCol());
    }
    @Override
    public String toString() {
        return "Position{" +
                "row=" + row +
                ", col=" + col +
                ", distance=" + distance +
                '}';
    }
    @Override
    public int compareTo(Position o){
        if (this.distance > o.distance) {
            // if current object is greater,then return 1
            return 1;
        }
        else if (this.distance < o.distance) {
            // if current object is greater,then return -1
            return -1;
        }
        else {
            // if current object is equal to o,then return 0
            return 0;
        }
    };

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
