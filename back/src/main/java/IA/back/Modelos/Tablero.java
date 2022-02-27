package IA.back.Modelos;

import java.util.ArrayList;

public class Tablero {
    private ArrayList<ArrayList<String>> tablero;
    private ArrayList<Position> posibles;
    private int heuristic;

    public Tablero(ArrayList<ArrayList<String>> tablero) {
        this.tablero = tablero;
        this.posibles = new ArrayList<>();
        for (int i = 0; i < tablero.size(); i++) {
            for (int j = 0; j < tablero.get(i).size(); j++) {
                if(this.tablero.get(i).get(j).equals("C") ) this.posibles.add(new Position(i,j));
            }
        }
    }



    // Clone Methods
    public ArrayList<ArrayList<String>> cloneTablero(){
        ArrayList<ArrayList<String>> newTablero = new ArrayList<>();
        for (ArrayList<String> arr: this.tablero ) {
            newTablero.add((ArrayList<String>) arr.clone());
        }
        return newTablero;
    }


    // Getter and Setter
    public ArrayList<ArrayList<String>> getTablero() {
        return tablero;
    }

    public ArrayList<Position> getPosibles() {
        return posibles;
    }

    public String getPosition(Position pos){
        return this.tablero.get(pos.getRow()).get(pos.getCol());
    }

    public void setTablero( Position pos,  String newStatus) {
        this.tablero.get(pos.getRow()).set(pos.getCol(), newStatus);

    }
}
