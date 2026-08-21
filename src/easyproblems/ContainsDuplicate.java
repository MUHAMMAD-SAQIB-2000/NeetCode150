package easyproblems;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        System.out.println("Test Case 1: " + containsDuplicate(new int[]{1, 2, 3, 1}) + ", Expected: true");
        System.out.println("Test Case 2: " + containsDuplicate(new int[]{1, 2, 3, 4}) + ", Expected: false");
    }

    // O(n) time, O(n) space
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) return true;
        }
        return false;
    }

}