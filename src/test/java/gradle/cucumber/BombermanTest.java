package gradle.cucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class BombermanTest {
    private Bomberman bomberman;
    private Mapa mapa = new Mapa();

    //////////////// Punto 1 ////////////////


    @Given("^Un Bomberman")
    public void crearBoomberman() throws Throwable {
        bomberman = new Bomberman();
        mapa.addParedes(new ParedMelamina(1,0));
        mapa.addEnemigo(new Enemigo(-1,0));
        bomberman.setMapa(mapa);
    }

    @When("^Quiere mover a la celda \"([^\"]*)\" y la celda es vacia$")
    public void quiereMoverALaCeldaYLaCeldaEsVacia(String direccion) throws Throwable {
        bomberman.moverA(direccion);
    }

    @Then("^El Bomberman se mueve a la celda \"([^\"]*)\"$")
    public void elBombermanSeMueveALaCelda(String direccion) throws Throwable {
        Celda celda = new Celda(0,1);
        Celda other = new Celda(1,1);

        assertThat(this.bomberman.getPosicionActual()).isEqualTo(celda);

        assertThat(celda).isNotEqualTo(other);
        assertThat(celda).isNotEqualTo(bomberman);
    }


    @When("^Quiere mover a la celda \"([^\"]*)\" y esta tiene una pared$")
    public void quiereMoverALaCeldaYEstaTieneUnaPared(String direccion) throws Throwable {
        bomberman.moverA(direccion);
    }

    @Then("^El Bomberman no se mueve$")
    public void elBombermanNoSeMueve() throws Throwable {
        Celda celda = new Celda(0,0);

        assertThat(this.bomberman.getPosicionActual()).isEqualTo(celda);
    }


    @When("^Quiere mover a la celda \"([^\"]*)\" y esta tiene un enemigo$")
    public void quiereMoverALaCeldaYEstaTieneUnEnemigo(String direccion) throws Throwable {
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
        Enemigo enemigo = new Enemigo(Integer.parseInt(x),Integer.parseInt(y));
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


    //////////////// Punto 3 ////////////////



}

