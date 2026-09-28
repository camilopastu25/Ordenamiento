/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenamiento;

import java.util.LinkedList;

/**
 * Pigeonhole.java
 *
 * Contiene únicamente el algoritmo Pigeonhole Sort.
 *
 * Pigeonhole Sort NO es un algoritmo de comparación (no usa
 * Comparable/less()/exch()): usa el valor de cada elemento como
 * índice de una "casilla" (pigeonhole), por lo que ordena int[].
 *
 * Complejidad: O(n + rango), con rango = max - min + 1.
 * Memoria extra: O(n + rango) -> no ordena en su sitio.
 */
public class Pigeonhole {

    /** Si es true, sort() imprime el estado del proceso paso a paso. */
    private static boolean verbose = true;

    public static void setVerbose(boolean v) {
        verbose = v;
    }

    /** Ordena el arreglo "a" usando Pigeonhole Sort. */
    public static void sort(int[] a) {
        if (a.length == 0) return;

        // 1) Encontrar el menor y el mayor valor (definen el rango de casillas)
        int min = a[0], max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) min = a[i];
            if (a[i] > max) max = a[i];
        }
        int rango = max - min + 1;

        if (verbose) {
            System.out.println("Arreglo inicial:");
            ArrayUtils.show(a);
            System.out.println("min = " + min + ", max = " + max +
                    "  ->  se crean " + rango + " casillas (pigeonholes)");
            System.out.println();
        }

        // 2) Crear las casillas (una lista por cada valor posible entre min y max)
        LinkedList<Integer>[] casillas = buildHoles(rango);

        // 3) Distribuir: cada elemento va a la casilla (valor - min)
        for (int i = 0; i < a.length; i++) {
            int indiceCasilla = a[i] - min;
            casillas[indiceCasilla].add(a[i]);
            if (verbose) {
                System.out.println("Colocando a[" + i + "] = " + a[i] +
                        "  en la casilla " + indiceCasilla +
                        " (valor " + (indiceCasilla + min) + ")");
                ArrayUtils.showHoles(casillas, min);
            }
        }
        if (verbose) {
            System.out.println("Distribución terminada. Ahora se recorren las");
            System.out.println("casillas en orden y se copian de vuelta al arreglo.\n");
        }

        // 4) Recolectar: recorrer las casillas en orden y volcarlas en el arreglo
        collect(a, casillas);
    }

    /** Crea el arreglo de casillas vacías, una por cada valor posible del rango. */
    @SuppressWarnings("unchecked")
    private static LinkedList<Integer>[] buildHoles(int rango) {
        LinkedList<Integer>[] casillas = new LinkedList[rango];
        for (int i = 0; i < rango; i++) {
            casillas[i] = new LinkedList<>();
        }
        return casillas;
    }

    /** Recorre las casillas en orden y copia sus valores de vuelta en "a". */
    private static void collect(int[] a, LinkedList<Integer>[] casillas) {
        int pos = 0;
        for (int c = 0; c < casillas.length; c++) {
            for (int valor : casillas[c]) {
                a[pos] = valor;
                pos++;
                if (verbose) {
                    System.out.println("Copiando " + valor + " de la casilla " + c +
                            " -> a[" + (pos - 1) + "]");
                    ArrayUtils.show(a);
                }
            }
        }
    }
    
}