public class FrequencyTableH5 {
    private DataSetH4 datos;
    private int numeroClases;
    private int amplitud;
    private int[] limitesInferiores;
    private int[] limitesSuperiores;
    private int[] frecuencia;
    private int[] frecuenciaAcumulada;
    private double[] puntoMedio;
    private double[] frecuenciaRelativa;
    private double[] frecuenciaRelativaAcumulada;
    private double[] porcentaje;

    public FrequencyTableH5(DataSetH4 datos) {
        this.datos = datos;
    }

    public void construirTabla() {
        int[] lista = datos.getDatos();
        int n = datos.getTamano();

        int minimo = lista[0];
        int maximo = lista[0];

        for (int i = 1; i < n; i++) {
            if (lista[i] < minimo) {
                minimo = lista[i];
            }
            if (lista[i] > maximo) {
                maximo = lista[i];
            }
        }

        int rango = maximo - minimo;
        numeroClases = (int) Math.ceil(1 + 3.322 * Math.log10(n));
        amplitud = (int) Math.ceil((double) (rango + 1) / numeroClases);

        limitesInferiores = new int[numeroClases];
        limitesSuperiores = new int[numeroClases];
        frecuencia = new int[numeroClases];
        puntoMedio = new double[numeroClases];
        frecuenciaAcumulada = new int[numeroClases];
        frecuenciaRelativa = new double[numeroClases];
        frecuenciaRelativaAcumulada = new double[numeroClases];
        porcentaje = new double[numeroClases];

        int li = minimo;

        for (int i = 0; i < numeroClases; i++) {
            int ls = li + amplitud - 1;

            limitesInferiores[i] = li;
            limitesSuperiores[i] = ls;
            puntoMedio[i] = (li + ls) / 2.0;

            li = ls + 1;
        }

        for (int i = 0; i < n; i++) {
            int valor = lista[i];

            for (int j = 0; j < numeroClases; j++) {
                if (valor >= limitesInferiores[j] && valor <= limitesSuperiores[j]) {
                    frecuencia[j]++;
                    break;
                }
            }
        }

        int acumulada = 0;
        double acumuladaRelativa = 0;

        for (int i = 0; i < numeroClases; i++) {
            acumulada += frecuencia[i];
            frecuenciaAcumulada[i] = acumulada;

            frecuenciaRelativa[i] = (double) frecuencia[i] / n;
            acumuladaRelativa += frecuenciaRelativa[i];
            frecuenciaRelativaAcumulada[i] = acumuladaRelativa;

            porcentaje[i] = frecuenciaRelativa[i] * 100;
        }
    }

    public void imprimirTabla() {
        int totalF = 0;
        double totalFr = 0;
        double totalPorcentaje = 0;

        System.out.println("\nTABLA DE FRECUENCIAS AGRUPADAS");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.printf("%-8s %-15s %-8s %-10s %-8s %-10s %-10s %-10s%n",
                "Clase", "Limite", "f", "Xc", "Fa", "fr", "fra", "%");
        System.out.println("------------------------------------------------------------------------------------------------");

        for (int i = 0; i < numeroClases; i++) {
            totalF += frecuencia[i];
            totalFr += frecuenciaRelativa[i];
            totalPorcentaje += porcentaje[i];

            System.out.printf("%-8d %-15s %-8d %-10.2f %-8d %-10.4f %-10.4f %-10.2f%n",
                    i + 1,
                    limitesInferiores[i] + " - " + limitesSuperiores[i],
                    frecuencia[i],
                    puntoMedio[i],
                    frecuenciaAcumulada[i],
                    frecuenciaRelativa[i],
                    frecuenciaRelativaAcumulada[i],
                    porcentaje[i]);
        }

        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.printf("%-23s %-8d %-10s %-8s %-10.4f %-10s %-10.2f%n",
                "TOTAL", totalF, "", "", totalFr, "", totalPorcentaje);
    }

    public int getNumeroClases() {
        return numeroClases;
    }

    public int getAmplitud() {
        return amplitud;
    }

    public int getTamanoMuestra() {
        return datos.getTamano();
    }

    public int[] getLimitesInferiores() {
        return limitesInferiores;
    }

    public int[] getFrecuencia() {
        return frecuencia;
    }

    public int[] getFrecuenciaAcumulada() {
        return frecuenciaAcumulada;
    }

    public double[] getPuntoMedio() {
        return puntoMedio;
    }
}