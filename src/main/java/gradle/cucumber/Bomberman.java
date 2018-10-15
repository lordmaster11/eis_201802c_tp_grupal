package gradle.cucumber;

public class Bomberman {
    private Integer vida;
    private Celda posicionInicial;

    public Bomberman() {
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public Integer getVida() {
        return vida;
    }

    public void setPosicionInicial(Integer x, Integer y) {
        this.posicionInicial = new Celda(x,y);
    }

    public Celda getPosicionInicial() {
        return posicionInicial;
    }
}
