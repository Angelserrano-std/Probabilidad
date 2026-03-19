import java.util.Random;

public class DataSetH4 {
    private int[] datos;

    public DataSetH4() {
        datos = new int[40];
        Random random = new Random();

        for (int i = 0; i < datos.length; i++) {
            datos[i] = random.nextInt(100) + 1;
        }
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