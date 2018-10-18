package gradle.cucumber;

public enum Direccion {
    NORTE(0,1),
    SUR(0,-1),
    ESTE(1,0),
    OESTE(-1,0);

    private final int yCoord;
    private final int xCoord;

    Direccion(int x, int y) {
        this.xCoord = x;
        this.yCoord = y;
    }

    public int getYCoord() {
        return yCoord;
    }

    public int getXCoord() {
        return xCoord;
    }
}
