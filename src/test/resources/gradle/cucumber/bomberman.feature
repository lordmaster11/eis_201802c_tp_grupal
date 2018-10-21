Feature: Mover Bomberman

  Scenario: Mover bomberman a celda vacia
    Given Un Bomberman
    When Quiere mover a la celda "Norte" y la celda es vacia
    Then El Bomberman se mueve a la celda "Norte"


  Scenario: Bomberman no se mueve
    Given Un Bomberman
    When Quiere mover a la celda "Este" y esta tiene una pared
    Then El Bomberman no se mueve

  Scenario: Bomberman se muere
    Given Un Bomberman
    When Quiere mover a la celda "Oeste" y esta tiene un enemigo
    Then El Bomberman se muere



  Scenario: Bomberman suelta una bomba en el sitio donde se encuentra
    Given Un Bomberman
    And Una Pared de melamina en la posicion "2" "0"
    When Pone una bomba con "5" ticks con un radio de tres celdas
    Then La bomba explota y la pared de melamina en la posicion "2" "0" desaparece por la onda expansiva


  Scenario: Bomberman suelta una bomba en el sitio donde se encuentra
    Given Un Bomberman
    And Un enemigo en la posicion "0" "2"
    When Pone una bomba con "4" ticks con un radio de tres celdas
    Then La bomba explota y el enemigo muere


  Scenario: Bomberman suelta una bomba en el sitio donde se encuentra
    Given Un Bomberman
    And Una pared de Acero en la posicion "0" "2"
    When Pone una bomba con "2" ticks con un radio de tres celdas
    Then La bomba explota y la pared de acero en la posicion "0" "2" no se destruye
