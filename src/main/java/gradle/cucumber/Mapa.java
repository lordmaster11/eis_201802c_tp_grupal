package gradle.cucumber;

import java.util.ArrayList;
import java.util.List;

public class Mapa {
    List<Celda> paredes = new ArrayList<>();
    List<Celda> enemigos = new ArrayList<>();

    public boolean hayPared(Celda celda) {
        return this.paredes.stream().anyMatch(i-> i.equals(celda));
    }

    public void addParedes(Celda celda) {
        this.paredes.add(celda);
    }

    public boolean hayEnemigoEn(Celda celdaAMoverse) {
        return this.enemigos.stream().anyMatch(i-> i.equals(celdaAMoverse));
    }

    public void addEnemigo(Celda celda) {
        this.enemigos.add(celda);
    }
}
