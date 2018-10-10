//package week2_algorithmic_warmup;
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

  public static int GCD(int a, int b){
    if (b==0)
    return a;
    int c = a % b;
    return GCD(b, c);
  }

  public static void StresTest(int n, int m){
    Random random = new Random();
    int a = n + random.nextInt(m+1-n);
    int b = n + random.nextInt(m+1-n);
    int result1 = gcd_naive(a,b);
    int result2 = GCD(a,b);
    if (result1==result2) {
      System.out.println("OK");
    }
    else {
      System.out.println("Wrong :" + a + " " + b);
    }
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    //System.out.println(gcd_naive(a, b));
    System.out.println(GCD(a, b));
    /*for (int i = 0; i < 1000; i++) {
      StresTest(1, 2000000000);
    }*/
  }
}
