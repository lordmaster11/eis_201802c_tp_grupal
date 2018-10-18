package gradle.cucumber;

public class CalculadorDePosiciones {
    private Direccion direccionAMoverse;

    public Celda calcularposicionDeCelda(String direccion, Celda posicionActual) {
        this.calcularDireccion(direccion);

        Celda posicionFinal = new Celda();
        posicionFinal.setY(posicionActual.getY() + direccionAMoverse.getYCoord());
        posicionFinal.setX(posicionActual.getX() + direccionAMoverse.getXCoord());

        return posicionFinal;
    }

    private void calcularDireccion(String direccion) {
        switch (direccion) {
            case "Norte":
                direccionAMoverse = Direccion.NORTE;
                break;
            case "Sur":
                direccionAMoverse = Direccion.SUR;
                break;
            case "Este":
                direccionAMoverse = Direccion.ESTE;
                break;
            case "Oeste":
                direccionAMoverse = Direccion.OESTE;
                break;

        //Exception
        }
    }
}
