public class MainH5 {
    public static void main(String[] args) {
        DataSetH4 datos = new DataSetH4();
        datos.imprimirDatos();

        FrequencyTableH5 tabla = new FrequencyTableH5(datos);
        tabla.construirTabla();
        tabla.imprimirTabla();

        CentralTendencyH5 medidas = new CentralTendencyH5(tabla);
        medidas.imprimirMedidas();
    }
}