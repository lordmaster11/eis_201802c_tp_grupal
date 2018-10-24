package gradle.cucumber;

public class Bomberman {
    private Integer vida;
    private Celda posicionActual = this.posicionInicial();
    private Mapa mapa = new Mapa(this);
    private CalculadorDePosiciones calculador = new CalculadorDePosiciones();
    private PoderDeLanzamiento poderLanzar = new PoderDeLanzamiento(0,1);
    private boolean poderSaltar = false;


    public Bomberman() {
    }

    public Celda posicionInicial() {
        Celda celdaInicial = new Celda(0, 0);

        return celdaInicial;
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
        }else if(this.poderSaltar & !mapa.finalDeTablero()){
            this.setPosicionActual(calculador.calcularposicionDeCelda(direccion, celdaAMoverse));
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

    public void ponerBomba(Integer ticks) {
        Bomba bomba = new Bomba (this.posicionActual, ticks);
        if(tienePoderDeLanzarBombas()){
          bomba = this.getpoderLanzar().calcularPosicion(this.posicionActual);
        }
        this.mapa.explotarBomba(bomba);
    }

    private PoderDeLanzamiento getpoderLanzar() {
        return this.poderLanzar;
    }

    public Mapa getMapa() {
        return this.mapa;
    }

    public boolean tienePoderDeLanzarBombas() {
        return this.poderLanzar.puedeLanzarBombas();
    }

    public void ganarPoderLanzaBombas(Integer distancia, Integer ticks) {
        this.poderLanzar.ganarPoder(distancia,ticks);
    }

    public void ganarPoderSaltoDePared() {
        this.poderSaltar = true;
    }

    public boolean tienePoderDeSaltar() {
        return poderSaltar;
    }
}
