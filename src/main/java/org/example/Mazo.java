package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// DEBE CREARSE EN ORDEN PERO PARA INICIAR EL JUEGO DEBEN SER REVUELTAS
// PUEDE USARSE UN METODO ESTATICO
//Collection shuffle()

/**
 * CLASE QUE ADMINISTRA LA COLECCIÓN Y OPERACIONES DEL MAZO DE CARTAS.
 *
 * @author Cristian Ivan Martinez Ruiz
 * @version 1.0
 */
public class Mazo {
    private List<Carta> cartas;

    /**
     * CONSTRUCTOR QUE INICIALIZA EL MAZO CON 52 CARTAS.
     */
    public Mazo(){                                           //SE CREA LA LISTA Y SE LLENA
        this.cartas = new ArrayList<>();
        restablecerMazo();                                   //LLENAMOS EL MAZO CON 52 CARTAS
    }

    /**
     * LLENA EL MAZO CON LAS 52 COMBINACIONES DE FIGURAS Y VALORES.
     */
    // METODO PARA LLENAR O RESTABLECER EL MAZO A 52 CARTAS
    public void restablecerMazo(){
        cartas.clear();                                      //LIMPIAMOS LA LISTA POR SI HABIA CARTAS ANTES
        for (Figura figura : Figura.values()) {              //RECORREMOS LAS 4 FIGURAS
            for (int valor = 1; valor <= 13; valor++) {      //PARA CADA FIGURA CREAMOS VALORES DEL 1 AL 13
                cartas.add(new Carta(valor, figura));
            }
        }
    }

    /**
     * MEZCLA ALEATORIAMENTE LAS CARTAS DEL MAZO.
     */
    // METODO PARA BARAJAR LAS CARTAS
    public void barajar() {
        Collections.shuffle(cartas);
    }

    /**
     * REMUEVE Y RETORNA LA CARTA SUPERIOR DEL MAZO.
     * @return CARTA EXTRAÍDA O NULL SI ESTÁ VACÍO.
     */
    // METODO PARA QUITAR Y OBTENER LA CARTA HASTA ARRIBA DEL MAZO
    public Carta quitarCarta(){
        if (!cartas.isEmpty()){
            return cartas.remove(0);
        }
        return null;                                        //SI SE ACABARON LAS CARTAS
    }

    /**
     * AGREGA UNA CARTA DE REGRESO AL FINAL DEL MAZO.
     * @param carta CARTA A AGREGAR.
     */
    public void agregarCarta(Carta carta){
        if (carta != null){
            cartas.add(carta);                              // AL FINAL DEL MAZO
        }
    }

    /**
     * REPARTE UNA CANTIDAD DE CARTAS ESPECÍFICA A CADA JUGADOR.
     * @param jugadores LISTA DE JUGADORES RECEPTORES.
     * @param cartasPorJugador CANTIDAD DE CARTAS A ENTREGAR A CADA UNO.
     */
    //METODO PARA REPARTIR UN NUMERO DE CARTAS A UNA LISTA DE JUGADORES
    public void repartir(List<Jugador> jugadores, int cartasPorJugador) {
        for (int i = 0; i < cartasPorJugador; i++) {
            for (Jugador jugador : jugadores){
                Carta cartaTomada = quitarCarta();
                if (cartaTomada != null) {
                    jugador.recibirCarta(cartaTomada);
                }else {
                    System.out.println("!Se acabaron las cartas del mazo!");
                }
            }
        }
    }

    /**
     * RETORNA LA CANTIDAD DE CARTAS RESTANTES EN EL MAZO.
     * @return NÚMERO DE CARTAS.
     */
    //METODO PARA SABER CUANTAS CARTAS QUEDAN SIN REPARTIR
    public int cantidadCartas() {
        return cartas.size();
    }

    /**
     * OBTENER LA LISTA DE CARTAS DEL MAZO.
     * @return LISTA DE CARTAS.
     */
    //PARA OBTENER LA LISTA DE CARTAS ACTUALES
    public List<Carta> getCartas() {
        return cartas;
    }
}