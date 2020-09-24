import java.util.HashMap;
import java.util.Map;

public class T4_Exercise7 {
    public static void main(String[] args) {
        Map<Integer, Double> squareMap = generateMap(1000);
        System.out.println(squareMap.get(144));
    }

    public static Map generateMap(int max) {
        Map<Integer, Double> squareMap = new HashMap<Integer, Double>();
        for(int n = 0; n <= max; n++) {
            squareMap.put(n, Math.sqrt(n));
        }
        return squareMap;
    }
}
