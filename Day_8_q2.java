//Lexicographically first palindromic string
import java.util.*;

public class LexicographicallyFirstPalindrome {
    public static String lexicographicallyFirstPalindrome(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Count how many characters have odd frequency
        int oddCount = 0;
        int oddCharIndex = -1;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                oddCount++;
                oddCharIndex = i;
            }
        }

        // Palindrome possible only if at most one odd frequency
        if (oddCount > 1) {
            return "NO PALINDROME";
        }

        // Build first half (sorted lexicographically)
        StringBuilder half = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i] / 2; j++) {
                half.append((char) (i + 'a'));
            }
        }

        // Middle character (if odd frequency exists)
        String middle = "";
        if (oddCharIndex != -1) {
            middle = String.valueOf((char) (oddCharIndex + 'a'));
        }

        // Construct palindrome
        String firstHalf = half.toString();
        String secondHalf = half.reverse().toString();
        return firstHalf + middle + secondHalf;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(lexicographicallyFirstPalindrome(input));
    }
}
