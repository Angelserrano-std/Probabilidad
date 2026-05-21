public class DataSetH6 {

    int nubladoLlueve = 7;
    int noNubladoLlueve = 3;
    int nubladoNoLlueve = 2;
    int noNubladoNoLlueve = 6;

    int total = 18;

    int totalNublado = nubladoLlueve + nubladoNoLlueve;
    int totalNoNublado = noNubladoLlueve + noNubladoNoLlueve;
    int totalLlueve = nubladoLlueve + noNubladoLlueve;
    int totalNoLlueve = nubladoNoLlueve + noNubladoNoLlueve;

    public void calcularProbabilidades() {

        System.out.println("PROBABILIDADES MARGINALES");

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

        double pAB = (double) nubladoLlueve / total;
        double pApB = (double) noNubladoLlueve / total;
        double pABp = (double) nubladoNoLlueve / total;
        double pApBp = (double) noNubladoNoLlueve / total;

        System.out.println("P(A y B) = " + nubladoLlueve + "/" + total + " = " + pAB);
        System.out.println("P(A' y B) = " + noNubladoLlueve + "/" + total + " = " + pApB);
        System.out.println("P(A y B') = " + nubladoNoLlueve + "/" + total + " = " + pABp);
        System.out.println("P(A' y B') = " + noNubladoNoLlueve + "/" + total + " = " + pApBp);

        System.out.println();
        System.out.println("PROBABILIDADES CONDICIONALES");

        double pBDadoA = (double) nubladoLlueve / totalNublado;
        double pBDadoAp = (double) noNubladoLlueve / totalNoNublado;
        double pBpDadoA = (double) nubladoNoLlueve / totalNublado;
        double pBpDadoAp = (double) noNubladoNoLlueve / totalNoNublado;

        double pADadoB = (double) nubladoLlueve / totalLlueve;
        double pADadoBp = (double) nubladoNoLlueve / totalNoLlueve;
        double pApDadoB = (double) noNubladoLlueve / totalLlueve;
        double pApDadoBp = (double) noNubladoNoLlueve / totalNoLlueve;

        System.out.println("P(B | A) = " + nubladoLlueve + "/" + totalNublado + " = " + pBDadoA);
        System.out.println("P(B | A') = " + noNubladoLlueve + "/" + totalNoNublado + " = " + pBDadoAp);
        System.out.println("P(B' | A) = " + nubladoNoLlueve + "/" + totalNublado + " = " + pBpDadoA);
        System.out.println("P(B' | A') = " + noNubladoNoLlueve + "/" + totalNoNublado + " = " + pBpDadoAp);

        System.out.println("P(A | B) = " + nubladoLlueve + "/" + totalLlueve + " = " + pADadoB);
        System.out.println("P(A | B') = " + nubladoNoLlueve + "/" + totalNoLlueve + " = " + pADadoBp);
        System.out.println("P(A' | B) = " + noNubladoLlueve + "/" + totalLlueve + " = " + pApDadoB);
        System.out.println("P(A' | B') = " + noNubladoNoLlueve + "/" + totalNoLlueve + " = " + pApDadoBp);
    }

    public void imprimirTabla() {
        
        System.out.println("TABLA DEL DATASET");
        System.out.println();
        System.out.println();
        System.out.println("                 Nublado     No nublado   Total");
        System.out.println("                 (A)         (A')              ");
        System.out.println();
        System.out.println("Llueve (B)       " + nubladoLlueve + "           " + noNubladoLlueve + "            " + totalLlueve);
        System.out.println("No llueve (B')   " + nubladoNoLlueve + "           " + noNubladoNoLlueve + "            " + totalNoLlueve);
        System.out.println();
        System.out.println("Total            " + totalNublado + "           " + totalNoNublado + "            " + total);

    }
}