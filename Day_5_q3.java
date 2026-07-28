import java.util.*;

public class BinaryPalindrome {
    // Function to check if a number is a binary palindrome
    public static boolean isBinaryPalindrome(int n) {
        String binary = Integer.toBinaryString(n); // convert to binary string
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
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (isBinaryPalindrome(num)) {
            System.out.println(num + " is a binary palindrome.");
        } else {
            System.out.println(num + " is NOT a binary palindrome.");
        }

        sc.close();
    }
}

//METHOD 2
import java.util.*;

public class BinaryPalindromeBitwise {
    // Function to check if n is a binary palindrome using bit operators
    public static boolean isBinaryPalindrome(int n) {
        int left = 31; // start from highest bit (for int)
        while (((n >> left) & 1) == 0 && left > 0) {
            left--; // skip leading zeros
        }
        int right = 0; // start from lowest bit

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
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (isBinaryPalindrome(num)) {
            System.out.println(num + " is a binary palindrome.");
        } else {
            System.out.println(num + " is NOT a binary palindrome.");
        }

        sc.close();
    }
}
