package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    private static int[][] testMatrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        GaussJordanReductionAlgorithm(testMatrix);
        showMatrix(testMatrix);
    }

    public static void GaussJordanReductionAlgorithm(int[][] matrix){
        //TODO


    }

    public static void DivideEveryRowBySmallestCommonMultiple(int[][] matrix){
        for(int[] row : matrix){
            DivideRowBySmallestCommonMultiple(row);
        }
    }

    public static void DivideRowBySmallestCommonMultiple(int[] row){
        int smallestCommonMultiple = getRowSmallestCommonMultiple(row);
        for(int i = 0; i < row.length; i++){
            row[i] /= smallestCommonMultiple;
        }
    }

    public static int getRowSmallestCommonMultiple(int[] row){
        //TODO


        return 0;
    }

    public static void swapRowsInMatrix(int[][] matrix, int rowA, int rowB){
        int[] tempRow = matrix[rowA];
        matrix[rowA] = matrix[rowB];
        matrix[rowB] = tempRow;
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

    public static void showMatrix(int[][] matrix){
        for(int row = 0; row < matrix.length; row++){
            for(int column = 0; column < matrix[0].length; column++){
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }
}
