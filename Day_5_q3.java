import java.util.*;

public class BinaryPalindromeString {
    public static boolean isBinaryPalindrome(int n) {
        String binary = Integer.toBinaryString(n);
        int i = 0, j = binary.length() - 1;
        while (i < j) {
            if (binary.charAt(i) != binary.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int num = sc.nextInt();

        String binary = Integer.toBinaryString(num);
        System.out.println("Binary representation: " + binary);

        if (isBinaryPalindrome(num)) {
            System.out.println("Palindrome (String method).");
        } else {
            System.out.println("Not Palindrome (String method).");
        }

        sc.close();
    }
}

//METHOD 2
import java.util.*;

public class BinaryPalindromeBitwise {
    public static boolean isBinaryPalindrome(int n) {
        int left = 31; // highest bit position for int
        while (((n >> left) & 1) == 0 && left > 0) {
            left--; // skip leading zeros
        }
        int right = 0;
        while (right < left) {
            int leftBit = (n >> left) & 1;
            int rightBit = (n >> right) & 1;
            if (leftBit != rightBit) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int num = sc.nextInt();

        String binary = Integer.toBinaryString(num);
        System.out.println("Binary representation: " + binary);

        if (isBinaryPalindrome(num)) {
            System.out.println("Palindrome (Bitwise method).");
        } else {
            System.out.println("Not Palindrome (Bitwise method).");
        }

        sc.close();
    }
}
