package easyproblems;

public class ReverseBits {

    public static void main(String[] args) {
        System.out.println("Test Case 1: " + Integer.toBinaryString(reverseBits(0b00000010100101000001111010011100))
                + ", Expected: 00111001011110000010100101000000");

        System.out.println("\n========================");

        System.out.println("Test Case 2: " + Integer.toBinaryString(reverseBits(0b11111111111111111111111111111101))
                + ", Expected: 10111111111111111111111111111111");
    }

    public static int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>>= 1;
        }

        return result;
    }

}
