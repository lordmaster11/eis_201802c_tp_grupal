package gradle.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class BombermanTest {

    private Bomberman bomberman = new Bomberman();
    private Mapa mapa = new Mapa(bomberman);

    //////////////// Punto 1 ////////////////


    @Given("^Un Bomberman")
    public void crearBoomberman() throws Throwable {
        bomberman.setMapa(mapa);
    }

    @When("^Quiere mover a la celda \"([^\"]*)\" y la celda es vacia$")
    public void quiereMoverALaCeldaYLaCeldaEsVacia(String direccion) throws Throwable {
        bomberman.moverA("Oeste");bomberman.moverA("Oeste");
        //bomberman no se mueve al oeste porque es el borde del tablero

        bomberman.moverA(direccion);
    }

    @Then("^El Bomberman se mueve a la celda \"([^\"]*)\"$")
    public void elBombermanSeMueveALaCelda(String direccion) throws Throwable {

        Celda celda = new Celda(0,1);

        assertThat(this.bomberman.getPosicionActual()).isEqualTo(celda);

        assertThat(celda).isNotEqualTo(bomberman);
    }


    @When("^Quiere mover a la celda \"([^\"]*)\" y esta tiene una pared$")
    public void quiereMoverALaCeldaYEstaTieneUnaPared(String direccion) throws Throwable {
        mapa.addParedes(new ParedMelamina(1,0));
        bomberman.moverA(direccion);
    }

    @Then("^El Bomberman no se mueve$")
    public void elBombermanNoSeMueve() throws Throwable {
        Celda celda = new Celda(0,0);

        assertThat((this.bomberman.getPosicionActual()).isEqualTo(celda));
    }


    @When("^Quiere mover tres veces al \"([^\"]*)\" y esta tiene un enemigo$")
    public void quiereMoverALaCeldaYEstaTieneUnEnemigo(String direccion) throws Throwable {
        mapa.addEnemigo(new EnemigoSimple(0,3));
        bomberman.moverA(direccion);
        bomberman.moverA(direccion);
        bomberman.moverA(direccion);
    }

    @Then("^El Bomberman se muere$")
    public void elBombermanSeMuere() throws Throwable {
        assertThat(this.bomberman.getVida()).isEqualTo(0);
    }


    //////////////// Punto 2 ////////////////


    @And("^Una Pared de melamina en la posicion \"([^\"]*)\" \"([^\"]*)\"$")
    public void unaParedDeMelaminaEnLaPosicion(String x, String y) throws Throwable {
        Pared melamina = new ParedMelamina(Integer.parseInt(x),Integer.parseInt(y));

        bomberman.getMapa().addParedes(melamina);
    }

    @When("^Pone una bomba con \"([^\"]*)\" ticks con un radio de tres celdas$")
    public void poneUnaBombaConTicksConUnRadioDeCeldas(String ticks) throws Throwable {
        bomberman.ponerBomba(Integer.parseInt(ticks));
    }

    @Then("^La bomba explota y la pared de melamina en la posicion \"([^\"]*)\" \"([^\"]*)\" desaparece por la onda expansiva$")
    public void laBombaExplotaYLaParedDeMelaminaEnLaPosicionDesaparecePorLaOndaExpansiva(String x, String y) throws Throwable {
        Celda celda = new Celda(Integer.parseInt(x),Integer.parseInt(y));

        assert(!mapa.hayPared(celda));
    }

    @And("^Un enemigo en la posicion \"([^\"]*)\" \"([^\"]*)\"$")
    public void unEnemigoEnLaPosicion(String x, String y) throws Throwable {
        Enemigo enemigo = new EnemigoSimple(Integer.parseInt(x),Integer.parseInt(y));
        bomberman.getMapa().addEnemigo(enemigo);
    }

    @Then("^La bomba explota y el enemigo muere$")
    public void laBombaExplotaYElEnemigoMuere() throws Throwable {

        assert(!mapa.hayEnemigoEn(new Celda(0,2)));
    }

    @And("^Una pared de Acero en la posicion \"([^\"]*)\" \"([^\"]*)\"$")
    public void unaParedDeAceroEnLaPosicion(String x, String y) throws Throwable {
        Pared acero = new ParedAcero(Integer.parseInt(x),Integer.parseInt(y));
        bomberman.getMapa().addParedes(acero);
    }

    @Then("^La bomba explota y la pared de acero en la posicion \"([^\"]*)\" \"([^\"]*)\" no se destruye$")
    public void laBombaExplotaYLaParedDeAceroEnLaPosicionNoSeDestruye(String x, String y) throws Throwable {
        Celda celda = new Celda(Integer.parseInt(x),Integer.parseInt(y));

        assert(mapa.hayPared(celda));
    }


    //////////////// Punto 3-4-5  ////////////////


    @And("^Un enemigo \"([^\"]*)\"$")
    public void unEnemigo(String unEnemigo) throws Throwable {
        Enemigo bagulaa = new EnemigoBagulaa(4, 1);
        Enemigo protoMaxJr = new EnemigoProtoMaxJr(5, 4);
        Enemigo protoMaxUnits = new EnemigoProtoMaxUnits(2, 8);
        mapa.addEnemigo(bagulaa);
        mapa.addEnemigo(protoMaxJr);
        mapa.addEnemigo(protoMaxUnits);
    }


    //////////////// Punto 3 ////////////////


    @When("^Pone una bomba y mata a Bagulaa$")
    public void poneUnaBombaYMataABagulaa() throws Throwable {
        bomberman.moverA("Este"); bomberman.moverA("Norte");
        bomberman.moverA("Este"); bomberman.moverA("Este");
        //Bomberman se movio a la posicion (3,1)

        bomberman.ponerBomba(4);
    }

    @Then("^Bomberman gana poder de lanzar bombas a \"([^\"]*)\" casillas y detona luego de \"([^\"]*)\" ticks$")
    public void bombermanGanaPoderDeLanzarBombasACasillasYDetonaLuegoDeTicks(String nBombas, String ticks) throws Throwable {
        Celda celdaBagulaa = new Celda(4,1);

        assert(!mapa.hayEnemigoEn(celdaBagulaa));
        assert(bomberman.tienePoderDeLanzarBombas());
    }


    //////////////// Punto 4 ////////////////


    @When("^Pone una bomba y mata a Proto Max Jr$")
    public void poneUnaBombaYMataAProtoMaxJr() throws Throwable {
        bomberman.moverA("Este"); bomberman.moverA("Este");
        bomberman.moverA("Este"); bomberman.moverA("Este");
        bomberman.moverA("Norte"); bomberman.moverA("Norte");
        bomberman.moverA("Norte"); bomberman.moverA("Norte");
        //Bomberman se movio a la posicion (4,4)

        bomberman.ponerBomba(7);
    }

    @Then("^Bomberman gana poder de saltar todo tipo de paredes$")
    public void bombermanGanaPoderDeSaltarTodoTipoDeParedes() throws Throwable {
        Celda celdaProtoMaxJr = new Celda(5,4);

        assert(!mapa.hayEnemigoEn(celdaProtoMaxJr));
        assert(bomberman.tienePoderDeSaltar());
    }

    //////////////// Punto 5 ////////////////


    @When("^Pone una bomba y mata a Proto-Max Units$")
    public void poneUnaBombaYMataAProtoMaxUnits() throws Throwable {
        bomberman.moverA("Este"); bomberman.moverA("Este");
        bomberman.moverA("Norte"); bomberman.moverA("Norte");
        bomberman.moverA("Norte"); bomberman.moverA("Norte");
        bomberman.moverA("Norte"); bomberman.moverA("Norte");
        bomberman.moverA("Norte"); bomberman.moverA("Norte");

        bomberman.ponerBomba(2);
    }

    @Then("^Bomberman gana poder de lanzar \"([^\"]*)\" bombas al mismo tiempo$")
    public void bombermanGanaPoderDeLanzarBombasAlMismoTiempo(String cantidad) throws Throwable {
        Celda celdaProtoMaxUNits = new Celda(2,8);

        assert(!mapa.hayEnemigoEn(celdaProtoMaxUNits));
        assert(bomberman.tienePoderDeSaltar());
        assert(bomberman.tienePoderDeLanzarBombas());
    }

    @And("^Otro enemigo \"([^\"]*)\" y otro enemigo$")
    public void otroEnemigoYOtroEnemigo(String arg0) throws Throwable {
        Enemigo protoMaxUnit = new EnemigoProtoMaxUnits(0,1);
        Pared pared = new ParedAcero(1,0);
        mapa.addParedes(pared);
        mapa.addEnemigo(protoMaxUnit);

    }

    @When("^Pone una bomba y mata a Proto-Max Units y gana poder de lanzar bombas y saltar paredes y se mueve al \"([^\"]*)\"$")
    public void poneUnaBombaYMataAProtoMaxUnitsYGanaPoderDeLanzarBombasYSaltarParedesYSeMueveAl(String direccion) throws Throwable {
        bomberman.ponerBomba(4);
        bomberman.moverA("Este");
    }

    @Then("^Cuando hay una pared en la posicion \"([^\"]*)\" bomberman la salta$")
    public void cuandoHayUnaParedEnLaPosicionBombermanLaSalta(String direccion) throws Throwable {
        Celda celda = new Celda(2,0);
        assert (bomberman.getPosicionActual().equals(celda));
    }


}

