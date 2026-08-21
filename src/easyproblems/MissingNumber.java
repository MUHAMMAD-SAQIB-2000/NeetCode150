package easyproblems;

public class MissingNumber {

    public static void main(String[] args) {
        System.out.println("Test Case 1: " + missingNumber(new int[]{3, 0, 1}) + ", Expected: 2");

        System.out.println("\n========================");

        System.out.println("Test Case 2: " + missingNumber(new int[]{0, 1}) + ", Expected: 2");
    }

    public static int missingNumber(int[] nums) {
        int missingNumber = nums.length; // start with n itself, since loop only covers 0..n-1
        for (int i = 0; i < nums.length; i++) {
            missingNumber ^= i ^ nums[i];
        }
        return missingNumber;
    }

}