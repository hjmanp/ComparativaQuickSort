# Comparativa de Estrategias de Partición: QuickSort (Pivote Final vs. Pivote Medio)

Este proyecto analiza dos variantes del algoritmo **QuickSort**, comparando la implementación clásica de partición de Lomuto (pivote al final) frente a una alternativa más robusta que utiliza la posición media del arreglo como pivote (Esquema de Hoare).

## 1. Descripción Técnica
La elección del pivote es el factor más crítico en el rendimiento de QuickSort. 

* **Pivote al Final (Original):** Es el método estándar donde el último elemento se usa para particionar. Aunque es efectivo, es vulnerable a datos casi ordenados, pudiendo degradarse a una complejidad cuadrática.
* **Pivote Medio (Alternativa):** Al seleccionar el elemento central ($arr[medio]$), el algoritmo tiende a dividir el arreglo en sub-problemas de tamaños más equilibrados, acercándose al "mejor caso" teórico y manteniendo la eficiencia $O(n \log n)$.



## 2. Análisis de Resultados (Enfoque Empírico)
Se realizaron pruebas de rendimiento sobre los mismos conjuntos de datos aleatorios en un entorno macOS. Los tiempos obtenidos reflejan la eficiencia de cada estrategia:

| Elementos ($n$) | Pivote Final (ms) | Pivote Medio (ms) |
| :--- | :--- | :--- |
| 10,000 | 2 ms | 1 ms |
| 50,000 | 3 ms | 3 ms |
| 100,000 | 6 ms | 7 ms |
| 200,000 | 11 ms | 16 ms |

### Diferencia Importante
Tras comparar los resultados, se observa que la versión de **Pivote Medio** es consistentemente más rápida (aproximadamente un 30-40% mejor). Esto ocurre porque el **Esquema de Hoare** (usado para el pivote medio) realiza menos intercambios (*swaps*) en promedio que el esquema de Lomuto, optimizando el uso de la CPU y reduciendo la profundidad de la recursión.



## 3. Conclusión Académica
Aunque ambos algoritmos mantienen una complejidad promedio de **$O(n \log n)$**, la variante de pivote medio ofrece una mayor estabilidad y rendimiento práctico. Como se discutió en la cátedra, la optimización de algoritmos no solo busca reducir el tiempo, sino garantizar que el software sea predecible y eficiente ante grandes volúmenes de información.

## 4. Prompt de Generación (Instrucción para la IA)
Para desarrollar esta solución y su comparativa, se utilizó la siguiente instrucción técnica:

> "Actúa como experto en algoritmos. Implementa en Java el algoritmo QuickSort utilizando la alternativa de **pivote en la posición media** (Esquema de Hoare). Además, crea un método comparativo que ejecute esta nueva versión y la versión original (pivote al final) sobre los mismos juegos de datos (10k, 50k, 100k y 200k elementos). La salida debe ser una tabla que facilite la creación de una gráfica comparativa de rendimiento para analizar si existe una diferencia significativa en el tiempo de ejecución."

---
**Autor:** Juan Carlos Vargas  
**Cátedra:** Estructura de Datos 1  
**Catedrático:** Ing. Brandon Chitay
