public class NibbleSwapper {

    /**
     * Swaps the high and low nibbles of an 8-bit byte.
     */
    public static int swapNibbles(int b) {
        // Keep only the lower 8 bits in case an integer with more bits was passed
        b = b & 0xFF;

        // Extract lower 4 bits and shift left by 4, extract upper 4 bits and shift right by 4
        return ((b & 0x0F) << 4) | ((b & 0xF0) >> 4);
    }

    public static void main(String[] args) {
        int input = 0xAB; // Binary: 1010 1011
        int result = swapNibbles(input);

        System.out.printf("Original: 0x%02X (%s)%n", input, String.format("%8s", Integer.toBinaryString(input)).replace(' ', '0'));
        System.out.printf("Swapped:  0x%02X (%s)%n", result, String.format("%8s", Integer.toBinaryString(result)).replace(' ', '0'));
    }
}
