package org.example;
/**
 * REPRESENTACIÓN DE UNA CARTA INDIVIDUAL CON SU VALOR Y SU FIGURA.
 *
 * @author Cristian Ivan Martinez Ruiz
 * @version 1.0
 */

public class Carta {
    //ATRIBUTOS
    private int valor; // VALORES DEL 1 AL 13
    private Figura figura; // Desde nuestro enum viene DIAMANTES, CORAZONES, PICAS Y TREBOLES

    /**
     * CONSTRUCTOR DE LA CARTA.
     *
     * @param valor VALOR NUMÉRICO DE LA CARTA (1 A 13).
     * @param figura TIPO O FIGURA DE LA CARTA (ENUM FIGURA).
     */
    //CONSTRUCTOR
    public Carta(int valor, Figura figura) {
        this.valor = valor;
        this.figura = figura;
    }

    /**
     * OBTENER EL VALOR NUMÉRICO DE LA CARTA.
     * @return VALOR ENTERO DE LA CARTA.
     * OBTENER LA FIGURA O TIPO DE LA CARTA.
     * @return FIGURA DE LA CARTA.
     */
    //GETTERS
    public int getValor() {
        return this.valor;
    }
    public Figura getFigura() {
        return this.figura;
    }

    // METODO PARA TRADUCIR LAS CARTAS 1,11,12,13 A SUS RESPECTIVOS VALORES (A,J,Q,K)
    public String getValorEnLetra(){
        switch (valor){
            case 1: return "AS";
            case 11: return "JOTA";
            case 12: return "REINA";
            case 13: return "REY";
            default: return String.valueOf(valor); // DEL 2 AL 10 DEVUELVE EL MISMO VALOR
        }
    }

    public String toString(){
        return "[" + getValorEnLetra() + " de " + getFigura() + "]";
    }
}


