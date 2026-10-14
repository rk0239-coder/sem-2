import java.util.Scanner;

public class Problem6_PrimeChecker {
    static boolean isPrime(int n) {
        for (int i = 2; (long) i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return n > 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n + (isPrime(n) ? " is prime" : " is not prime"));
    }
}
