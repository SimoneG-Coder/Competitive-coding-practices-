import java.util.*;

public class EulerPhi {
    // Function to compute phi(n)
    public static int phi(int n) {
        int result = n;
        for (int p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                // If p divides n, subtract multiples
                while (n % p == 0) {
                    n /= p;
                }
                result -= result / p;
            }
        }
        // If n > 1, then it's a prime factor
        if (n > 1) {
            result -= result / n;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int phiValue = phi(num);
        System.out.println("Euler's Totient φ(" + num + ") = " + phiValue);

        // Print coprime numbers
        System.out.print("Coprime numbers with " + num + ": ");
        for (int i = 1; i <= num; i++) {
            if (gcd(i, num) == 1) {
                System.out.print(i + " ");
            }
        }
        sc.close();
    }

    // Helper gcd function
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
