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

        // Enumerate all substrings
        for (int i = 0; i < n; i++) {
            int total = 0;
            for (int j = i; j < n; j++) {
                total += weights[s.charAt(j) - 'a'];
                if (total <= k) {
                    String sub = s.substring(i, j + 1);

                    // normalize to lexicographic order
                    char[] chars = sub.toCharArray();
                    Arrays.sort(chars);
                    String normalized = new String(chars);

                    uniqueSubs.add(normalized);
                } else {
                    break; // stop if weight exceeds k
                }
            }
        }

        return uniqueSubs;
    }

    public static void main(String[] args) {
        String s = "abc";
        int k = 5;
        String weightString = "12345678901234567890123456"; 
        // 'a'=1, 'b'=2, 'c'=3, ...

        Set<String> result = weightedUniqueSubstrings(s, k, weightString);

        System.out.println("Unique substrings with weight ≤ " + k + ":");
        for (String sub : result) {
            System.out.println(sub);
        }
    }
}

