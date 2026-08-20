package easyproblems;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        System.out.println("Test Case 1: " + Arrays.toString(plusOne(new int[]{1, 2, 3})) + ", Expected: [1, 2, 4]");

        System.out.println("\n========================");

        System.out.println("Test Case 2: " + Arrays.toString(plusOne(new int[]{9, 9, 9})) + ", Expected: [1, 0, 0, 0]");
    }

    public static int[] plusOne(int[] digits) {
        int size = digits.length;

        for (int i = size - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] plusone = new int[size + 1];
        plusone[0] = 1;
        return plusone;
    }
}
