package controles;

import models.Persona;

public class SortPersonaMethods {

    public void insertionSort(Persona[] personas) {
        for (int i = 1; i < personas.length; i++) {
            Persona actual = personas[i];
            int j = i - 1;

            while (j >= 0 && personas[j].getCriterioOrdenamiento() > actual.getCriterioOrdenamiento()) {
                personas[j + 1] = personas[j];
                j--;
            }

            personas[j + 1] = actual;
        }
    }

    public void quickSort(Persona[] personas, int inicio, int fin) {
        if (inicio < fin) {
            int indiceParticion = particionar(personas, inicio, fin);

            quickSort(personas, inicio, indiceParticion - 1);
            quickSort(personas, indiceParticion, fin);
        }
    }

    private int particionar(Persona[] personas, int inicio, int fin) {
        int pivote = personas[inicio + (fin - inicio) / 2].getCriterioOrdenamiento();

        int i = inicio;
        int j = fin;

        while (i <= j) {
            while (personas[i].getCriterioOrdenamiento() < pivote) {
                i++;
            }

            while (personas[j].getCriterioOrdenamiento() > pivote) {
                j--;
            }

            if (i <= j) {
                intercambiar(personas, i, j);
                i++;
                j--;
            }
        }

        return i;
    }

    private void intercambiar(Persona[] personas, int i, int j) {
        Persona aux = personas[i];
        personas[i] = personas[j];
        personas[j] = aux;
    }
}