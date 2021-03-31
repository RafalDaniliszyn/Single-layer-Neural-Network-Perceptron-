package pl.rafal;

import java.util.Random;

public class NeuralNetwork {

    Random random = new Random();
    double[] w;
    double bias;
    double learningRate;

    public NeuralNetwork(int inputLength, double learningRate) {

        //set learning rate
        this.learningRate = learningRate;

        this.w = new double[inputLength];

        //set random weights between -0.5, 0.5
        for (int i = 0; i < w.length; i++) {
            this.w[i] = random.nextDouble() - 0.5;
        }

        //set random bias
        this.bias = random.nextDouble();
    }


    //unit step activation function
    private int activation(double y){
        if (y >=0 )return 1;
        else return 0;
    }

    public int feedForward(int[] input){

        //y is output
        double y = 0;

        //combination of input and weight
        for (int i = 0; i < input.length; i++) {
            y = y + input[i] * this.w[i];
        }

        //adding bias
        y += bias;

        return activation(y);
    }


    //function to train network
    public void training(int[][] trainingInput, int[] expect){

        //how many times to repeat the training
        for (int i = 0; i < 1000; i++) {

            for (int j = 0; j < trainingInput.length; j++) {

                //checking how big the error is
                double error = expect[j] - feedForward(trainingInput[j]);

                if (error != 0){

                    //updating weights and bias
                    for (int k = 0; k < this.w.length; k++) {
                        this.w[k] = w[k] + learningRate * error * trainingInput[j][k];
                        this.bias = bias + learningRate * error;
                    }
                }
            }
        }
    }


}
