package gradle.cucumber;

public class PoderDeLanzamiento {


    private Integer ticks;
    private Integer distancia;

    public PoderDeLanzamiento(Integer distancia, Integer ticks) {
        this.distancia = distancia;
        this.ticks = ticks;
    }

    public boolean puedeLanzarBombas() {
        return distancia>0;
    }

    public void ganarPoder(Integer distancia, Integer ticks) {
        this.distancia = distancia;
        this.ticks = ticks;
    }

    public Bomba calcularPosicion(Celda posicionActual) {

        Celda posicionATirar = new Celda(posicionActual.getX()+distancia,posicionActual.getY());

        return  new Bomba(posicionATirar,ticks);
    }
}
