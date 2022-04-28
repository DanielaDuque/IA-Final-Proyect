package IA.back.IAModel;

import IA.back.Modelos.Tablero;

import java.util.ArrayList;

public class FirstHeuristic {
    private Tablero tab;
    private int size;
    private byte type;
    private byte typeAdv;
    private byte empty;


    public FirstHeuristic(Tablero tab) {
        this.tab = tab;
        this.type = (byte) 1;
        this.typeAdv =(byte) 2;
        this.empty = (byte) 0;
        this.size = this.tab.getTablero().size() -1 ;
    }


    public int HeuristicValue(){
//        if(this.tab.isWining(this.typeAdv)) {
//            System.out.println("Gano comtricante");
//            return 4000;
//        }
//        if (this.tab.isWining(this.type)) {
//            System.out.println("Gane yo");
//            return 2000;
//        }
//        else return 0;
        int pointMe = HeuristicValueAux(this.type);
        int pointAdv = HeuristicValueAux(this.typeAdv);
//        System.out.println(pointAdv + pointMe + " pos " + this.tab.getChangePos());
        return pointMe + pointAdv;
    }
    private int HeuristicValueAux (byte type){
        int heuristic = 0;
        ArrayList<Points> verifications = new ArrayList<>();
        verifications.add (this.verificarLineas(this.tab.getChangePos().getCol(), this.tab.getChangePos().getRow(),type));
        verifications.add (this.verificarColumnas(this.tab.getChangePos().getCol(), this.tab.getChangePos().getRow(),type));
        for (Points points: verifications) {
            if( points.getSequencias() >= 4) heuristic +=1000; // primera
            else if (points.getSequencias() == 3 && points.getsome() >= 1) // segunda
                heuristic += 300;
            else if (points.getSequencias() == 2 && points.getsomeLeft() >= 1 && points.getsomeRight() >= 1 ) // tercera
                heuristic += 100;
            else if (points.getSequencias()  + points.getSemiSequencias() == 1 && (points.getsome() > 6) ) // cuarta
            heuristic += 100;
            else if (points.getSequencias() == 2 && (points.getsome() > 1 || points.getSemiSequencias() >= 2) ) // quinta
                heuristic += 25;
            else  if (points.getSequencias() == 2 && (points.getsome() + points.getSemiSequencias()) > 4) // sexta
                heuristic += 20;
            else if (points.getSequencias() == 2 &&  (points.getsome() + points.getSemiSequencias() ) >= 5 ) // septima
                heuristic += 15;
            else  if (points.getSequencias() == 1 && (points.getsome() + points.getSemiSequencias()) > 4) // Octava
                heuristic += 10;
            else if (points.getSequencias() == 1 &&  (points.getsome() + points.getSemiSequencias() ) > 2 ) // novena
                heuristic += 5;


//            heuristic += points.getSequencias() * 20;
//            heuristic += points.getSemiSequencias() * 3;
//            heuristic += points.getsome();
//            System.out.println(points.getSequencias() + " " + points.getSemiSequencias()  + " " + points.getsome() + this.tab.getChangePos());
        }
//        System.out.println("--- " + heuristic );
        return heuristic;
    }
    private Points verificarLineas (int col,  int row , byte type) {
        int leftLimit = Math.max(col-6,0);
        int rightLimit =  Math.min (col+6,this.size);
        int sequencia = 0;
        int semiSequencia = 0;
        int someLeft = 0;
        int someRight = 0;
        for (int i = col - 1; i >= leftLimit; i--) {
            if (! (this.tab.getTablero().get(row).get(i) == this.empty) ) {
                if (this.tab.getTablero().get(row).get(i) == type) {
                    if (someLeft > 0) {
                        semiSequencia++;
                    } else {
                        sequencia++;
                    }
                } else {
                    break;
                }
            } else {
                someLeft++;
            }
        }

        for (int i = col + 1; i < rightLimit; i++) {
            if (! (this.tab.getTablero().get(row).get(i) == this.empty)) {
                if (this.tab.getTablero().get(row).get(i).equals(type)) {
                    if (someRight > 0) {
                        semiSequencia++;
                    } else {
                        sequencia++;
                    }
                } else break;
            } else {
                someRight++;
            }
        }

        int some = someLeft + someRight;
        if (sequencia + semiSequencia + some >= 4) {
            return  new Points(sequencia, semiSequencia, someLeft, someRight, some);
        } else {
            return new Points(0,0,0,0,0);
        }

    }
    private Points verificarColumnas (int col,  int row , byte type) {

        int upLimit = Math.max(row-6,0);
        int downLimit =  Math.min (row+6,this.size);
        int sequencia = 0;
        int semiSequencia = 0;
        int someUp = 0;
        int someDown = 0;
        for (int i = row - 1; i >= upLimit; i--) {
            if (! (this.tab.getTablero().get(i).get(col) == this.empty) ) {
                if (this.tab.getTablero().get(i).get(col) == type) {
                    if (someUp> 0) {
                        semiSequencia++;
                    } else {
                        sequencia++;
                    }
                } else {
                    break;
                }
            } else {
                someUp++;
            }
        }

        for (int i = row + 1; i < downLimit; i++) {
            if (! (this.tab.getTablero().get(i).get(col) == this.empty) ) {
                if (this.tab.getTablero().get(i).get(col) == type) {
                    if (someDown > 0) {
                        semiSequencia++;
                    } else {
                        sequencia++;
                    }
                } else {
                    break;
                }
            } else {
                someDown++;
            }
        }

        int some = someUp + someDown;
        if (sequencia + semiSequencia + some >= 4) {
            return  new Points(sequencia, semiSequencia, someUp, someDown, some);
        } else {
            return new Points(0,0,0,0,0);
        }

    }
}

