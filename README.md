# Simulación de Mazo de Cartas en Java (POO)

Proyecto desarrollado en Java que simula la creación, barajado, reparto y gestión de un mazo de 52 cartas utilizando los principios de la Programación Orientada a Objetos.

## Estructura del Código
* **`Figura.java`**: Enumeración (`enum`) que define los 4 tipos de cartas (`CORAZONES`, `DIAMANTES`, `TREBOLES`, `ESPADAS`).
* **`Carta.java`**: Modela una carta individual con valor numérico y conversión en texto (AS, JOTA, REINA, REY).
* **`Mazo.java`**: Administra la colección de 52 cartas, funciones de barajado (`Collections.shuffle`), reparto y devoluciones.
* **`Jugador.java`**: Modela a cada participante (Cristian, Ramiro, Diego) manteniendo sus cartas en mano.
* **`Juego.java`**: Clase principal con el método `main` para ejecutar la simulación en consola.

## Requisitos de Ejecución
* Java JDK 11 o superior.

## Instrucciones de Compilación y Ejecución (Consola)

1. Compilar los archivos `.java`:
   ```bash
   javac *.java