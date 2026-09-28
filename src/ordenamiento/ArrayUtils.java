/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenamiento;

/**
 *
 * @author camilopastu
 */
import java.util.LinkedList;

/**
 * ArrayUtils.java
 *
 * Funciones de apoyo: mostrar el arreglo, mostrar las casillas
 * y verificar que el arreglo quedó ordenado (aserción).
 */
public class ArrayUtils {

    /** Imprime el arreglo en una sola línea (equivale al show() de la plantilla). */
    public static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    /** Imprime el contenido actual de todas las casillas (uso didáctico). */
    public static void showHoles(LinkedList<Integer>[] casillas, int min) {
        System.out.print("   Casillas: ");
        for (int i = 0; i < casillas.length; i++) {
            System.out.print("[" + (i + min) + ": " + casillas[i] + "] ");
        }
        System.out.println();
    }

    /** Verifica que las entradas del arreglo estén en orden no decreciente. */
    public static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) return false;
        }
        return true;
    }
}