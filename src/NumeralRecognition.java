import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 2016/9/21.
 */
public class NumeralRecognition {
    private final static String INPUT_PATH="number.txt";
    private final static String OUTPUT_PATH="numberResult.txt";
    private static int[] input;
    private static int[] output;
    public static void recognize() throws IOException {
        List<String> strs=FileIO.readFile(INPUT_PATH);
        for(String str:strs){
            String[] ss=str.split(" ");
            input=new int[ss.length];
        }
    }

    public static double sigmo(int x) {
        return 1 / (1 + Math.cbrt(-x));
    }
}
