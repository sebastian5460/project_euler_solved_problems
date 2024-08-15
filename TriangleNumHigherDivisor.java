package project_euler;

public class TriangleNumHigherDivisor {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        long result = findTriangleNumberWithDivisors(500);
        long endTime = System.nanoTime();
        
        System.out.println("First triangle number with over 500 divisors: " + result);
        System.out.printf("Execution time: %.3f ms%n", (endTime - startTime) / 1_000_000.0);
    }

    public static long findTriangleNumberWithDivisors(int minDivisors) {
        int n = 0;
        int divisors = 0;
        while (divisors <= minDivisors) {
            n++;
            long triangleNumber = (long) n * (n + 1) / 2;
            divisors = countDivisors(triangleNumber);
        }
        return (long) n * (n + 1) / 2;
    }

    public static int countDivisors(long num) {
        int count = 0;
        long sqrt = (long) Math.sqrt(num);
        
        for (long i = 1; i <= sqrt; i++) {
            if (num % i == 0) {
                count += 2;
            }
        }
        
        if (sqrt * sqrt == num) {
            count--;
        }
        
        return count;
    }

}
