public class CentralTendencyH5 {
    private FrequencyTableH5 tabla;

    public CentralTendencyH5(FrequencyTableH5 tabla) {
        this.tabla = tabla;
    }

    public double calcularMedia() {
        double suma = 0;

        for (int i = 0; i < tabla.getNumeroClases(); i++) {
            suma += tabla.getFrecuencia()[i] * tabla.getPuntoMedio()[i];
        }

        return suma / tabla.getTamanoMuestra();
    }

    public double calcularMediana() {
        int n = tabla.getTamanoMuestra();
        double nSobreDos = n / 2.0;

        int claseMediana = 0;

        for (int i = 0; i < tabla.getNumeroClases(); i++) {
            if (tabla.getFrecuenciaAcumulada()[i] >= nSobreDos) {
                claseMediana = i;
                break;
            }
        }

        double lm = tabla.getLimitesInferiores()[claseMediana];
        int faAnterior = 0;

        if (claseMediana > 0) {
            faAnterior = tabla.getFrecuenciaAcumulada()[claseMediana - 1];
        }

        int fm = tabla.getFrecuencia()[claseMediana];
        int a = tabla.getAmplitud();

        return lm + ((nSobreDos - faAnterior) / (double) fm) * a;
    }

    public double calcularModa() {
        int claseModal = 0;
        int frecuenciaMayor = tabla.getFrecuencia()[0];

        for (int i = 1; i < tabla.getNumeroClases(); i++) {
            if (tabla.getFrecuencia()[i] > frecuenciaMayor) {
                frecuenciaMayor = tabla.getFrecuencia()[i];
                claseModal = i;
            }
        }

        double lm = tabla.getLimitesInferiores()[claseModal];
        int fm = tabla.getFrecuencia()[claseModal];

        int fAnterior = 0;
        if (claseModal > 0) {
            fAnterior = tabla.getFrecuencia()[claseModal - 1];
        }

        int fSiguiente = 0;
        if (claseModal < tabla.getNumeroClases() - 1) {
            fSiguiente = tabla.getFrecuencia()[claseModal + 1];
        }

        int d1 = fm - fAnterior;
        int d2 = fm - fSiguiente;
        int a = tabla.getAmplitud();

        if (d1 + d2 == 0) {
            return lm;
        }

        return lm + ((double) d1 / (d1 + d2)) * a;
    }

    public void imprimirMedidas() {
        System.out.println("\nMEDIDAS DE TENDENCIA CENTRAL");
        System.out.printf("Media: %.2f%n", calcularMedia());
        System.out.printf("Mediana: %.2f%n", calcularMediana());
        System.out.printf("Moda: %.2f%n", calcularModa());
    }
}