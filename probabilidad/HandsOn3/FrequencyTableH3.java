public class FrequencyTableH3 {
    private DataSetH3 datos;

    public FrequencyTableH3(DataSetH3 datos) {
        this.datos = datos;
    }

    public void imprimirTabla() {
        int[] lista = datos.getDatos();
        int n = datos.getTamano();

        int[] copia = new int[n];
        for (int i = 0; i < n; i++) {
            copia[i] = lista[i];
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (copia[j] > copia[j + 1]) {
                    int aux = copia[j];
                    copia[j] = copia[j + 1];
                    copia[j + 1] = aux;
                }
            }
        }

        int[] valores = new int[n];
        int[] frecuencia = new int[n];
        int cantidadValores = 0;

        for (int i = 0; i < n; i++) {
            int valorActual = copia[i];
            boolean existe = false;

            for (int j = 0; j < cantidadValores; j++) {
                if (valores[j] == valorActual) {
                    frecuencia[j]++;
                    existe = true;
                    break;
                }
            }

            if (!existe) {
                valores[cantidadValores] = valorActual;
                frecuencia[cantidadValores] = 1;
                cantidadValores++;
            }
        }

        int totalF = 0;
        double totalFr = 0;
        double totalPorcentaje = 0;

        System.out.println("\nTABLA DE FRECUENCIAS");
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-12s %-12s %-12s %-12s%n", "Dato", "f", "fr", "%");
        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < cantidadValores; i++) {
            double fr = (double) frecuencia[i] / n;
            double porcentaje = fr * 100;

            totalF += frecuencia[i];
            totalFr += fr;
            totalPorcentaje += porcentaje;

            System.out.printf("%-12d %-12d %-12.4f %-12.2f%n",
                    valores[i], frecuencia[i], fr, porcentaje);
        }

        System.out.println("------------------------------------------------------------");
        System.out.printf("%-12s %-12d %-12.4f %-12.2f%n",
                "TOTAL", totalF, totalFr, totalPorcentaje);
    }
}