package gradle.cucumber;

public class EnemigoSimple extends Enemigo{

    public EnemigoSimple(Integer x, Integer y) {
        super(x,y);
    }

    @Override
    public void otorgarPoderesABomberman(Bomberman bomberman){
        this.morir();
    }
}
