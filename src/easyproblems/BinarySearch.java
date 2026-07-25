package easyproblems;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println("Test Case 1: " + search(new int[]{-1, 0, 2, 4, 6, 8}, 4) + ", Expected: 3");

        System.out.println("\n========================");

        System.out.println("Test Case 2: " + search(new int[]{-1, 0, 2, 4, 6, 8}, 3) + ", Expected: -1");

    }

    // Complexity: O(log n) time, O(1) space
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
