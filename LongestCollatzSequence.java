package project_euler;

public class LongestCollatzSequence {
    public static void main(String[] args) {

        long start = System.nanoTime();

        System.out.println(largestChainCollatzSequence(1_000_000));

        long finish = System.nanoTime();

        System.out.println("Total time: "+(finish-start)/1000000);
        
        /* for (int i = 1; i < 15; i++) {
            System.out.println(collatzSequence(i));
        } */

        
       
    }

    public static long largestChainCollatzSequence(int underNum){

        long largestNumChain = 0;
        long largestChain = 0;
        long temp = 0;

        for(long i=1; i < underNum; i++){

            temp = collatzSequence(i);
            // System.out.println(temp);

            if(temp > largestChain){
                largestChain = temp;
                System.out.printf("New Largest Chain: %d -> %d numbers in chain\n", i, largestChain);
                largestNumChain = i;
            }

        }

        return largestNumChain;

    }

    public static long collatzSequence(long number){

        long counter = 1;

        while (number != 1) {
            
            
            if(number%2 == 0){
                number /= 2;
            }else{
                number = (number*3) + 1;
            }
            counter++;
        }

        return counter;

    }

}
