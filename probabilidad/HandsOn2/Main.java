import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Dataset data = new Dataset();
        int n = Dataset.SIZE;

        int sumX  = DiscretheMaths.sumX(data);
        int sumY  = DiscretheMaths.sumY(data);
        int sumX2 = DiscretheMaths.sumX2(data);
        int sumXY = DiscretheMaths.sumXY(data);

        System.out.println("Dataset:");
        System.out.println("x\t y");

        for (int i = 0; i < Dataset.SIZE; i++) {
            System.out.println(data.x[i] + "\t " + data.y[i]);
        }
        System.out.println("-----------------------------");
        System.out.println("n = " + n);
        System.out.println("sumatoria X = " + sumX);
        System.out.println("sumatoria Y = " + sumY);
        System.out.println("sumatoria X^2 = " + sumX2);
        System.out.println("sumatoria XY = " + sumXY);

        
        int DS = n * sumX2 - (sumX * sumX);


        double B1 = (double)(n * sumXY - (sumX * sumY)) / DS;
        double B0 = (double)(sumY * sumX2 - sumX * sumXY) / DS;

        System.out.println("DS = " + DS);
        System.out.println("B1 = " + B1);
        System.out.println("B0 = " + B0);
        System.out.println();
        System.out.println("Modelo: Y = B0 + B1 X");
        System.out.println("Y = " + B0 + " + " + B1 + "X");
        


        System.out.println("\nPredicciones de Sales:");

        

        System.out.println("nuevo advertising  x = " + Arrays.toString(data.advertising));

        System.out.println("advertising" + "\t"  + "sales predictaas");


        for (int i = 0; i < data.advertising.length; i++) {

            double sales = B0 + B1 * data.advertising[i];

            System.out.println(data.advertising[i] + "\t        "  + sales);
        }
    }
}
