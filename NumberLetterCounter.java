package project_euler;

public class NumberLetterCounter {
    
    public static void main(String[] args) {
        
        int[] numsToNine = {0,3,3,5,4,4,3,5,5,4};
        int[] numsTens = {3,6,6,5,5,5,7,6,6};
        int[] numsElevenToNineTeen = {6,6,8,8,7,7,9,8,8};
        int[] numsHundreds = {7,10,11}; // hundred, hundred and, one thousand
        int totalNums = 0;

        for (int i = 0; i < numsToNine.length; i++) {
            // sum of the numbers 0-99 x 10 times (hundreds words left)
            totalNums += sumFirstHundred(numsTens, numsToNine, numsElevenToNineTeen);
        }

        
        // adding the hundreds words left
        for(int i=1; i < numsToNine.length; i++){

            totalNums += numsToNine[i];
            totalNums += numsHundreds[0];
            
            for (int j = 1; j < 100; j++) {
                totalNums += numsToNine[i];
                totalNums += numsHundreds[1];
            }
        }

        // adding one thousand word
        totalNums += numsHundreds[2];

        System.out.println(totalNums);
        
    }

    public static int sumFirstHundred(int[] tens, int[] toNine, int[] numsElevenToNineTeen){
        
        int totalNums = 0;

        // first ten numbers sum
        for(int i=1; i < toNine.length; i++){
            totalNums += toNine[i];
        }

        // sum from 11 to 19
        for(int i=0; i < numsElevenToNineTeen.length; i++){
            totalNums += numsElevenToNineTeen[i];
        }

        // sum ten
        totalNums += 3;

        // sum from 20 to 99
        for(int i=1; i < tens.length; i++){
            for (int j = 0; j < toNine.length; j++) {
                totalNums += tens[i];
                totalNums += toNine[j];
            }
        }
        return totalNums;
    }

}
