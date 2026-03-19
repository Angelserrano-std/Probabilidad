public class MainH3 {
    public static void main(String[] args) {
        DataSetH3 datos = new DataSetH3();
        datos.imprimirDatos();

        FrequencyTableH3 tabla = new FrequencyTableH3(datos);
        tabla.imprimirTabla();
    }
}