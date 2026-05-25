public class DataSetH6 {


    int[][] datos = {
        {7, 3},
        {2, 6}
    };

    String[] filas = {"Llueve (B)", "No llueve (B')"};
    String[] columnas = {"Nublado (A)", "No nublado (A')"};

    public int totalGeneral() {
        int total = 0;

        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[i].length; j++) {
                total = total + datos[i][j];
            }
        }

        return total;
    }

    public int totalFila(int fila) {
        int total = 0;

        for (int j = 0; j < datos[fila].length; j++) {
            total = total + datos[fila][j];
        }

        return total;
    }

    public int totalColumna(int columna) {
        int total = 0;

        for (int i = 0; i < datos.length; i++) {
            total = total + datos[i][columna];
        }

        return total;
    }

    public void imprimirTabla() {
        System.out.println("TABLA DEL DATASET");
        System.out.println();

        System.out.println("                 Nublado     No nublado   Total");
        System.out.println("                 (A)         (A')");
        System.out.println();
        for (int i = 0; i < datos.length; i++) {
            System.out.println(filas[i] + "       " + datos[i][0] + "           " + datos[i][1] + "            " + totalFila(i));
        }

        System.out.println();
        System.out.println("Total            " + totalColumna(0) + "           " + totalColumna(1) + "            " + totalGeneral());

    }

    public void calcularProbabilidades() {
        int total = totalGeneral();

        int totalNublado = totalColumna(0);
        int totalNoNublado = totalColumna(1);
        int totalLlueve = totalFila(0);
        int totalNoLlueve = totalFila(1);

        System.out.println();
        System.out.println("PROBABILIDADES MARGINALES");
        System.out.println();

        double pA = (double) totalNublado / total;
        double pAp = (double) totalNoNublado / total;
        double pB = (double) totalLlueve / total;
        double pBp = (double) totalNoLlueve / total;

        System.out.println("P(A) = " + totalNublado + "/" + total + " = " + pA);
        System.out.println("P(A') = " + totalNoNublado + "/" + total + " = " + pAp);
        System.out.println("P(B) = " + totalLlueve + "/" + total + " = " + pB);
        System.out.println("P(B') = " + totalNoLlueve + "/" + total + " = " + pBp);

        System.out.println();
        System.out.println("PROBABILIDADES CONJUNTAS");
        System.out.println();

        double pAB = (double) datos[0][0] / total;
        double pApB = (double) datos[0][1] / total;
        double pABp = (double) datos[1][0] / total;
        double pApBp = (double) datos[1][1] / total;

        System.out.println("P(A y B) = " + datos[0][0] + "/" + total + " = " + pAB);
        System.out.println("P(A' y B) = " + datos[0][1] + "/" + total + " = " + pApB);
        System.out.println("P(A y B') = " + datos[1][0] + "/" + total + " = " + pABp);
        System.out.println("P(A' y B') = " + datos[1][1] + "/" + total + " = " + pApBp);

        System.out.println();
        System.out.println("PROBABILIDADES CONDICIONALES");
        System.out.println();

        double pBDadoA = (double) datos[0][0] / totalNublado;
        double pBDadoAp = (double) datos[0][1] / totalNoNublado;
        double pBpDadoA = (double) datos[1][0] / totalNublado;
        double pBpDadoAp = (double) datos[1][1] / totalNoNublado;

        double pADadoB = (double) datos[0][0] / totalLlueve;
        double pApDadoB = (double) datos[0][1] / totalLlueve;
        double pADadoBp = (double) datos[1][0] / totalNoLlueve;
        double pApDadoBp = (double) datos[1][1] / totalNoLlueve;

        System.out.println("P(B | A) = " + datos[0][0] + "/" + totalNublado + " = " + pBDadoA);
        System.out.println("P(B | A') = " + datos[0][1] + "/" + totalNoNublado + " = " + pBDadoAp);
        System.out.println("P(B' | A) = " + datos[1][0] + "/" + totalNublado + " = " + pBpDadoA);
        System.out.println("P(B' | A') = " + datos[1][1] + "/" + totalNoNublado + " = " + pBpDadoAp);

        System.out.println("P(A | B) = " + datos[0][0] + "/" + totalLlueve + " = " + pADadoB);
        System.out.println("P(A' | B) = " + datos[0][1] + "/" + totalLlueve + " = " + pApDadoB);
        System.out.println("P(A | B') = " + datos[1][0] + "/" + totalNoLlueve + " = " + pADadoBp);
        System.out.println("P(A' | B') = " + datos[1][1] + "/" + totalNoLlueve + " = " + pApDadoBp);
    }
}
