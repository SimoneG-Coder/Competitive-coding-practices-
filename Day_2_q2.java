//In a string containing consecutive elements give the max sums of even lengths of consecutive letters
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int maxSum = 0;
        int currentSum = 0;
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                // check the run we just finished
                if (count % 2 == 0) {
                    currentSum += count;
                }
                count = 1; // reset for new run
            }
        }

        // handle last run
        if (count % 2 == 0) {
            currentSum += count;
        }

        maxSum = Math.max(maxSum, currentSum);

        System.out.println(maxSum);
    }
}
