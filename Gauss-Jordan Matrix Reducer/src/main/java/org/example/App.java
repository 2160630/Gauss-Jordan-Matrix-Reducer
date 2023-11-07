package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    private static int[][] testMatrix = {
            {1, 3, 1, 0},
            {-1, 4, 0, 1}
    };

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        GaussJordanReductionAlgorithm(testMatrix);
        showMatrix(testMatrix);
    }

    public static void GaussJordanReductionAlgorithm(int[][] matrix){
        if(matrix.length == 0 || matrix[0].length == 0) return;

        final int ROW_COUNT = matrix.length;
        final int COLUMN_COUNT = matrix[0].length;
        final int DIAGONAL_COUNT = Math.min(ROW_COUNT, COLUMN_COUNT);



        for(int pivotRowIndex = 0, pivotColumnIndex = 0; pivotRowIndex < ROW_COUNT && pivotColumnIndex < COLUMN_COUNT; pivotRowIndex++, pivotColumnIndex++){
            //Divide rows by greatest common divisor
            DivideEveryRowByGreatestCommonDivisor(matrix);
            showMatrix(matrix);
            System.out.println();

            //Get a non-zero pivot row
            for(int otherRowIndex = pivotRowIndex + 1; otherRowIndex < ROW_COUNT && matrix[pivotRowIndex][pivotColumnIndex] == 0; otherRowIndex++){
                swapRowsInMatrix(matrix, pivotRowIndex, otherRowIndex);
            }
            if(matrix[pivotRowIndex][pivotColumnIndex] == 0){
                pivotRowIndex--;
                continue;
            }

            //Reduction
            for(int otherRowIndex = 0; otherRowIndex < pivotRowIndex; otherRowIndex++){
                ReduceRow(matrix[pivotRowIndex], matrix[otherRowIndex], pivotColumnIndex);
            }
            for(int otherRowIndex = pivotRowIndex + 1; otherRowIndex < ROW_COUNT; otherRowIndex++){
                ReduceRow(matrix[pivotRowIndex], matrix[otherRowIndex], pivotColumnIndex);
            }

        }



        //Divide rows by greatest common divisor
        DivideEveryRowByGreatestCommonDivisor(matrix);





    }

    public static void ReduceRow(final int[] pivotRow, int[] reducedRow, int columnIndex){
        for(int i = pivotRow.length - 1; i >= 0; i--){
            reducedRow[i] = (pivotRow[columnIndex] * reducedRow[i])
                    - (pivotRow[i] * reducedRow[columnIndex]);
        }
    }

    public static void DivideEveryRowByGreatestCommonDivisor(int[][] matrix){
        for(int[] row : matrix){
            DivideRowByGreatestCommonDivisor(row);
        }
    }

    public static void DivideRowByGreatestCommonDivisor(int[] row){
        int greatestCommonDivisor = getRowGreatestCommonDivisor(row);
        for(int i = 0; i < row.length; i++){
            row[i] /= greatestCommonDivisor;
        }
    }

    public static int getRowGreatestCommonDivisor(int[] row){
        int result = 0;
        int indexOfFirstNonZeroElement = -1;
        for(int i = 0; i < row.length; i++){
            if(row[i] == 0)
                continue;
            if(result == 1)
                break;
            if(indexOfFirstNonZeroElement == -1)
                indexOfFirstNonZeroElement = i;
            result = (result == 0) ? row[i] : greatestCommonDivisor(result, row[i]);
        }

        if(result == 0)
            result = 1;
        if(indexOfFirstNonZeroElement != -1 && row[indexOfFirstNonZeroElement] < 0){
            result = -result;
        }

        return result;
    }

    public static void swapRowsInMatrix(int[][] matrix, int indexRowA, int indexRowB){
        int[] tempRow = matrix[indexRowA];
        matrix[indexRowA] = matrix[indexRowB];
        matrix[indexRowB] = tempRow;
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
