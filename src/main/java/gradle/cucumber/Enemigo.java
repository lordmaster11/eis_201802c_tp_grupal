package gradle.cucumber;

public abstract class Enemigo {
    private Celda posicion = new Celda();
    private boolean estaVivo = true;

    public Enemigo(Integer x, Integer y) {
        posicion.setX(x);
        posicion.setY(y);
    }

    public Celda getPosicion() {
        return this.posicion;
    }

    public abstract void otorgarPoderesABomberman(Bomberman bomberman);

    protected void morir(){
     this.estaVivo = false;
    }
}
