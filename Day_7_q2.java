public class MaxEquilibriumSum {

    public static Long findMaxEquilibriumSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null; // Return null if array is empty or null
        }

        long totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        long leftSum = 0;
        Long maxSum = null; // Track the maximum equilibrium sum found

        for (int i = 0; i < arr.length; i++) {
            long rightSum = totalSum - leftSum - arr[i];

            if (leftSum == rightSum) {
                // Update maxSum if it's the first match or greater than previous match
                if (maxSum == null || leftSum > maxSum) {
                    maxSum = leftSum;
                }
            }

            leftSum += arr[i];
        }

        return maxSum;
    }

    public static void main(String[] args) {
        // Example with multiple equilibrium points:
        // Index 2 (val 5) -> leftSum = -6, rightSum = -6
        // Index 6 (val 0) -> leftSum = 0, rightSum = 0 (MAX SUM = 0)
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};

        Long maxResult = findMaxEquilibriumSum(arr);

        if (maxResult != null) {
            System.out.println("Maximum Equilibrium Sum: " + maxResult);
        } else {
            System.out.println("No equilibrium index found.");
        }
    }
}
