package IA.back.IAModel;

import IA.back.Modelos.Tablero;

public class Graph {
    private Node root;
    private int length;

    public Graph(Tablero root) {
        this.root = new Node(root);
    }

    public Node getRoot() {
        return root;
    }

    public int getLength() {
        return length;
    }
    public void addNode(Node father, Node child){
        father.addChild(child);
        child.setFather(father);
    }
}
