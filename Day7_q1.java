public class SimpleEquilibrium {
    public static void main(String[] args) {
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        
        long totalSum = 0;
        for (int num : arr) totalSum += num;

        long leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            // rightSum = totalSum - leftSum - arr[i]
            if (leftSum == totalSum - leftSum - arr[i]) {
                System.out.println("Equilibrium Index: " + i + ", Sum: " + leftSum);
                return;
            }
            leftSum += arr[i];
        }

        System.out.println("No equilibrium index found.");
    }
}
