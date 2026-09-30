# Práctica 6 - Visualizador Gráfico de Cartas

**Autor:** Cristian Ivan Martinez Ruiz  
**Materia:** Programación Orientada a Objetos

## Descripción
Esta práctica extiende el modelo de cartas de la Práctica 5 agregando una interfaz gráfica. Se implementaron las clases `Posicion` y `Visualizador` para componer y renderizar visualmente objetos `Carta` en una ventana `Canvas` utilizando figuras geométricas básicas (`Square`, `Circle`, `Triangle`).

## Estructura del Proyecto
- `Carta.java`: Modelo de la carta (valor y figura).
- `Posicion.java`: Manejo de coordenadas (X, Y).
- `Visualizador.java`: Método de clase estático `carta(Carta c, Posicion p)` para el despliegue gráfico.
- `Canvas.java`, `Square.java`, `Circle.java`, `Triangle.java`: Librería gráfica de terceros integrada.
- `Main.java`: Clase principal de prueba que despliega las 4 cartas en pantalla.

## Ejecución
Ejecutar la clase `Main.java` desde IntelliJ para abrir la ventana gráfica y observar el despliegue de las cartas.