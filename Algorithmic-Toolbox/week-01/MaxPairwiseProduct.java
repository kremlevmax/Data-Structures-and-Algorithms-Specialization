import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static int getMaxPairwiseProduct(int[] numbers) {
        int max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = Math.max(max_product,
                    numbers[first] * numbers[second]);
            }
        }

        return max_product;
    }

    static long getMaxPairwiseProductFast(int[] numbers) {
        long firstLargestNumber = numbers[0], secondLargestNumber = 0;

        for (int i = 1; i < numbers.length ; i++) {
            if (firstLargestNumber <= numbers[i]) {
                secondLargestNumber = firstLargestNumber;
                firstLargestNumber = numbers[i];
            } else if (secondLargestNumber < numbers[i]) {
                secondLargestNumber = numbers[i];
            }
        }

        return firstLargestNumber*secondLargestNumber;

    }



    public static void main(String[] args) {

        //Stress Test

        /*
        Random random = new Random();

        while (true) {
            int n = random.nextInt(9) + 1;
            int[] numbers = new int[n];

            for (int i = 0; i < n; i++) {
                numbers[i] = random.nextInt(3) + 2;
                System.out.print(numbers[i] + " ");
            }

            System.out.println(getMaxPairwiseProduct(numbers));
            System.out.println(getMaxPairwiseProductFast(numbers));

            if (getMaxPairwiseProduct(numbers) == getMaxPairwiseProductFast(numbers)) {
                System.out.println("OK");
            } else {
                System.out.println("ERROR");
                break;
            }

        }
        */

        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProductFast(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
