public class Sumatorias {
    
    public static int sumX(Dataset data){
        int rst = 0;
        for (int i = 0; i < Dataset.SIZE; i++){
            rst += data.x[i];
        }
        return rst;
    }

    public static int sumY(Dataset data){
        int rst = 0;
        for (int i = 0; i < Dataset.SIZE; i++){
            rst += data.y[i];
        }
        return rst;
    }

    public static int sumX2(Dataset data) {
        int rst = 0;
        for (int i = 0; i < Dataset.SIZE; i++) {
            rst += data.x[i] * data.x[i];
        }
        return rst;
    }

    public static int sumXY(Dataset data) {
        int rst = 0;
        for (int i = 0; i < Dataset.SIZE; i++) {
            rst += data.x[i] * data.y[i];
        }
        return rst;
    }

}
