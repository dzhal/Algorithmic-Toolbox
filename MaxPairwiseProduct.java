import java.util.*;
import java.io.*;


public class MaxPairwiseProduct {
    static long getMaxPairwiseProductSlow(long[] numbers) {
        long product = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                product = Math.max(product,
                        numbers[i] * numbers[j]);
            }
        }
        return product;
    }
    static long getMaxPairwiseProduct(long[] numbers) {
        int index_1st = 0;
        int index_2nd = 1;

        if (numbers[0] < numbers[1]){
            index_1st = 1;
            index_2nd = 0;
        }

        for (int i = 2; i < numbers.length; i++) {
            if (numbers[i]>numbers[index_1st]){
                index_1st = i;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (i!=index_1st && numbers[i]>numbers[index_2nd]){
                index_2nd = i;
            }
        }
        return numbers[index_1st]*numbers[index_2nd];
    }

    public static void StressTest (int N, int M){
        Random random = new Random();
        int n = 2 + random.nextInt(N+1-2);
        long [] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(M+1);
        }
        long result1 = getMaxPairwiseProduct(array);
        long result2 = getMaxPairwiseProductSlow(array);

        if (result1 == result2){
            System.out.println("OK");
        }
        else {
            System.out.println("Wrong answer: " + result1 + " " + result2);
            for (long x: array){
                System.out.print(x + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextLong();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
        /*for (int i = 0; i < 1000; i++) {
            StressTest(10, 100000);
        }*/

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

        long nextLong(){
            return Long.parseLong(next());
        }
    }
}

