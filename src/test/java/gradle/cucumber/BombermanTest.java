package gradle.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class BombermanTest {
    private Bomberman bomberman;

    @Given("^Un Bomberman")
    public void crearBoomberman() throws Throwable {
        bomberman = new Bomberman();
        Mapa mapa = new Mapa();
        mapa.addParedes(new Celda(1,0));
        mapa.addEnemigo(new Celda(-1,0));
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
}
