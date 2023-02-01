import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

   private static Map<Integer, Integer> getDivisors(int a) {
    Map<Integer, Integer> divisors = new HashMap<>();

     for (int i = 2; i <= a ; i++) {
       int power = 0;
       
       while (a % i == 0) {
         a = a / i;
         power += 1;
         divisors.put(i, power);
       }
     }
     return divisors;
   }


  private static long lcm(int a, int b) {
    Set<Integer> allDivisors = new HashSet<>();
    allDivisors.addAll(getDivisors(a).keySet());
    allDivisors.addAll(getDivisors(b).keySet());

    long lcm = 1;

    for (Integer divisor : allDivisors) {
      lcm *= Math.pow(divisor, Math.max(getDivisors(a).getOrDefault(divisor, 0), getDivisors(b).getOrDefault(divisor, 0)));
    }

    return lcm;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm(a, b));
  }
}
