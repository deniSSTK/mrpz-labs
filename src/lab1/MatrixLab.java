package lab1;

import java.util.Random;

public class MatrixLab {
    
    static void main(String[] args) {
        int[][] matrixA = new int[2][3];
        Random random = new Random();
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                matrixA[i][j] = random.nextInt(21) - 10;
            }
        }
        
        System.out.println("\nOriginal Matrix A (2x3):");
        printMatrix(matrixA);
        
        int negativeCount = 0;
        long negativeProduct = 1;
        boolean hasNegativeElements = false;
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrixA[i][j] < 0) {
                    negativeCount++;
                    negativeProduct *= matrixA[i][j];
                    hasNegativeElements = true;
                }
            }
        }
        
        System.out.println("\nResults:");
        System.out.println("Total count of negative elements: " + negativeCount);
        
        if (hasNegativeElements) {
            System.out.println("Product of negative elements: " + negativeProduct);
        } else {
            System.out.println("Product of negative elements: N/A (no negative elements)");
        }
    }
    
    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.print("| ");
            for (int anInt : ints) {
                System.out.printf("%4d ", anInt);
            }
            System.out.println("|");
        }
    }
}
