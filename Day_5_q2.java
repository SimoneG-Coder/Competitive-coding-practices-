import java.util.*;

public class EulerPhiWithFactors {
    // Function to compute phi(n) and print prime factors
    public static int phi(int n) {
        int result = n;
        System.out.print("Prime factors: ");
        for (int p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                System.out.print(p + " "); // print prime factor
                while (n % p == 0) {
                    n /= p;
                }
                result -= result / p;
            }
        }
        // If n > 1, then it's a prime factor
        if (n > 1) {
            System.out.print(n + " ");
            result -= result / n;
        }
        System.out.println(); // newline after factors
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int phiValue = phi(num);
        System.out.println("Euler's Totient φ(" + num + ") = " + phiValue);

        sc.close();
    }
}
