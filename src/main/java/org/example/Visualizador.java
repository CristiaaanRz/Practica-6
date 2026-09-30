package org.example;

/**
 * Clase de ayuda con método de clase (static) para desplegar cartas gráficamente.
 */

public class Visualizador {
    /**
     * Dibuja la carta dada en las coordenadas indicadas por Posicion
     * @param c Instancia de la clase Carta.
     * @param p Instancia de Posicion con coordenadas (x, y).
     */
    public static void carta(Carta c, Posicion p){
        if (c == null || p ==null) return;

        // 1. MARCO DE LA CARTA
        Square marco = new Square();
        marco.changeSize(84);
        marco.changeColor("black");
        marco.moveHorizontal(-310 + p.getX());
        marco.moveVertical(-120 + p.getY());
        marco.makeVisible();

        // 2. CUERPO DE LA CARTA (FONDO)
        Square fondo = new Square();
        fondo.changeSize(80);
        fondo.changeColor("white");
        fondo.moveHorizontal(-310 + p.getX() + 2);
        fondo.moveVertical(-120 + p.getY() + 2);
        fondo.makeVisible();

        // 3. FIGURA CENTRAL (SÍMBOLO)
        switch (c.getFigura()) {
            case CORAZONES:
                Circle cor = new Circle();
                cor.changeSize(26);
                cor.changeColor("red");
                cor.moveHorizontal(-230 + p.getX() + 27);
                cor.moveVertical(-90 + p.getY() + 42);
                cor.makeVisible();
                break;

            case DIAMANTES:
                Triangle dia = new Triangle();
                dia.changeSize(30, 24);
                dia.changeColor("red");
                dia.moveHorizontal(-210 + p.getX() + 40);
                dia.moveVertical(-140 + p.getY() + 40);
                dia.makeVisible();
                break;

            case PICAS:
                Triangle pic = new Triangle();
                pic.changeSize(30, 24);
                pic.changeColor("black");
                pic.moveHorizontal(-210 + p.getX() + 40);
                pic.moveVertical(-140 + p.getY() + 40);
                pic.makeVisible();
                break;

            case TREBOLES:
                Circle tre = new Circle();
                tre.changeSize(26);
                tre.changeColor("black");
                tre.moveHorizontal(-230 + p.getX() + 27);
                tre.moveVertical(-90 + p.getY() + 42);
                tre.makeVisible();
                break;
        }

        // 4. DIBUJAR EL NÚMERO
        Canvas canvas = Canvas.getCanvas();
        canvas.drawString(c.getValorEnLetra(), p.getX() + 8, p.getY() + 22);

        // 5. Hacer visible la figura en la ventana gráfica
        System.out.println("Carta " + c + " desplegada en la posicion: (" + p.getX() + ", " + p.getY() + ")");
    }
}
