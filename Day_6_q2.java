public class MaxConsecutiveOnesWithFlip {

    // Works with String inputs (e.g., "10110110")
    public static int findMaxConsecutiveOnes(String binaryStr) {
        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int right = 0; right < binaryStr.length(); right++) {
            if (binaryStr.charAt(right) == '0') {
                zeroCount++;
            }

            // Shrink window from left if we exceed 1 zero
            while (zeroCount > 1) {
                if (binaryStr.charAt(left) == '0') {
                    zeroCount--;
                }
                left++;
            }

            // Calculate max window length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    // Works with int array inputs (e.g., {1, 0, 1, 1, 0})
    public static int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        // String Example
        String strInput = "10110110";
        System.out.println("String input result: " + findMaxConsecutiveOnes(strInput));
        // Output: 5 (Flipping '0' at index 4 gives "10111110", length 5)

        // Array Example
        int[] arrayInput = {1, 1, 0, 1, 1, 1, 0, 1};
        System.out.println("Array input result: "  + findMaxConsecutiveOnes(arrayInput));
        // Output: 6 (Flipping '0' at index 2 gives six 1s in a row)
    }
}
