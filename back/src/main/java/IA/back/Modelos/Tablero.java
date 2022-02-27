package IA.back.Modelos;

import java.util.ArrayList;

public class Tablero {
    private ArrayList<ArrayList<String>> tablero;
    private ArrayList<Position> posibles;
    private Position changePos;
    private int heuristic;

    public Tablero(ArrayList<ArrayList<String>> tablero, Position pos) {
        this.tablero = tablero;
        this.changePos = pos;
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
    public boolean isWining(String type){
        if (this.isWiningHorizontal(this.changePos, type)) return true;
        else if (this.isWiningVertical(this.changePos, type)) return true;
        else if (this.isWiningDiagonalIzq(this.changePos, type)) return true;
        else if (this.isWiningDiagonalDer(this.changePos, type)) return true;
        else return false;
    }

    private boolean isWiningHorizontal (Position pos, String type) {
        boolean win = false;
        int aux = 0;
        //Horizontal
        int i = Math.max(0, pos.getCol()-4);
        while(i< 9){
            if(this.tablero.get(pos.getRow()).get(i++).equals(type)) {
                win=true;
                aux++;
                if(aux==5) break;
            }
            else{
                if(win) {
                    win = false;
                    break;
                };
            }
        }
        return (win && aux==5);
    }
    private boolean isWiningVertical (Position pos, String type) {
        boolean win = false;
        int aux = 0;
        //Horizontal
        int i = Math.max(0, pos.getRow()-4);
        while(i < 9){
            if(this.tablero.get(i++).get(pos.getCol()).equals(type)) {
                win=true;
                aux++;
                if(aux==5) break;
            }
            else{
                if(win) {
                    win = false;
                    break;
                };
            }
        }
        return (win && aux==5);
    }

    private boolean isWiningDiagonalIzq (Position pos, String type) {
        boolean win = false;
        int aux = 0;
        int row=0;
        int col = 0;
        //Horizontal
        int max = Math.max(pos.getCol(), pos.getRow());
        if (max == pos.getRow()){
            row = Math.max(0,pos.getRow()-pos.getCol());
            col =  Math.max(0,pos.getCol()-4);
        }else{
            row = Math.max(0,pos.getRow()-4);
            col =  Math.max(0,pos.getCol()-pos.getRow());
        }
        while(row< 9 && col < 9 ){
            if(this.tablero.get(row++).get(col++).equals(type)) {
                win=true;
                aux++;
                if(aux==5) break;
            }
            else{
                if(win) {
                    win = false;
                    break;
                };
            }
        }
        return (win && aux==5);
    }
    private boolean isWiningDiagonalDer (Position pos, String type) {
        boolean win = false;
        int aux = 0;
        //Horizontal
        int max = Math.max(pos.getCol(), pos.getRow());
        int row = 0;
        int col = 0;
        if (max == col){
            col = Math.min(8, col+4);
            row =+ (col - max);
        }else{
            row = Math.max(0, pos.getRow()-4);
            col = Math.min(pos.getCol() + 4 , 8);

        }
        while(row < 9 && col >=0 ){
            if(this.tablero.get(row++).get(col--).equals(type) ) {
                win=true;
                aux++;
                if(aux==5) break;
            }
            else{
                if(win) {
                    win = false;
                    break;
                };
            }
        }
        return (win && aux==5);
    }

}
