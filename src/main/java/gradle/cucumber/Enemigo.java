package gradle.cucumber;

public class Enemigo {
    private Celda posicion = new Celda();;

    public Enemigo(Integer x, Integer y) {
        posicion.setX(x);
        posicion.setY(y);
    }

    public Celda getPosicion() {
        return this.posicion;
    }
}
