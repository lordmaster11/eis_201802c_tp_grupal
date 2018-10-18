package gradle.cucumber;

public class Celda {
    private Integer x;
    private Integer y;

    public Celda() {

    }

    public Celda(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getY() {
        return y;
    }

    public Integer getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
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
