package easyproblems;

public class SingleNumber {

    public static void main(String[] args) {
        System.out.println("Test Case 1: " + singleNumber(new int[]{2, 2, 1}) + ", Expected: 1");

        System.out.println("\n========================");

        System.out.println("Test Case 2: " + singleNumber(new int[]{4, 1, 2, 1, 2}) + ", Expected: 4");
    }

    public static int singleNumber(int[] nums) {
        int singleNumber = 0;

        for (int num : nums) {
            singleNumber ^= num;
        }

        return singleNumber;
    }

}