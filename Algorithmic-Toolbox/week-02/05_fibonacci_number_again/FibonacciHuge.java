import java.util.*;
import java.math.*;
import java.io.*;


public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current);
        }

        return current;
    }

    private static BigInteger[][] multiplyMatrix(BigInteger[][] matrix1, BigInteger[][] matrix2) {
        BigInteger x1 = matrix1[0][0].multiply(matrix2[0][0]).add(matrix1[1][0].multiply(matrix2[0][1]));
        BigInteger y1 = matrix1[0][1].multiply(matrix2[0][0]).add(matrix1[1][1].multiply(matrix2[0][1]));
        BigInteger x2 = matrix1[0][0].multiply(matrix2[1][0]).add(matrix1[1][0].multiply(matrix2[1][1]));
        BigInteger y2 = matrix1[0][1].multiply(matrix2[1][0]).add(matrix1[1][1].multiply(matrix2[1][1]));

        return new BigInteger[][]{{x1, x2}, {y1, y2}};
    }


    private static BigInteger[][] matrixPower(BigInteger[][] matrix, long power) {
        BigInteger[][] result = matrix;

        if (power % 2 == 0) {
            for (long i = 1; i < (power/2) ; i++) {
                result = multiplyMatrix(result, matrix);
            }
            result = multiplyMatrix(result, result);
            result = multiplyMatrix(result, matrix);
        } else {
            for (long i = 1; i < (power/2) +1 ; i++) {
                result = multiplyMatrix(result, matrix);
            }
            result = multiplyMatrix(result, result);
        }


        return result;
    }

    private static BigInteger getFibonacciHuge(long number, long divisor) {
        BigInteger[][] qMatrix = new BigInteger[][]{
                {BigInteger.valueOf(0),BigInteger.valueOf(1)},
                {BigInteger.valueOf(1), BigInteger.valueOf(1)}
        };

        if (number < 2) {
            return BigInteger.valueOf(number).mod(BigInteger.valueOf(divisor));
        }

        return matrixPower(qMatrix, number)[0][0].mod(BigInteger.valueOf(divisor));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}

