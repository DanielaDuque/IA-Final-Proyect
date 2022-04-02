package IA.back.IAModel;

import java.util.ArrayList;

import IA.back.Modelos.Position;
import IA.back.pojo.PositionPOJO;
import IA.back.Modelos.Tablero;


public class CenterMass {

    private ArrayList<ArrayList<Byte>> tablero;
    private int dx = 0;
    private int dy = 0;
    //private int heuristic = 100;
    private ArrayList<Integer> heuristic = new ArrayList<>();
    private int heuristicFinal = 0;

    private void calculeHeuristic(){
        for (int i = 0; i < tablero.size(); i++) {
            for (int j = 0; j < tablero.get(i).size(); j++){
                if(this.tablero.get(i).get(j)  == 1){
                    int heuristicAux = new FirstHeuristic(new Tablero(this.tablero,new Position(i,j) ) ).HeuristicValue();
                    heuristic.add(heuristicAux);
                    heuristicFinal += heuristicAux;
                }
            }
        }
    }

    public void Total(){

        ArrayList<Integer> pointsX = new ArrayList<>();
        ArrayList<Integer> pointsY  = new ArrayList<>();
        ArrayList<Integer> pointsDX = new ArrayList<>();
        ArrayList<Integer> pointsDY = new ArrayList<>();

        for (int i = 0; i < tablero.size(); i++) {
            for (int j = 0; j < tablero.get(i).size(); j++) {
                if(this.tablero.get(i).get(j) == 1 ) {
                    pointsX.add(i);
                    pointsY.add(j);
                }
            }
        }

        for(int k = 0; k < pointsX.size(); k++){
            pointsDX.add(pointsX.get(k) * heuristic.get(k));
            pointsDY.add(pointsX.get(k) * heuristic.get(k));

        }

        for(int l = 0; l < pointsDX.size(); l++){
            this.dx = dx + pointsDX.get(l);
            this.dy = dy + pointsDY.get(l);

        }
    }

    public Position CenterMassF(ArrayList<ArrayList<Byte>> tab){
        this.tablero = tab;
        this.calculeHeuristic();
        int size = this.tablero.size();
        if(heuristicFinal == 0) return new Position( size/2 ,  size/2);
        this.Total();
        dx = dx / heuristicFinal;
        dy = dy / heuristicFinal;
        return new Position(dx, dy);
    }
    
}