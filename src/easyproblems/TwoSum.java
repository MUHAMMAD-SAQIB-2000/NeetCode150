package easyproblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println("Test Case 1: " + Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)) + ", Expected: [0, 1]");
        System.out.println("Test Case 2: " + Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)) + ", Expected: [1, 2]");
    }

    // O(n) time, O(n) space
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }
            seen.put(nums[i], i);
        }
        return new int[]{};
    }

}