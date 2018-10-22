package gradle.cucumber;

public abstract class Pared {
    private Celda posicion = new Celda();

    public Pared(Integer x, Integer y) {
        posicion.setX(x);
        posicion.setY(y);
    }

    public Celda getPosicion() {
        return  this.posicion;
    }

    public abstract boolean esDeMelanina();
}
