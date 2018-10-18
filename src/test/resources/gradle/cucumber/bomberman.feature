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

