package gradle.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.assertj.core.api.Assertions.assertThat;

public class BombermanTest {
    private Bomberman bomberman;

    @Given("^Crear Boomberman")
    public void crearBoomberman() throws Throwable {
        bomberman = new Bomberman();
    }

    @When("^Seteo \"([^\"]*)\" de vida")
    public void setVida(Integer vida) throws Throwable {
        bomberman.setVida(100);
    }

    @Then("^La vida de Boomberman es:")
    public void getVida() throws Throwable {
        Integer actual = bomberman.getVida();

        assertThat(actual).isEqualTo(100);
    }

    @When("^Seteo una posicion inicial (\\d+) (\\d+)$")
    public void seteoUnaPosicionInicial(Integer x, Integer y) throws Throwable {
        bomberman.setPosicionInicial(0,0);
    }

    @Then("^La celda es:")
    public void getCelda() throws Throwable {
        Celda celda = bomberman.getPosicionInicial();
        Celda expected = new Celda(0,0);
        Celda other = new Celda(1,1);

        assertThat(celda).isEqualTo(expected);
        assertThat(celda).isNotEqualTo(other);
    }
}
