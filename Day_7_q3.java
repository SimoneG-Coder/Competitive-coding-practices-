import java.util.*;

public class MaxHourglassSum {
    public static int maxHourglassSum(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int maxSum = Integer.MIN_VALUE;

        // Traverse only where hourglass can fit
        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2]   // top row
                        + arr[i+1][j+1]                          // middle
                        + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2]; // bottom row

                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter matrix size (rows cols): ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] arr = new int[rows][cols];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int result = maxHourglassSum(arr);
        System.out.println("Maximum hourglass sum = " + result);
    }
}
