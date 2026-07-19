import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextLine()) {
            System.out.println(0);
            return;
        }
        
        // Appending a space forces the last character group to trigger the 'else' block
        String s = sc.nextLine() + " "; 
        
        int totalSum = 0;
        int count = 1;

        // Start from 1 because a single character is a run of length 1
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++; // Streak continues
            } else {
                // Streak ended! Check if the group length we just finished is even
                if (count % 2 == 0) {
                    totalSum += count;
                }
                count = 1; // Reset count to 1 for the new character streak
            }
        }

        System.out.println(totalSum);
    }
}
