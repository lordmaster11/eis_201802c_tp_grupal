package gradle.cucumber;

public class Bomberman {
    private Integer vida;
    private Celda posicionActual = this.posicionInicial();
    private Mapa mapa = new Mapa();
    private CalculadorDePosiciones calculador = new CalculadorDePosiciones();

    public Bomberman() {
    }

    public Celda posicionInicial() {
        Celda celdaInicial = new Celda(0, 0);

        return celdaInicial;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public Integer getVida() {
        return vida;
    }

    public void  setPosicionActual(Celda celda) {
        this.posicionActual = celda;
    }

    public Celda getPosicionActual() {
        return this.posicionActual;
    }

    public void moverA(String direccion){
        Celda celdaAMoverse;

        celdaAMoverse = this.calcularNuevaPosicionMoviendoseEn(direccion);

        if(puedeMover(celdaAMoverse)) {
            this.setPosicionActual(celdaAMoverse);
        }
        if(hayEnemigo(celdaAMoverse)){
            this.muere();
        }
    }

    private boolean hayEnemigo(Celda celdaAMoverse) {
        return this.mapa.hayEnemigoEn(celdaAMoverse);
    }

    private Celda calcularNuevaPosicionMoviendoseEn(String direccion) {

        return this.calculador.calcularposicionDeCelda(direccion,this.getPosicionActual());
    }

    private boolean puedeMover(Celda celda) {
        return !mapa.hayPared(celda);
    }

    private void muere() {
        this.vida = 0;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }
}
