package pl.rafal;

public class Main {

    public static void main(String[] args) {

        //test
	    NeuralNetwork neuralNetwork = new NeuralNetwork(4, 0.1);
	    int[][] trainingInput = new int[][]{
	            {1,0,0,0},
                {0,1,0,0},
                {0,0,1,0},
                {0,0,0,1},
                {1,1,1,1},
                {0,0,0,0},
                {1,1,1,1},
                {1,1,1,0},
                {1,1,0,1},
                {1,0,1,1},
                {0,1,1,1},
                {1,1,1,1}

	    };

        int[] expect = new int[]{0,0,0,0,1,0,1,0,0,0,0,1};

        neuralNetwork.training(trainingInput, expect);

        int input[] = new int[]{1,1,1,1};

        System.out.println(neuralNetwork.feedForward(input));

        input = new int[]{0,1,0,0};
        System.out.println(neuralNetwork.feedForward(input));

        input = new int[]{0,1,1,1};
        System.out.println(neuralNetwork.feedForward(input));

        input = new int[]{1,1,1,1};
        System.out.println(neuralNetwork.feedForward(input));
    }
}
