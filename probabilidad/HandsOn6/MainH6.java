public class MainH6 {
    public static void main(String[] args) {
        System.out.println("A  - nublado");
        System.out.println("A' - no nublado");
        System.out.println("B  - llueve");
        System.out.println("B' - no llueve");

        DataSetH6 dataset = new DataSetH6();


        dataset.imprimirTabla();
        System.out.println("");
        System.out.println("");
        dataset.calcularProbabilidades();
    }
}

