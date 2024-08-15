package project_euler;

import java.util.function.Supplier;

public class summPrimesEratosthenes {
    public static void main(String[] args) {
        // System.out.println(sumPrimes(2_000_000));

        measureExecutionTime(() -> {System.out.println(sumPrimes(10_000));}, "Sum Prime Numbers");
    }

    public static long sumPrimes(int size) {
        if(size <= 2){
            return size == 2 ? 2 : 0;
        }

        boolean[] isComposite = new boolean[size];

        long sum = 2;

        for(int i=3; i<size; i+=2){
            if(!isComposite[i]){
                sum+= i;
                if((long) i*i < size){
                    for(int j=i*i; j<size; j += i * 2){
                        isComposite[j] = true;
                    }
                }
            }
        }


        return sum;
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
