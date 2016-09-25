import java.io.IOException;
import java.util.List;

public class BackPropagation {
    private double[] input;
    private double[] output;
    private double[] hidden;
    private double[][] weight1;
    private double[][] weight2;
    private double[] biasWeight1;
    private double[] biasWeight2;
    private double bias1 = 0;
    private double bias2 = 0;

    public void train(String inputPath, String outputPath, int inputNumber, int hiddenNumber,
                      int outputNumber, double[] correct) throws IOException {
        List<String> strs = FileIO.readFile(inputPath);
        weight1 = new double[inputNumber][hiddenNumber];
        weight2 = new double[hiddenNumber][outputNumber];
        input = new double[inputNumber];
        hidden = new double[hiddenNumber];
        output = new double[outputNumber];
        init();
        double r = 0.01;
        for (String str : strs) {
            String[] ss = str.split(" ");
            for (int i = 0; i < inputNumber; i++) {
                input[i] = Double.parseDouble(ss[i]);
            }
            this.weighting(input, bias1, weight1, biasWeight1, hidden);
            this.weighting(hidden, bias2, weight2, biasWeight2, output);
            for (int k = 0; k < output.length; k++) {
                if (Math.abs(correct[k] - output[k]) > 0.5) {
                    for (int h = 0; h < hidden.length; h++) {
                        double delta = r * (correct[k] - output[k]) * output[k] * (1 - output[k]) * hidden[h];
                        weight1[h][k] -= delta;
                    }
                }
            }
        }
    }

    private void weighting(double[] input, double bias, double[][] weight, double[] biasWeight, double[] output) {
        for (int i = 0; i < output.length; i++) {
            double sum = 0;
            for (int j = 0; j < input.length; j++) {
                sum += input[j] * weight[j][i];
            }
            sum += biasWeight[i] * bias;
            output[i] = this.sigmo(sum);
        }
    }

    private void init() {
        for (int i = 0; i < weight1.length; i++) {
            // double sum = 0;
            for (int j = 0; j < weight1[0].length; j++) {
                weight1[i][j] = Math.random() * 2 - 1;
                //  sum += weight1[][i];
            }
//            for (int j = 0; j < weight1.length; j++) {
//                weight1[j][i] /= sum;
//            }

        }
        for (int i = 0; i < weight2.length; i++) {
            //double sum = 0;
            for (int j = 0; j < weight2[0].length; j++) {
                weight2[i][j] = Math.random() * 2 - 1;
            }
//            for (int j = 0; j < weight2.length; j++) {
//                weight2[j][i] /= sum;
//            }
        }
        for (int i = 0; i < biasWeight1.length; i++) {
            biasWeight1[i] = Math.random() * 2 - 1;
        }
        for (int i = 0; i < biasWeight2.length; i++) {
            biasWeight2[i] = Math.random() * 2 - 1;
        }
    }

    public double sigmo(double x) {
        return 1 / (1 + Math.cbrt(-x));
    }
}
