import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(maxProduct(n));
    }

    public static int maxProduct(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;

        int quotient = n / 3;
        int remainder = n % 3;

        if (remainder == 0) {
            return (int)Math.pow(3, quotient);
        } else if (remainder == 1) {
            // replace one 3 with two 2’s
            return (int)Math.pow(3, quotient - 1) * 4;
        } else { // remainder == 2
            return (int)Math.pow(3, quotient) * 2;
        }
    }
}
