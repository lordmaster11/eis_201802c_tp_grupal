package gradle.cucumber;

public class EnemigoProtoMaxUnits extends Enemigo {

    private Integer aDistancia = 4;
    private Integer conTicks = 3;

    public EnemigoProtoMaxUnits(Integer x, Integer y) {
        super(x,y);
    }

    @Override
    public void otorgarPoderesABomberman(Bomberman bomberman) {

        bomberman.ganarPoderSaltoDePared();
        bomberman.ganarPoderLanzaBombas(this.aDistancia, this.conTicks);
        this.morir();
    }
}
