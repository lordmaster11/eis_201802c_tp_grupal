package gradle.cucumber;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Mapa {
    Bomberman bomberman;
    List<Pared> paredes = new ArrayList<>();
    List<Enemigo> enemigos = new ArrayList<>();

    public Mapa(Bomberman bomberman) {
       this.bomberman = bomberman;
    }

    public boolean hayPared(Celda celda) {
        return this.paredes.stream().anyMatch(i-> i.getPosicion().equals(celda));
    }

    public void addParedes(Pared pared) {
        this.paredes.add(pared);
    }

    public boolean hayEnemigoEn(Celda celdaAMoverse) {
        return this.enemigos.stream().anyMatch(i-> i.getPosicion().equals(celdaAMoverse));
    }

    public void addEnemigo(Enemigo enemigo) {
        this.enemigos.add(enemigo);
    }

    public void explotarBomba(Bomba bomba) {
        bomba.tick();
        this.explotarEnOndaExpansiva(bomba);
    }

    private void explotarEnOndaExpansiva(Bomba bomba) {
        Celda celda = bomba.getPosicion();
        Integer x = celda.getX();
        Integer y = celda.getY();

        this.boom("Norte",bomba);
        this.boom("Sur", bomba);
        this.boom("Este", bomba);
        this.boom("Oeste", bomba);
    }

    private void boom(String direccion, Bomba bomba) {

        CalculadorDePosiciones calculadora = new CalculadorDePosiciones();

        Celda posicionActual=bomba.getPosicion();
        for (int i = 0; i < bomba.getRango(); i++){
            Celda posicionLindante = calculadora.calcularposicionDeCelda(direccion,posicionActual);
            this.explotarParedesUbicadasEn(posicionActual);
            this.matarEnemigos(posicionActual);
            posicionActual = posicionLindante;
        }
    }

    private void matarEnemigos(Celda posicion) {

        this.enemigos
                .stream()
                .filter(i -> i.getPosicion().equals(posicion))
                .findFirst().
                ifPresent(i -> {this.enemigos.remove(i); this.otorgarPoderesDe(i);});


    }

    private void otorgarPoderesDe(Enemigo unEnemigo) {

        unEnemigo.otorgarPoderesABomberman(this.bomberman);

    }

    private void explotarParedesUbicadasEn(Celda posicion) {
        this.paredes = this.paredes.stream().filter(i-> !(i.getPosicion().equals(posicion)&& i.esDeMelanina())).collect(Collectors.toList());
    }

    public boolean finalDeTablero() {
        return false;
    }
}
