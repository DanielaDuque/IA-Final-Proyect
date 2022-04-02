package IA.back.IAModel;

public class Points {
    private  int sequencias;
    private int semiSequencias;
    private int someLeft;
    private int someRight;
    private int some;

    public Points(int sequencias, int semiSequencias, int someLeft, int someRight, int some) {
        this.sequencias = sequencias;
        this.semiSequencias = semiSequencias;
        this.someLeft = someLeft;
        this.someRight = someRight;
        this.some = some;
    }

    public int getSequencias() {
        return sequencias;
    }

    public int getSemiSequencias() {
        return semiSequencias;
    }

    public int getsomeLeft() {
        return someLeft;
    }

    public int getsomeRight() {
        return someRight;
    }

    public int getsome() {
        return some;
    }
}
