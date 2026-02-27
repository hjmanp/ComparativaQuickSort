import java.util.Random;
import java.util.Arrays;

public class ComparativaQuickSort {

    // --- VERSIÓN A: PIVOTE AL FINAL (Original) ---
    public static void quickSortFinal(int[] arr, int bajo, int alto) {
        if (bajo < alto) {
            int pi = particionFinal(arr, bajo, alto);
            quickSortFinal(arr, bajo, pi - 1);
            quickSortFinal(arr, pi + 1, alto);
        }
    }

    private static int particionFinal(int[] arr, int bajo, int alto) {
        int pivote = arr[alto]; 
        int i = (bajo - 1);
        for (int j = bajo; j < alto; j++) {
            if (arr[j] <= pivote) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[alto];
        arr[alto] = temp;
        return i + 1;
    }

    // --- VERSIÓN B: PIVOTE AL MEDIO (Alternativa solicitada) ---
    public static void quickSortMedio(int[] arr, int bajo, int alto) {
        if (bajo < alto) {
            int pi = particionMedio(arr, bajo, alto);
            quickSortMedio(arr, bajo, pi);
            quickSortMedio(arr, pi + 1, alto);
        }
    }

    private static int particionMedio(int[] arr, int bajo, int alto) {
        // Seleccionamos el elemento central como pivote
        int pivote = arr[bajo + (alto - bajo) / 2];
        int i = bajo - 1;
        int j = alto + 1;

        while (true) {
            do { i++; } while (arr[i] < pivote);
            do { j--; } while (arr[j] > pivote);
            if (i >= j) return j;
            
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] escenarios = {10000, 50000, 100000, 200000};
        
        System.out.println("\n--- COMPARATIVA DE RENDIMIENTO QUICKSORT ---");
        System.out.println("n\t\t| Pivote Final (ms)\t| Pivote Medio (ms)");
        System.out.println("-----------------------------------------------------------");

        for (int n : escenarios) {
            int[] datosOriginal = generarArregloAleatorio(n);
            int[] datosCopia = Arrays.copyOf(datosOriginal, datosOriginal.length);

            // Prueba Pivote Final
            long inicioF = System.currentTimeMillis();
            quickSortFinal(datosOriginal, 0, datosOriginal.length - 1);
            long finF = System.currentTimeMillis();

            // Prueba Pivote Medio
            long inicioM = System.currentTimeMillis();
            quickSortMedio(datosCopia, 0, datosCopia.length - 1);
            long finM = System.currentTimeMillis();

            System.out.println(n + "\t\t| " + (finF - inicioF) + "\t\t\t| " + (finM - inicioM));
        }
        System.out.println("-----------------------------------------------------------\n");
    }

    private static int[] generarArregloAleatorio(int n) {
        Random rd = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = rd.nextInt(1000000);
        return arr;
    }
}