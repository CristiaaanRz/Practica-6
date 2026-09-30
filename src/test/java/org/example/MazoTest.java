package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * CLASE DE PRUEBAS UNITARIAS PARA VALIDAR EL FUNCIONAMIENTO DE LA CLASE MAZO.
 */
public class MazoTest {

    private Mazo mazo;
    private List<Jugador> jugadores;

    @BeforeEach
    public void setUp() {
        mazo = new Mazo();
        jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Cristian"));
        jugadores.add(new Jugador("Ramiro"));
        jugadores.add(new Jugador("Diego"));
    }

    @Test
    public void testMazoInicialTiene52Cartas() {
        assertEquals(52, mazo.cantidadCartas(), "EL MAZO RECIÉN CREADO DEBE TENER 52 CARTAS.");
    }

    @Test
    public void testRepartir5CartasACadaJugador() {
        mazo.repartir(jugadores, 5);
        assertEquals(5, jugadores.get(0).getMano().size(), "CRISTIAN DEBE TENER 5 CARTAS.");
        assertEquals(5, jugadores.get(1).getMano().size(), "RAMIRO DEBE TENER 5 CARTAS.");
        assertEquals(5, jugadores.get(2).getMano().size(), "DIEGO DEBE TENER 5 CARTAS.");
        assertEquals(37, mazo.cantidadCartas(), "DEBEN QUEDAR 37 CARTAS EN EL MAZO.");
    }

    @Test
    public void testDevolverCartaAlMazo() {
        mazo.repartir(jugadores, 1); // SE REPARTEN 3 CARTAS EN TOTAL (1 A CADA UNO), QUEDAN 49
        Jugador cristian = jugadores.get(0);
        Carta cartaDevuelta = cristian.getMano().get(0);

        cristian.deshacerseDeCarta(cartaDevuelta);
        mazo.agregarCarta(cartaDevuelta); // SE SUMA 1 CARTA DE REGRESO (49 + 1 = 50)

        assertEquals(0, cristian.getMano().size(), "LA MANO DE CRISTIAN DEBE QUEDAR VACÍA.");
        assertEquals(50, mazo.cantidadCartas(), "EL MAZO DEBE TENER 50 CARTAS TRAS LA DEVOLUCIÓN.");
    }

    @Test
    public void testRepresentacionLetrasEspeciales() {
        Carta as = new Carta(1, Figura.CORAZONES);
        Carta rey = new Carta(13, Figura.DIAMANTES);

        assertEquals("AS", as.getValorEnLetra());
        assertEquals("REY", rey.getValorEnLetra());
        assertEquals("[AS de CORAZONES]", as.toString());
    }
}