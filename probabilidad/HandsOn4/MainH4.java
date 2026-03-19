public class MainH4 {
    public static void main(String[] args) {
        DataSetH4 datos = new DataSetH4();
        datos.imprimirDatos();

        FrequencyTableH4 tabla = new FrequencyTableH4(datos);
        tabla.imprimirTabla();
    }
}