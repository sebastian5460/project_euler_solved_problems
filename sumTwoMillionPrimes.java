package project_euler;

import java.util.function.Supplier;

public class sumTwoMillionPrimes {
    public static void main(String[] args) {

        measureExecutionTime(() -> {System.out.println(sumPrimes(2_000_000));}, "Sum Prime Numbers");
        
    }

    public static long sumPrimes(int size){

        long totalSum = 0L;

        if(size == 2){
            return 2L;
        }

        if(size>2){
            totalSum += 2;
            for(int i=3; i<size; i++){
                if(isPrime(i)){
                    totalSum += i;
                }
            }
        }

        return totalSum;
    }

    public static boolean  isPrime(int num){

        if(num < 2){
            return false; 
        }

        if(num == 2){
            return true;
        }

        if(num%2 == 0){
            return false;
        }

        for(int i=3; i < num; i+= 2){
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }

    public static <T> T measureExecutionTime(Supplier<T> method, String methodName) {
        long startTime = System.nanoTime();
        T result = method.get();
        long endTime = System.nanoTime();
        
        long durationNanos = endTime - startTime;
        double durationMillis = durationNanos / 1_000_000.0;
        
        System.out.printf("%s executed in %.3f ms%n", methodName, durationMillis);
        
        return result;
    }

    public static void measureExecutionTime(Runnable method, String methodName) {
        long startTime = System.nanoTime();
        method.run();
        long endTime = System.nanoTime();
        
        long durationNanos = endTime - startTime;
        double durationMillis = durationNanos / 1_000_000.0;
        
        System.out.printf("%s executed in %.3f ms%n", methodName, durationMillis);
    }

}
