package IA.back.IAModel;

import java.util.ArrayList;

import IA.back.Modelos.Position;


public class CenterMass {

    private ArrayList<ArrayList<String>> tablero;
    private int dx;
    private int dy;
    private Position centerPosition;
    //private int heuristic = 100;
    private int[] heuristic = {10, 20, 30, 50, 20, 40, 100, 80, 10, 20};
    private int heuristicFinal;
    private ArrayList<Integer> pointsX;
    private ArrayList<Integer> pointsY;
    private ArrayList<Integer> pointsDX;
    private ArrayList<Integer> pointsDY;


    public int TotalX(ArrayList<ArrayList<String>> tablero){

        for (int i = 0; i < tablero.size(); i++) {
            for (int j = 0; j < tablero.get(i).size(); j++) {
                if(this.tablero.get(i).get(j).equals("1") ) {
                    pointsX.add(i);
                }
            }
        }

        for(int k = 0; k < pointsX.size(); k++){
            pointsDX.add(pointsX.get(k) * heuristic[k]);
        }

        for(int l = 0; l < pointsDX.size(); l++){
            this.dx = dx + pointsX.get(l);
        }

        return dx;
    }

    public int TotalY(ArrayList<ArrayList<String>> tablero){

        for (int i = 0; i < tablero.size(); i++) {
            for (int j = 0; j < tablero.get(i).size(); j++) {
                if(this.tablero.get(i).get(j).equals("1") ) {
                    pointsY.add(j);
                }
            }
        }

        for(int k = 0; k < pointsX.size(); k++){
            pointsDY.add(pointsX.get(k) * heuristic[k]);
        }

        for(int l = 0; l < pointsDY.size(); l++){
            this.dy = dy + pointsY.get(l);
        }

        return dy;
    }


    public Position CenterMassF(int dx, int dy, int[] heuristic){

        for(int l = 0; l < heuristic.length; l++){
            this.heuristicFinal = heuristicFinal + heuristic[l];
        }

        dx = dx / heuristicFinal;
        dy = dy / heuristicFinal;

        return this.centerPosition = new Position(dx, dy);

    }
    
}