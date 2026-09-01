//Lexicographically first palindromic string
//leetcode smallest palindromic arrangement
import java.util.*;

public class LexicographicPalindromeCheck {
    
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

    // Rearrange palindrome lexicographically while keeping it a palindrome
    public static String rearrangePalindrome(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Count odd frequencies
        int oddCount = 0, oddCharIndex = -1;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                oddCount++;
                oddCharIndex = i;
            }
        }

        // If more than one odd frequency, palindrome cannot be formed
        if (oddCount > 1) return "NO PALINDROME POSSIBLE";

        // Build first half in sorted order
        StringBuilder firstHalf = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i] / 2; j++) {
                firstHalf.append((char)(i + 'a'));
            }
        }

        // Middle character if odd frequency exists
        String middle = "";
        if (oddCharIndex != -1) {
            middle = String.valueOf((char)(oddCharIndex + 'a'));
        }

        // Mirror the first half
        String secondHalf = new StringBuilder(firstHalf).reverse().toString();

        return firstHalf.toString() + middle + secondHalf;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Lexicographically smallest palindrome: " 
                               + rearrangePalindrome(input));
        } else {
            System.out.println("Not a palindrome!");
        }
    }
}

//if input not a palindrome, random string 
import java.util.*;

public class SmallestPalindromicRearrangementI {

    // Check if string can be rearranged into a palindrome
    public static boolean canFormPalindrome(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int oddCount = 0;
        for (int f : freq) {
            if (f % 2 != 0) oddCount++;
        }

        // For even length: no odd counts allowed
        // For odd length: only one odd count allowed
        return oddCount <= 1;
    }

    // Build lexicographically smallest palindrome
    public static String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder firstHalf = new StringBuilder();
        String middle = "";

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                middle = String.valueOf((char)(i + 'a'));
            }
            for (int j = 0; j < freq[i] / 2; j++) {
                firstHalf.append((char)(i + 'a'));
            }
        }

        String secondHalf = new StringBuilder(firstHalf).reverse().toString();
        return firstHalf.toString() + middle + secondHalf;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        if (!canFormPalindrome(s)) {
            System.out.println("Cannot be rearranged into a palindrome.");
        } else {
            System.out.println(smallestPalindrome(s));
        }
    }
}
