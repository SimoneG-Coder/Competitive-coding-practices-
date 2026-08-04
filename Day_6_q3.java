import java.util.Scanner;

public class SwapNibbles {
    public static int swapNibbles(int x) {
        // Extract lower nibble (last 4 bits) and upper nibble (first 4 bits)
        int lower = x & 0x0F;   // mask 00001111
        int upper = x & 0xF0;   // mask 11110000

        // Swap: shift lower to upper position, upper to lower
        return (lower << 4) | (upper >> 4);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number (0-255): ");
        int n = sc.nextInt();

        if (n < 0 || n > 255) {
            System.out.println("Please enter a number between 0 and 255.");
            return;
        }

        int result = swapNibbles(n);
        System.out.println("After swapping nibbles, decimal output = " + result);
    }
}

