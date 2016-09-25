import java.io.IOException;
import java.util.List;

public class NumeralRecognition {
    private final static String INPUT_PATH = "number.txt";
    private final static String OUTPUT_PATH = "numberResult.txt";
    private double[] input;
    private double[] output;
    private double[] hidden;
    private double[][] weight1;
    private double[][] weight2;

    public void recognize(int inputNum, int hiddenNum, int outputNum) throws IOException {
//        List<String> strs = FileIO.readFile(INPUT_PATH);
//        weight1 = new double[inputNum][hiddenNum];
//        weight2 = new double[hiddenNum][outputNum];
//        input = new double[inputNum];
//        hidden = new double[hiddenNum];
//        output = new double[outputNum];
//        init();
//        for (String str : strs) {
//            String[] ss = str.split(" ");
//            for (int i = 0; i < inputNum; i++) {
//                input[i] = Double.parseDouble(ss[i]);
//            }
//            this.weighting(input,weight1,hidden);
//            this.weighting(hidden,weight2,output);
//
//        }
    }

//    private void weighting(double[] input, double[][] weight, double[] output) {
//        for (int i = 0; i < output.length; i++) {
//            double sum = 0;
//            for (int j = 0; j < input.length; j++) {
//                sum += input[j] * weight[j][i];
//            }
//            output[i] = this.sigmo(sum);
//        }
//    }
//
//    private void init() {
//        for (int i = 0; i < weight1.length; i++) {
//            for (int j = 0; j < weight1[0].length; j++) {
//                weight1[i][j] = Math.random() * 2 - 1;
//            }
//        }
//        for (int i = 0; i < weight2.length; i++) {
//            for (int j = 0; j < weight2[0].length; j++) {
//                weight2[i][j] = Math.random() * 2 - 1;
//            }
//        }
//    }

    public double sigmo(double x) {
        return 1 / (1 + Math.cbrt(-x));
    }
}
