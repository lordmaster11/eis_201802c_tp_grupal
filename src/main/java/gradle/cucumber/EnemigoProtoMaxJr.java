package gradle.cucumber;

public class EnemigoProtoMaxJr extends Enemigo {

    public EnemigoProtoMaxJr(Integer x, Integer y) {
        super(x,y);
    }

    @Override
    public void otorgarPoderesABomberman(Bomberman bomberman) {
        bomberman.ganarPoderSaltoDePared();
        this.morir();
    }
}
