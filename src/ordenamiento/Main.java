/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ordenamiento;
/**
 * Main.java
 *
 * Cliente de prueba: ordena un arreglo de enteros con
 * Pigeonhole.sort() y muestra el resultado.
 */
public class Main {

    public static void main(String[] args) {
        int[] a = {8, 3, 9, 3, 1, 5, 2, 7};

        System.out.println("=== Pigeonhole Sort ===\n");
        Pigeonhole.sort(a);

        System.out.println("\nArreglo final ordenado:");
        ArrayUtils.show(a);

        assert ArrayUtils.isSorted(a) : "¡El arreglo no quedo ordenado!";
        System.out.println("¿Quedo ordenado? " + ArrayUtils.isSorted(a));
    }
}
