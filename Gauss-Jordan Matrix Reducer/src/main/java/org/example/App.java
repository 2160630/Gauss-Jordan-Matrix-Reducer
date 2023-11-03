package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
    }

    //Code taken from https://www.baeldung.com/java-least-common-multiple
    private static int smallestCommonMultiple(int number1, int number2) {
        if (number1 == 0 || number2 == 0)
            return 0;
        else {
            int gcd = greatestCommonDivisor(number1, number2);
            return Math.abs(number1 * number2) / gcd;
        }
    }

    //Code taken from https://www.baeldung.com/java-least-common-multiple
    private static int greatestCommonDivisor(int number1, int number2){
        if (number1 == 0 || number2 == 0) {
            return number1 + number2;
        } else {
            int absNumber1 = Math.abs(number1);
            int absNumber2 = Math.abs(number2);
            int biggerValue = Math.max(absNumber1, absNumber2);
            int smallerValue = Math.min(absNumber1, absNumber2);
            return greatestCommonDivisor(biggerValue % smallerValue, smallerValue);
        }
    }

}
