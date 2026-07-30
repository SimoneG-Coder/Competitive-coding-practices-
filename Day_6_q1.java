public class BitwiseConsecutiveOnes {

    public static int maxConsecutiveOnesBitwise(int n) {
        int count = 0;

        // Each iteration reduces every block of consecutive 1s by 1 bit
        while (n != 0) {
            n = n & (n >> 1);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        // 156 in binary is 10011100 (longest 1s sequence length = 3)
        int number = 156; 
        System.out.println(maxConsecutiveOnesBitwise(number)); // Output: 3
    }
}
