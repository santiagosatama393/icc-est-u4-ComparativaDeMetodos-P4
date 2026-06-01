

import controles.SortPersonaMethods;
import models.Persona;

public class App {
    
    public static Persona[] generarPersonas(int cantidad) {
    Persona[] personas = new Persona[cantidad];

    for (int i = 0; i < cantidad; i++) {
        String nombre = "Persona " + (i + 1);
        int edad = (int) (Math.random() * 101);
        personas[i] = new Persona(nombre, edad);
    }

    return personas;
}
    
    
    public static void main(String[] args) throws Exception {
       int[] tamanios = {10000, 50000, 100000};

        SortPersonaMethods sort = new SortPersonaMethods();

        for (int tam : tamanios) {
            Persona[] personas = generarPersonas(tam);
            Persona[] copiaInsercion = personas.clone();
            Persona[] copiaQuick = personas.clone();
            long inicio = System.nanoTime();
            sort.insertionSort(copiaInsercion);
            long fin = System.nanoTime();
            long tiempoInsercion = fin - inicio;
            inicio = System.nanoTime();
            sort.quickSort(copiaQuick, 0, copiaQuick.length - 1);
            fin = System.nanoTime();
            long tiempoQuick = fin - inicio;

            System.out.println("Desordenado | Insercion | "
                    + tam + " | "
                    + (tiempoInsercion / 1000000.0) + " ms");
            System.out.println("Desordenado | QuickSort | "
                    + tam + " | "
                    + (tiempoQuick / 1000000.0) + " ms");
            System.out.println();
        }
    }

   
    }

    
