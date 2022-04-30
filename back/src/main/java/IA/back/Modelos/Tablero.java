package IA.back.Modelos;

import IA.back.IAModel.CenterMass;

import java.util.ArrayList;

public class Tablero {
    private ArrayList<ArrayList<Byte>> tablero;
    private Position changePos;
    private int NbWinPiece;
    private int size;
    private byte empty;
    private Position centreMass;

    public Tablero(ArrayList<ArrayList<Byte>> tablero, Position pos) {
        this.tablero = tablero;
        this.changePos = pos;
        this.size = tablero.size();
        this.empty = 0;
        this.NbWinPiece = 5;
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
        for (int i = Math.max(0, pos.getCol()- (this.NbWinPiece-1)); i < this.tablero.size() ; i++)
        {
            if(this.tablero.get(pos.getRow()).get(i) == type) {
                win = true;
                aux++;
                if(aux==this.NbWinPiece) break;
            }
            else{
                if(win) {
                    win = false;
                    break;
                }
            }
        }
        return (win && aux==this.NbWinPiece);
    }
    private boolean isWiningVertical (Position pos, byte type) {
        boolean win = false;
        int aux = 0;
        //Horizontal
        int i = Math.max(0, pos.getRow()-(this.NbWinPiece-1));
        while(i < this.size){
            if(this.tablero.get(i++).get(pos.getCol()) == type) {
                win=true;
                aux++;
                if(aux==this.NbWinPiece) break;
            }
            else{
                if(win) {
                    win = false;
                    break;
                };
            }
        }
        return (win && aux==this.NbWinPiece);
    }

    private boolean isWiningDiagonalIzq (Position pos, byte type) {
        boolean win = false;
        int aux = 0;
        int row = pos.getRow();
        int col = pos.getCol();
        int cont = 0;
        while(col < this.size && row> 0 && cont<this.NbWinPiece){
            col--;
            row--;
            cont++;
        }
        while(row< this.size && col <this.size ){
            if(this.tablero.get(row++).get(col++) == type) {
                win=true;
                aux++;
                if(aux==this.NbWinPiece) break;
            }
            else{
                if(win) {
                    win = false;
                    break;
                };
            }
        }
        return (win && aux==this.NbWinPiece);
    }
    private boolean isWiningDiagonalDer (Position pos, byte type) {
        boolean win = false;
        int aux = 0;
        //Horizontal
        int row = pos.getRow();
        int col = pos.getCol();
        int cont = 0;
        while(col < this.size && row> 0 && cont<this.NbWinPiece){
            col++;
            row--;
            cont++;
        }

        while(row < this.size && col >=0 ){
            if(this.tablero.get(row++).get(col--) == type ) {
                win=true;
                aux++;
                if(aux==this.NbWinPiece) break;
            }
            else{
                if(win) {
                    win = false;
                    break;
                };
            }
        }
        return (win && aux==this.NbWinPiece);
    }


}
