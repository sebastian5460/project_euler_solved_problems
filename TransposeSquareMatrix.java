package project_euler;

import java.util.Arrays;
import java.util.Random;

public class TransposeSquareMatrix {
    public static void main(String[] args) {

        int[][] arr = fillSquareMatrix(4);

        System.out.println(Arrays.deepToString(arr));
        transposeSquareMatrix(arr);
        System.out.println(Arrays.deepToString(arr));

        /* int[][] arr = {{1,2,3}, {4,5,6}, {7,8,9}};
        
        System.out.println(Arrays.deepToString(arr));

        transposeSquareMatrix(arr);

        System.out.println(Arrays.deepToString(arr));

        transposeSquareMatrix(arr);
        
        System.out.println(Arrays.deepToString(arr)); */

    }

    public static void transposeSquareMatrix(int[][] matrix){

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }

    public static int[][] fillSquareMatrix(int gridSize){

        Random rd = new Random();
        int[][] myMatrix = new int[gridSize][gridSize];

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                myMatrix[i][j] = rd.nextInt(10);
            }
        }

        return myMatrix;

    }

    

}
