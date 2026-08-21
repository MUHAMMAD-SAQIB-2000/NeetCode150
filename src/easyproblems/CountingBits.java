package easyproblems;

import java.util.Arrays;

public class CountingBits {

    public static void main(String[] args) {
        System.out.println("Test Case 1: " + Arrays.toString(countBits(2)) + ", Expected: [0, 1, 1]");

        System.out.println("\n========================");

        System.out.println("Test Case 2: " + Arrays.toString(countBits(5)) + ", Expected: [0, 1, 1, 2, 1, 2]");
    }

    public static int[] countBits(int n) {
        int[] numberBits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            numberBits[i] = numberBits[i >> 1] + (i & 1);
        }
        return numberBits;
    }

}