import java.util.*;

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

    private static long[][] multiplyMatrix(long[][] matrix1, long[][] matrix2) {
        long x1 = matrix1[0][0]*matrix2[0][0] + matrix1[1][0]*matrix2[0][1];
        long y1 = matrix1[0][1]*matrix2[0][0] + matrix1[1][1]*matrix2[0][1];
        long x2 = matrix1[0][0]*matrix2[1][0] + matrix1[1][0]*matrix2[1][1];
        long y2 = matrix1[0][1]*matrix2[1][0] + matrix1[1][1]*matrix2[1][1];

        return new long[][]{{x1, x2}, {y1, y2}};
    }


    private static long[][] matrixPower(long[][] matrix, long power) {
        long[][] result = matrix;

        for (long i = 0; i < power ; i++) {
            result = multiplyMatrix(result, matrix);
        }
        return result;
    }

    private static long getFibonacciHuge(long number, long divisor) {
        long[][] qMatrix = new long[][]{{0,1}, {1, 1}};

        if (number < 2) {
            return number;
        }

        return matrixPower(qMatrix, number)[0][0];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}

