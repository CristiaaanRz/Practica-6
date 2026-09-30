package org.example;

public class Main {
    public static void main(String[] args) {
        // Crear una carta de cada figura
        Carta c1 = new Carta(1, Figura.CORAZONES); // AS
        Carta c2 = new Carta(10, Figura.DIAMANTES); // 10
        Carta c3 = new Carta(13, Figura.PICAS);     // REY
        Carta c4 = new Carta(11, Figura.TREBOLES);  // JOTA

        // Desplegar las 4 cartas alineadas horizontalmente
        Visualizador.carta(c1, new Posicion(20, 40));
        Visualizador.carta(c2, new Posicion(110, 40));
        Visualizador.carta(c3, new Posicion(200, 40));
        Visualizador.carta(c4, new Posicion(290, 40));
    }
}