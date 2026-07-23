import java.util.*;

public class StrobogrammaticNumber {
    public static boolean isStrobogrammatic(String num) {
        // Mapping of digits to their rotated counterparts
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');

        int left = 0, right = num.length() - 1;

        while (left <= right) {
            char l = num.charAt(left);
            char r = num.charAt(right);

            // If left digit is not valid OR doesn't match rotated right digit
            if (!map.containsKey(l) || map.get(l) != r) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String num = sc.next();
        System.out.println(isStrobogrammatic(num) ? "YES" : "NO");
        sc.close();
    }
}

