package IA.back.Modelos;

import IA.back.IAModel.CenterMass;

import java.util.ArrayList;

public class Tablero {
    private ArrayList<ArrayList<Byte>> tablero;
    private Position changePos;
    private byte empty;
    private Position centreMass;

    public Tablero(ArrayList<ArrayList<Byte>> tablero, Position pos) {
        this.tablero = tablero;
        this.changePos = pos;
        this.empty = 0;
    }
    // Getter and Setter
    public ArrayList<ArrayList<Byte>> getTablero() {
        return tablero;
    }

    public ArrayList<Position> getPosibles() {
        this.centreMass = new CenterMass().CenterMassF(this.tablero);
        ArrayList<Position> posibles = new ArrayList<>();
        for (int i = 0; i < tablero.size(); i++) {
            for (int j = 0; j < tablero.get(i).size(); j++) {
                if(this.tablero.get(i).get(j) == 0 ) posibles.add(new Position(i,j, distanceCentreMass(i,j)));
            }
        }
        return posibles;
    }
    private float distanceCentreMass(int row, int col) {
        return (float) Math.sqrt( Math.pow( this.centreMass.getCol() - col, 2) + Math.pow(this.centreMass.getRow() - row,2)  );
    }

    public void setChangePos(Position changePos) {
        this.changePos = changePos;
    }

    public Position getChangePos() {
        return changePos;
    }

    public Byte getPosition(Position pos){
        return this.tablero.get(pos.getRow()).get(pos.getCol()
        );
    }

    public void setTablero(Position pos, byte newStatus) {
        this.changePos = pos;
        this.tablero.get(pos.getRow()).set(pos.getCol(), newStatus);
    }
    public void unSetTablero( Position pos) {
        this.tablero.get(pos.getRow()).set(pos.getCol(), (byte)0);
    }
    public boolean isWining(byte type){
        if (this.isWiningHorizontal(this.changePos, type)) return true;
        else if (this.isWiningVertical(this.changePos, type)) return true;
        else if (this.isWiningDiagonalIzq(this.changePos, type)) return true;
        else if (this.isWiningDiagonalDer(this.changePos, type)) return true;
        else return false;
    }

    private boolean isWiningHorizontal (Position pos, byte type) {
//        System.out.println("----- " + pos);
        boolean win = false;
        int aux = 0;
        //Horizontal
        for (int i = Math.max(0, pos.getCol()-4); i < this.tablero.size() ; i++)
        {
            if(this.tablero.get(pos.getRow()).get(i) == type) {
                win = true;
                aux++;
                if(aux==5) break;
            }
            else{
                if(win) {
                    win = false;
                    break;
                }
            }
        }
        return (win && aux==5);
    }
    private boolean isWiningVertical (Position pos, byte type) {
        boolean win = false;
        int aux = 0;
        //Horizontal
        int i = Math.max(0, pos.getRow()-4);
        while(i < 19){
            if(this.tablero.get(i++).get(pos.getCol()) == type) {
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

    private boolean isWiningDiagonalIzq (Position pos, byte type) {
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
        while(row< 19 && col < 19 ){
            if(this.tablero.get(row++).get(col++) == type) {
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
    private boolean isWiningDiagonalDer (Position pos, byte type) {
        boolean win = false;
        int aux = 0;
        //Horizontal
        int max = Math.max(pos.getCol(), pos.getRow());
        int row = 0;
        int col = 0;
        if (max == col){
            col = Math.min(18, col+4);
            row =+ (col - max);
        }else{
            row = Math.max(0, pos.getRow()-4);
            col = Math.min(pos.getCol() + 4 , 18);

        }
        while(row < 19 && col >=0 ){
            if(this.tablero.get(row++).get(col--) == type ) {
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
