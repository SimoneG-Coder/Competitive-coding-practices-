//Lexicographically first palindromic string
import java.util.*;

public class LexicographicPalindrome {
    
    // Check if string is palindrome
    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    // Rearrange palindrome into lexicographic order
    public static String arrangeLexicographically(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr); // sort characters alphabetically
        return new String(arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Lexicographically arranged palindrome: " 
                               + arrangeLexicographically(input));
        } else {
            System.out.println("Not a palindrome!");
        }
    }
}
