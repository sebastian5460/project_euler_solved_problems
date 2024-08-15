package project_euler;

import java.util.Arrays;

public class LatticePath{

    public static void main(String[] args){

        long start = System.nanoTime();
        System.out.printf(String.format("%,d\n",computePaths(20)).replace(",", "."));
        long finish = System.nanoTime();

        System.out.printf("Total execution time: %,d ms\n",((finish - start)/1000000));

    }

    public static long computePaths(int sizeGrid){

        long[][] gridValues = new long[sizeGrid][sizeGrid];
        long temp;
        long totalSum = 1L;

        transposeSquareMatrix(gridValues);

        Arrays.fill(gridValues[sizeGrid - 1], 1);

        transposeSquareMatrix(gridValues);

        for (int i = sizeGrid - 1; i > 0; i--) {
            
            temp = 0;
            for (int j = 0; j < sizeGrid; j++) {
                temp += gridValues[j][i];
            }
            for (int j = 0; j < sizeGrid; j++) {
                if(j==0){
                    gridValues[j][i-1] = temp;
                    continue;
                }
                gridValues[j][i-1] = gridValues[j-1][i-1] - gridValues[j-1][i];
                
            }
            
            
        }
        
        System.out.println(Arrays.deepToString(gridValues));
        for (long[] ls : gridValues) {
            for (long ls2 : ls) {
                // System.out.println(ls2);
                totalSum += ls2;
            }
        }
        return  totalSum;

    }

    public static void transposeSquareMatrix(long[][] arr){

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1 ; j < arr.length; j++) {
                long temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

    }

}