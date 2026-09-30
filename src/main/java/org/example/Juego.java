package org.example;

import java.util.ArrayList;
import java.util.List;

public class Juego {

    public static void main(String[] args) {

        // 1. CREACION DEL MAZO DE 52 CARTAS
        System.out.println("CREANDO MAZO DE 52 CARTAS");
        Mazo mazo = new Mazo();
        System.out.println("Mazo creado con " + mazo.cantidadCartas() + " cartas\n");

        // 2. MOSTRAR LAS PRIMERAS CARTAS DEL MAZO SIN BARAJAR
        System.out.println("MOSTRANDO PRIMERAS 5 CARTAS DEL MAZO SIN BARAJAR:");
        imprimirPrimerasCartas(mazo, 5);
        System.out.println();

        // 3. BARAJAR LAS CARTAS DEL MAZO
        System.out.println("BARAJANDO MAZO...");
        mazo.barajar();
        System.out.println("¡Mazo barajado!\n");

        // 4. MOSTRAR LAS PRIMERAS CARTAS DESPUÉS DE BARAJAR
        System.out.println("MOSTRANDO PRIMERAS 5 CARTAS DEL MAZO DESPUÉS DE BARAJAR:");
        imprimirPrimerasCartas(mazo, 5);
        System.out.println();

        // 5. CREACION DE LOS 3 JUGADORES
        System.out.println("CREANDO 3 JUGADORES");
        Jugador cristian = new Jugador("Cristian");
        Jugador ramiro = new Jugador("Ramiro");
        Jugador diego = new Jugador("Diego");

        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(cristian);
        jugadores.add(ramiro);
        jugadores.add(diego);

        for (int i = 0; i < jugadores.size(); i++) {
            System.out.println("Jugador " + (i + 1) + ": " + jugadores.get(i).nombre);
        }
        System.out.println();

        // 6. REPARTIR 5 CARTAS A CADA UNO DE LOS JUGADORES
        System.out.println("REPARTIENDO 5 CARTAS A CADA JUGADOR");
        System.out.println("Repartiendo... ¡Listo!\n");
        mazo.repartir(jugadores, 5);

        // 7. DESPLEGAR EN CONSOLA LAS CARTAS DE CADA JUGADOR
        System.out.println("MOSTRANDO CARTAS DE CADA JUGADOR:");
        for (Jugador j : jugadores) {
            System.out.println(j);
        }
        System.out.println();

        // 8. MOSTRAR EL ESTADO DEL MAZO TRAS EL REPARTO
        System.out.println("CARTAS RESTANTES EN EL MAZO (DESPUÉS DE REPARTIR):");
        System.out.println("Quedan " + mazo.cantidadCartas() + " cartas en el mazo");
        System.out.print("Primeras 5 cartas del mazo: ");
        imprimirPrimerasCartas(mazo, 5);
        System.out.println("\n");

        // 9. CRISTIAN REGRESA 2 CARTAS AL MAZO
        List<Carta> manoCristian = cristian.getMano();
        if (manoCristian.size() >= 2) {
            // TOMAR LAS DOS PRIMERAS CARTAS DE LA MANO DE CRISTIAN
            Carta c1 = manoCristian.get(0);
            Carta c2 = manoCristian.get(1);

            System.out.println("CRISTIAN DEVUELVE 2 CARTAS AL MAZO ("
                    + c1.getValorEnLetra() + " de " + c1.getFigura() + " y "
                    + c2.getValorEnLetra() + " de " + c2.getFigura() + ")\n");

            // CRISTIAN SE DESHACE DE DICHAS CARTAS
            cristian.deshacerseDeCarta(c1);
            cristian.deshacerseDeCarta(c2);

            // AGREGAR DE NUEVO DICHAS CARTAS AL MAZO
            mazo.agregarCarta(c1);
            mazo.agregarCarta(c2);

            System.out.println("CARTAS DE CRISTIAN DESPUÉS DE DEVOLVER:");
            System.out.println(cristian);
            System.out.println();

            System.out.println("MAZO DESPUÉS DE RECIBIR CARTAS DEVUELTAS:");
            System.out.println("Quedan " + mazo.cantidadCartas() + " cartas en el mazo");
            System.out.println("Las cartas devueltas se agregaron al final: ... " + c1 + " " + c2 + "\n");
        }

        // 10. LOCALIZAR DÓNDE SE ENCUENTRA UNA CARTA ESPECÍFICA EN EL JUEGO
        if (!cristian.getMano().isEmpty()) {
            Carta cartaABuscar = cristian.getMano().get(0);
            System.out.println("BUSCANDO CARTA \"" + cartaABuscar.getValorEnLetra() + " de " + cartaABuscar.getFigura() + "\":");
            buscarYMostrarPropietario(cartaABuscar, jugadores, mazo);
        }
    }

    // MÉTODOS AUXILIARES DEL PROGRAMA

    // METODO AUXILIAR PARA IMPRIMIR EN PANTALLA LAS PRIMERAS N CARTAS DEL MAZO
    private static void imprimirPrimerasCartas(Mazo mazo, int n) {
        List<Carta> cartas = mazo.getCartas();
        int limite = Math.min(n, cartas.size());
        for (int i = 0; i < limite; i++) {
            System.out.print(cartas.get(i) + " ");
        }
        System.out.println();
    }

    // METODO AUXILIAR PARA LOCALIZAR Y MOSTRAR QUIÉN TIENE UNA CARTA EN ESPECÍFICO
    private static void buscarYMostrarPropietario(Carta carta, List<Jugador> jugadores, Mazo mazo) {
        for (Jugador j : jugadores) {
            if (j.getMano().contains(carta)) {
                System.out.println("La carta " + carta.getValorEnLetra() + " de " + carta.getFigura()
                        + " está en posesión de: " + j.nombre);
                return;
            }
        }
        if (mazo.getCartas().contains(carta)) {
            System.out.println("La carta " + carta.getValorEnLetra() + " de " + carta.getFigura()
                    + " está en el mazo.");
        }
    }
}