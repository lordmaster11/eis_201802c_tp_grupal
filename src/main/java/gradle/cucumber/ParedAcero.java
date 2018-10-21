package gradle.cucumber;

public class ParedAcero extends Pared {
    public ParedAcero(Integer x, Integer y) {
        super(x,y);
    }

    @Override
    public boolean esDeMelanina() {
        return false;
    }
}
