package gradle.cucumber;

public class Celda {
    private Integer x;
    private Integer y;

    public Celda(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object another) {
        if ( !this.getClass().equals(another.getClass())) {
            return false;
        }
        Celda c = (Celda) another;
        return this.x.equals(c.x) && this.y.equals(c.y);
    }
}
