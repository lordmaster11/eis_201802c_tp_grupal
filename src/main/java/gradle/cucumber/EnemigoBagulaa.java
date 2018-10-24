package gradle.cucumber;

public class EnemigoBagulaa extends Enemigo {

    private Integer aDistancia = 4;
    private Integer conTicks = 3;

    public EnemigoBagulaa(Integer x, Integer y) {
        super(x,y);
    }

    @Override
    public void otorgarPoderesABomberman(Bomberman bomberman) {
        bomberman.ganarPoderLanzaBombas(aDistancia,conTicks);
        this.morir();
    }
}
