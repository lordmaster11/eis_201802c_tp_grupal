package gradle.cucumber;

public class Bomba {
    private Celda posicion;
    private Integer ticks;
    private Integer rango = 3;

    public Bomba(Celda posicionActual, Integer _ticks) {
        this.posicion = posicionActual;
        this.ticks = _ticks;
    }

    public Celda getPosicion() {
        return this.posicion;
    }

    public void tick() {
        if(ticks != 0) {
            for (int i = 1; i <= this.ticks; i++) {
                System.out.print("tick: " + i + ", "+"\n");
            }
        }
    }

    public Integer getRango() {
        return rango;
    }
}
