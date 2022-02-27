package IA.back.IAModel;

import IA.back.Modelos.Tablero;

import java.util.ArrayList;

public class Node {
    private Tablero tablero;
    private Node father;
    private ArrayList<Node> childs;

    public Node(Tablero tablero) {
        this.tablero = tablero;
        this.childs = new ArrayList<>();
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public Node getFather() {
        return father;
    }

    public void setFather(Node father) {
        this.father = father;
    }

    public ArrayList<Node> getChilds() {
        return childs;
    }

    public void addChild(Node child) {
        this.childs.add(child) ;
    }


    public boolean isGoal(){
        //Completer
        return true;
    }


    public int getHeuristic(){
        //Completer
        return 0;
    }
}
