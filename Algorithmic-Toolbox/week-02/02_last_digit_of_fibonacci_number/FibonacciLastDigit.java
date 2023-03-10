import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }


    private static int getFibonacciLastDigit(int n) {
        if (n < 2) {
            return n;
        }

        int[] fibNumbers = new int[n+1];
        fibNumbers[0] = 0;
        fibNumbers[1] = 1;

        for (int i = 2; i <= n ; i++) {
            fibNumbers[i] = (fibNumbers[i-1] + fibNumbers[i-2])%10;
        }

        return fibNumbers[n];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigit(n);
        System.out.println(c);
    }
}

