package gradle.cucumber;

public class ParedMelamina extends Pared {
    public ParedMelamina(Integer x, Integer y) {
        super(x,y);
    }

    @Override
    public boolean esDeMelanina() {
        return true;
    }
}
