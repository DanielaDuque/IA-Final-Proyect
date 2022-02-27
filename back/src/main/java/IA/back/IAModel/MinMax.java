package IA.back.IAModel;

import IA.back.Modelos.Tablero;

import java.util.PriorityQueue;

public class MinMax {
    private Graph graph;

    public MinMax(Tablero root) {
        this.graph = new Graph(root);
    }


    public int MinMax(int depth){
        return this.MinMaxAux(this.graph.getRoot(), depth, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
    }
    /**
     *
     * @param position Node to evalue
     * @param depth depth to explore
     * @param alpha Alpha parameter
     * @param beta Beta parameter
     * @param maximizingPlayer if we are in a max posotion
     * @return MinMAx with AlphaBeta optimization
     */
    public int MinMaxAux(Node position, int depth, int alpha, int beta, boolean maximizingPlayer){
        if (depth==0 ||  position.isGoal()) return position.getHeuristic();
        if (maximizingPlayer) {
            int value = Integer.MIN_VALUE;
            for ( Node child: position.getChilds()) {
                int eval = MinMaxAux(child, depth-1, alpha, beta, false);
                value = Math.max(value,eval);
                if (value>= beta){
                    break;
                }
                alpha = Math.max(alpha, value);
            }
            return value;
        }else{
            int value = Integer.MAX_VALUE;
            for ( Node child: position.getChilds()) {
                int eval = MinMaxAux(child, depth-1, alpha, beta, true);
                value = Math.min(value,eval);
                if (value <= alpha){
                    break;
                }
                beta = Math.min(beta, value);
            }
            return value;
        }
    }
}

/**
 * unction Minimax(position, depth, maximizingPlayer)
 * 2: if depth == 0 or game over in position then
 * 3: return static evaluation of position
 * 4: if maximizingPlayer then
 * 5: maxEval = −∞
 * 6: each child in position
 * 7: eval = Minimax(child, depth-1, false)
 * 8: maxEval = max(maxEval, eval)
 * 9: return maxEval
 * 10: else
 * 11: minEval = +∞
 * 12: each child in position
 * 13: eval = Minimax(child, depth-1, true)
 * 14: minEval = min(minEval, eval)
 * 15: return minEval
 */


/**
 * unction Minimax(position, depth, alpha, deta, maximizingPlayer)
 * 2: if depth == 0 or game over in position then
 *      return static evaluation of position
 * 4: if maximizingPlayer then
 *      each child in position
 * 6:   eval = Minimax(child, depth-1, false)
 *      maxEval = max(maxEval, eval) alpha= max(alpha, eval)
 * 8:   if beta ≤ alpha break
 *          return maxEval
 * 10: else
 *      each child in position
 * 12:       eval = Minimax(child, depth-1, true)
 *           minEval = min(minEval, eval) beta= max(beta, eval)
 * 14:      if beta ≤ alpha break
 *              return minEval
 */

