import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class FibonacciLastDigit {

    static BigInteger getFibonacciLastDigit(int n){
        BigInteger F[][] = new BigInteger[][]{{BigInteger.valueOf(1),BigInteger.valueOf(1)},{BigInteger.valueOf(1),BigInteger.valueOf(0)}};
        if (n == 0)
            return BigInteger.valueOf(0);
        power(F, n-1);

        return F[0][0].mod(BigInteger.valueOf(10));
    }

    static void multiply(BigInteger F[][], BigInteger M[][]){
        BigInteger x =  (F[0][0].multiply(M[0][0])).add(F[0][1].multiply(M[1][0]));
        BigInteger y =  (F[0][0].multiply(M[0][1])).add(F[0][1].multiply(M[1][1]));
        BigInteger z =  (F[1][0].multiply(M[0][0])).add(F[1][1].multiply(M[1][0]));
        BigInteger w =  (F[1][0].multiply(M[0][1])).add(F[1][1].multiply(M[1][1]));

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }

    static void power(BigInteger F[][], int n) {
        if( n == 0 || n == 1)
            return;
        BigInteger M[][] = new BigInteger[][]{{BigInteger.valueOf(1),BigInteger.valueOf(1)},{BigInteger.valueOf(1),BigInteger.valueOf(0)}};

        power(F, n/2);
        multiply(F, F);

        if (n%2 != 0)
            multiply(F, M);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getFibonacciLastDigit(n));
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
