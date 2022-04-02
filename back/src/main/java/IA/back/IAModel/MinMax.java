package IA.back.IAModel;

import IA.back.Modelos.Position;
import IA.back.pojo.PositionPOJO;
import IA.back.Modelos.Tablero;

import java.util.ArrayList;
import java.util.Collections;

public class MinMax {
    private Tablero tablero;


    public MinMax(Tablero root) {
        this.tablero = root;
    }

    public Tablero getNextMove (){
        retourMinMax ret = this.MinMax(5);
        this.tablero.setTablero(ret.getPos(), (byte) 1);
        this.tablero.setChangePos(ret.getPos());
        System.out.println("-------------------------------------------------------");
        return this.tablero;
    }

    /**
     * MinMAx with AlphaBeta optimization
     * @param depth
     * @return
     */
    private retourMinMax MinMax(int depth){
        ArrayList<Position> posibles = this.tablero.getPosibles();
        Collections.sort(posibles);
        return this.MinMaxAux(this.tablero, depth, Integer.MIN_VALUE, Integer.MAX_VALUE, true, posibles);
    }
    /**
     * MinMAx with AlphaBeta optimization - Auxiliar function
     * @param position Node to evalue
     * @param depth depth to explore
     * @param alpha Alpha parameter
     * @param beta Beta parameter
     * @param maximizingPlayer if we are in a max position
     * @return Best Heuristic value
     */
    private retourMinMax MinMaxAux(Tablero position, int depth, int alpha, int beta, boolean maximizingPlayer, ArrayList<Position> posibles){
        if (depth==0 ||  position.isWining((byte) 1 )) return new retourMinMax(new FirstHeuristic(position).HeuristicValue(), null);
        if (maximizingPlayer) {
            retourMinMax aux = new retourMinMax(Integer.MIN_VALUE,null);
            int len = posibles.size() - 1;
            for (int i = 0; i < len; i++) {
                Position pos = posibles.get(i).clone();
                //Make
                position.setTablero(pos, (byte) 1);
                posibles.remove(i);
                // retorno
                retourMinMax aux1 = MinMaxAux(position, depth-1, alpha, beta, false, posibles);
                int eval = aux1.getValue();
                if (eval > aux.getValue()) {
//                  bestPos = pos;
                    aux.setPos(pos);
                    aux.setValue(eval);
                };
                if(depth == 5) {
                    System.out.println("" + aux + " : " + pos);
                }
                //UnMake
                position.unSetTablero(pos);
                posibles.add(i,pos);
                if (aux.getValue()>= beta){
                    break;
                }
                alpha = Math.max(alpha, aux.getValue());
            }
            return aux;
        }else{
            retourMinMax aux = new retourMinMax(Integer.MAX_VALUE,null);
            int len = posibles.size() -1 ;
            for (int i = 0; i < len; i++) {
                Position pos = posibles.get(i).clone();
                //Make
                position.setTablero(pos, (byte) 2);
                posibles.remove(i);
                //Retorno
                retourMinMax aux1 = MinMaxAux(position, depth-1, alpha, beta, true, posibles);
                int eval = aux1.getValue();
                if (eval < aux.getValue() ) {
                    aux.setPos(pos);
                    aux.setValue(eval);
                }
                // UnMake
                position.unSetTablero(pos);
                posibles.add(i,pos);
                if (aux.getValue() <= alpha){
                    break;
                }
                beta = Math.min(beta, aux.getValue());
            }
            return aux;
        }
    }
}
