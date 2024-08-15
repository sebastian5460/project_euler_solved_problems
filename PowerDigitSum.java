package project_euler;

import java.math.BigInteger;

public class PowerDigitSum {
    
    public static void main(String[] args) {
    
        
        BigInteger two_power_thousand = BigInteger.ONE;

        for (int i = 0; i < 1000; i++) {
            two_power_thousand = two_power_thousand.multiply(new BigInteger("2"));
        }

        // two_power_thousand = two_power_thousand.multiply(new BigInteger("2"));

        /* String myBig = two_power_thousand.toString();

        System.out.println(myBig); */

        System.out.println(giveMeArray(two_power_thousand));

    }

    public static String giveMeArray(BigInteger bigNum){

        String bigS = bigNum.toString();
        String[] bigSArr = new String[bigS.length()];
        BigInteger[] bigArr = new BigInteger[bigSArr.length];
        BigInteger sum =  BigInteger.ZERO;
        String result;

        for (int i = 0; i < bigS.length(); i++) {
            bigSArr[i] = String.valueOf(bigS.charAt(i));
        }

        for(int i=0; i<bigSArr.length; i++){
            bigArr[i] = new BigInteger(bigSArr[i]);
        }

        for (BigInteger bigInteger : bigArr) {
            sum = sum.add(bigInteger);
        }

        result = sum.toString();

        return result;
    }
}
