package easyproblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {
        System.out.println("Test Case 0: " + lastStoneWeight(new int[]{2, 3, 6, 2, 4}) + ", Expected: 1");

        System.out.println("\n========================");

        System.out.println("Test Case 1: " + lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}) + ", Expected: 1");

        System.out.println("\n========================");

        System.out.println("Test Case 2: " + lastStoneWeight(new int[]{1}) + ", Expected: 1");

        System.out.println("\n========================");

        System.out.println("Test Case 3: " + lastStoneWeight(new int[]{2, 2}) + ", Expected: 0");
    }

    // Solution: O(n log n) time, O(n) space
    public static int lastStoneWeight(int[] stones) {
        if (stones.length == 0) return 0;

        // Reversed heap so we can have the highest value at front.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.addAll(Arrays.stream(stones).boxed().toList());

        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // first highest

            // before checking for 2nd highest, see if we have enough elements
            if (maxHeap.isEmpty())
                break;

            int x = maxHeap.poll(); // 2nd highest

            if (x == y) {
                // both destroyed. already polled.
            } else {
                y = y - x;
                maxHeap.add(y); // new weight added.
            }
        }

        return !maxHeap.isEmpty() ? maxHeap.peek() : 0; // last remaining element or if none remains then 0
    }

}