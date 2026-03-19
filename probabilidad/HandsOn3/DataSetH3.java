public class DataSetH3 {
    private int[] datos;

    public DataSetH3() {
        datos = new int[]{2, 5, 2, 8, 1, 5, 3, 2, 7, 8, 1, 4, 6, 6, 5, 3, 2, 9, 10, 5};
    }

    public int[] getDatos() {
        return datos;
    }

    public int getTamano() {
        return datos.length;
    }

    public void imprimirDatos() {
        System.out.print("Muestra de datos: ");
        for (int i = 0; i < datos.length; i++) {
            System.out.print(datos[i] + " ");
        }
        System.out.println();
    }
}