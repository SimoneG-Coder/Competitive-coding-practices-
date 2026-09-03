import java.util.*;

public class WeightedUniqueSubstrings {
    // Build weight array from given numeric string
    public static int[] buildWeights(String weightString) {
        int[] weights = new int[26];
        for (int i = 0; i < 26 && i < weightString.length(); i++) {
            weights[i] = weightString.charAt(i) - '0'; // convert char digit to int
        }
        return weights;
    }

    public static Set<String> weightedUniqueSubstrings(String s, int k, String weightString) {
        int[] weights = buildWeights(weightString);
        int n = s.length();
        HashSet<String> uniqueSubs = new HashSet<>();

        int left = 0;
        int total = 0;

        for (int right = 0; right < n; right++) {
            total += weights[s.charAt(right) - 'a'];

            // shrink window until weight ≤ k
            while (total > k && left <= right) {
                total -= weights[s.charAt(left) - 'a'];
                left++;
            }

            // all substrings ending at right and starting from left..right are valid
            for (int i = left; i <= right; i++) {
                String sub = s.substring(i, right + 1);

                // normalize to lexicographic order so "ab" and "ba" collapse
                char[] chars = sub.toCharArray();
                Arrays.sort(chars);
                String normalized = new String(chars);

                uniqueSubs.add(normalized);
            }
        }

        return uniqueSubs;
    }

    public static void main(String[] args) {
        String s = "abc";
        int k = 5;
        String weightString = "12345678901234567890123456"; // 'a'=1, 'b'=2, 'c'=3, ...

        Set<String> result = weightedUniqueSubstrings(s, k, weightString);

        System.out.println("Unique substrings with weight ≤ " + k + ":");
        for (String sub : result) {
            System.out.println(sub);
        }
    }
}

