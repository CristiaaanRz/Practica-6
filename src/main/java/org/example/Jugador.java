package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * REPRESENACION DE UN JUGADOR Y SU MANO DE CARTAS.
 *
 * @author Cristian Ivan Martinez Ruiz
 * @version 1.0
 */
public class Jugador {
    public String nombre;                       // ATRIBUTO PUBLICO POR REQUERIMIENTO DE LA PRACTICA
    private List<Carta> mano;                   // LISTA PRIVADA PARA GUARDAR LAS CARTAS QUIE TIENE EN LA MANO

    /**
     * CONSTRUCTOR DEL JUGADOR.
     * @param nombre NOMBRE DEL JUGADOR.
     */
    //CONSTRUCTOR
    public Jugador(String nombre){
        this.nombre = nombre;
        this.mano = new ArrayList<>();
    }

    /**
     * AGREGA UNA CARTA A LA MANO DEL JUGADOR.
     * @param carta CARTA RECIBIDA.
     */
    //METODO PARA RECIBIR UNA CARTA Y GUARDARLA EN LA MANO
    public void recibirCarta(Carta carta) {
        if (carta != null){
            mano.add(carta);
        }
    }

    /**
     * DESHACE Y REGRESA UNA CARTA ESPECÍFICA DE LA MANO.
     * @param carta CARTA A RETIRAR.
     * @return LA CARTA RETIRADA O NULL SI NO EXISTÍA.
     */
    //METODO PARA DESHACERSE DE UNA CARTA EN LA MANO
    public Carta deshacerseDeCarta(Carta carta){
        if(mano.remove(carta)){                             //REMOVE() BUSCA LA CARTA EN LA LISTA; SI LA ENCUENTRA LA QUITA Y REGRESA TRUE
            return carta;                                   //REGISTRA LA CARTA QUITADA
        }
        return null;                                        //SI NO LA TENIA REGRESA NULL
    }

    /**
     * OBTENER LAS CARTAS EN LA MANO DEL JUGADOR.
     * @return LISTA DE CARTAS.
     */
    //METODO PARA OBTENER LA LISTA DE CARTAS EN MANO
    public List<Carta> getMano(){
        return mano;
    }

    //METODO PARA DEVOLVER LA INFORMACION DEL JUGADOR Y SUS CARTAS EN TEXTO
    public String toString(){
        String resultado = nombre + " tiene: ";
        for (Carta carta : mano){
            resultado += carta.toString() + " ";
        }
        return resultado.trim();
    }
}
