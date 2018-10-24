package gradle.cucumber;

public class CalculadorDePosiciones {
    private Direccion direccionAMoverse;

    public Celda calcularposicionDeCelda(String direccion, Celda posicionActual) {
        this.calcularDireccion(direccion);

        Celda posicionFinal = posicionActual;
        //Tener en cuenta esquina de mapa
        Integer posX = posicionActual.getX() + direccionAMoverse.getXCoord();
        Integer posY = posicionActual.getY() + direccionAMoverse.getYCoord();
        if(posX >= 0){
            posicionFinal.setX(posX);
        }
        if(posY >= 0){
            posicionFinal.setY(posY);
        }

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
