import java.util.*;
import java.io.*;

public class Fibonacci {
  private static long calcFibNaive(int n) {
    if (n <= 1)
      return n;

    return calcFibNaive(n - 1) + calcFibNaive(n - 2);
  }

  private static long calcFib(int n) {
    if (n <= 1) {
      return n;
    }

    int[] fibNumbers = new int[n+1];
    fibNumbers[0] = 0;
    fibNumbers[1] = 1;

    for (int i = 2; i <= n; i++) {
      fibNumbers[i] = fibNumbers[i-1] + fibNumbers[i-2];
    }

    return fibNumbers[n];
  }

  public static void main(String args[]) {
//    // Stress Testing
//
//    Random random = new Random();
//    while (true) {
//      int number = random.nextInt(40);
//
//      long naive = calcFibNaive(number);
//      long quick = calcFib(number);
//
//
//      if (naive == quick) {
//        System.out.println(naive + " = " + quick + " OK");
//      } else {
//        System.out.println(naive + " != " + quick +"ERROR");
//        break;
//      }
//    }
    
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calcFib(n));
  }
}
