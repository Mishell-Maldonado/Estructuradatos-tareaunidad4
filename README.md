**Análisis de Complejidad Algorítmica**

Este proyecto en Java evalúa de forma práctica el rendimiento temporal y espacial de distintos algoritmos de búsqueda, ordenamiento y recursividad sobre un gran volumen de datos (1,000,000 de elementos).

**Estructura del Código**

El sistema está modularizado en las siguientes clases dentro de Visual Studio Code:

Main.java
Controla el menú interactivo y las validaciones mediante try-catch.
MatrixManager.java
Genera la matriz de 1000 x 1000 con datos aleatorios positivos y negativos dentro de un rango acotado.

AlgoritmosOrdenamiento.java
Implementa Merge Sort, Shell Sort, Counting Sort y Radix Sort.
Bubble Sort e Insertion Sort se omiten en arreglos grandes para evitar tiempos excesivos de ejecución.

AlgoritmosBusqueda.java
Contiene las búsquedas Secuencial, Binaria e Interpolación.
Fibonacci.java
Compara la solución recursiva exponencial frente a la optimizada mediante programación dinámica.

**Entorno de Ejecución**
Laptop: ASUS ROG Strix G16
CPU: Intel Core i7-14650HX
RAM: 16 GB DDR5                                                     
Sistema Operativo: Windows 11                 
IDE: Visual Studio Code                                                                                 
Lenguaje: Java SE Development Kit (JDK 17)                                                                                                                  

**Uso**

Compilar y ejecutar Main.java.
Opción 1 (Matriz Desordenada):
Evalúa el tiempo de la búsqueda secuencial.
Las búsquedas Binaria e Interpolación no estarán disponibles hasta ordenar los datos.                                 
Opción 2 (Ordenar):
Ordena el millón de elementos y muestra los tiempos de ejecución de los algoritmos eficientes.                                   
Opción 1 (Matriz Ordenada):
Repite la búsqueda para comparar la diferencia de tiempo entre búsqueda secuencial y búsquedas avanzadas.
Opción 3 (Fibonacci):
Ingresar 45 para observar la diferencia entre la solución recursiva exponencial y la optimizada lineal.

**Objetivo**

El proyecto permite analizar de forma práctica la diferencia entre algoritmos eficientes e ineficientes utilizando la notación Big
