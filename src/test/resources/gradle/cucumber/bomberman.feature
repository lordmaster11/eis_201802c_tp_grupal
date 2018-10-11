Feature: Crear Boomberman

  Scenario: Creo un boomberman
    Given Crear Boomberman
    When Seteo "100" de vida
    Then La vida de Boomberman es:

  Scenario: Creo un boomberman
    Given Crear Boomberman
    When Seteo una posicion inicial 1 2
    Then La celda es :