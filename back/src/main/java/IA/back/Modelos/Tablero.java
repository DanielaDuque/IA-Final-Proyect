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
        return changePos.clone();
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
        if(this.changePos == null) return false;
        else if (this.isWiningHorizontal(this.changePos, type)) return true;
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
        for (int i = Math.max(0, pos.getCol() - this.NbWinPiece); i <Math.min(this.size, pos.getCol() + this.NbWinPiece) ; i++)
        {
            if(i == pos.getCol()) continue;
            if(this.tablero.get(pos.getRow()).get(i) == type) {
                win = true;
                aux++;
                if(aux >=this.NbWinPiece - 1) break;
            }
            else{
                if(win) {
                    win = false;
                    break;
                }
            }
        }
        return (win && aux>=this.NbWinPiece - 1 );
    }
    private boolean isWiningVertical (Position pos, byte type) {
        boolean win = false;
        int aux = 0;
        //Horizontal
        for (int i = Math.max(0, pos.getRow() - this.NbWinPiece); i <Math.min(this.size, pos.getRow() + this.NbWinPiece) ; i++) {
            if(i == pos.getRow()) continue;
            if(this.tablero.get(i).get(pos.getCol()) == type) {
                win=true;
                aux++;
                if(aux>=this.NbWinPiece - 1) break;
            }
            else{
                if(win) {
                    win = false;
                    break;
                };
            }
        }
        return (win && aux>=this.NbWinPiece - 1);
    }

    private boolean isWiningDiagonalIzq (Position pos, byte type) {
        boolean win = false;
        int aux = 0;
        int row = pos.getRow();
        int col = pos.getCol();
        int cont = 0;
        while(col > 0 && row > 0 && cont < this.NbWinPiece - 1){
            col--;
            row--;
            cont++;
        }
        while(row < Math.min(this.size, pos.getRow() + this.NbWinPiece) && col < Math.min(this.size, pos.getCol() + this.NbWinPiece) ){
            if(row == pos.getRow() && col == pos.getCol()) {
                row++;
                col++;
                continue;
            }
            if(this.tablero.get(row++).get(col++) == type) {
                win=true;
                aux++;
                if(aux>=this.NbWinPiece-1) break;
            }
            else{
                if(win) {
                    win = false;
                    break;
                };
            }
        }
        return (win && aux>=this.NbWinPiece - 1);
    }
    private boolean isWiningDiagonalDer (Position pos, byte type) {
        boolean win = false;
        int aux = 0;
        //Horizontal
        int row = pos.getRow();
        int col = pos.getCol();
        int cont = 0;
        while(col < this.size - 1  && row > 0 && cont < this.NbWinPiece -1){
            col++;
            row--;
            cont++;
        }

        while(row < Math.min(this.size, pos.getRow() + this.NbWinPiece) && col >= Math.max(0, pos.getCol() - this.NbWinPiece) ){
            if(row == pos.getRow() && col == pos.getCol()) {
                row++;
                col--;
                continue;
            }
            if(this.tablero.get(row++).get(col--) == type ) {
                win=true;
                aux++;
                if(aux>=this.NbWinPiece-1) break;
            }
            else{
                if(win) {
                    win = false;
                    break;
                };
            }
        }
        return (win && aux>=this.NbWinPiece-1);
    }


}
