import java.util.*;

public class GCD {
  private static int gcd_naive(int a, int b) {
    int current_gcd = 1;
    for(int d = 2; d <= a && d <= b; ++d) {
      if (a % d == 0 && b % d == 0) {
        if (d > current_gcd) {
          current_gcd = d;
        }
      }
    }

    return current_gcd;
  }

  private static int gcd(int a, int b) {
    while (b != 0) {
      int temp = a;
      a = b;
      b = temp % b;
    }

    return a;
  }

  public static void main(String args[]) {
//    // Stress Testing
//    Random random = new Random();
//
//    while (true) {
//      int a = random.nextInt(100);
//      int b = random.nextInt(100);
//
//      int gcdNaive = gcd_naive(a, b);
//      int gcd = gcd(a, b);
//
//      if (gcdNaive == gcd) {
//        System.out.printf("%d = %d OK\n", gcdNaive, gcd);
//      } else {
//        System.out.printf("Numbers: %d, %d\n %d != %d ERROR", a, b, gcdNaive, gcd);
//        break;
//      }
//    }

    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd(a, b));
  }
}
