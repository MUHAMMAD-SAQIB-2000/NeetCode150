package easyproblems;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println("add(3): " + kthLargest.add(3) + ", Expected: 4");
        System.out.println("add(5): " + kthLargest.add(5) + ", Expected: 5");
        System.out.println("add(10): " + kthLargest.add(10) + ", Expected: 5");
        System.out.println("add(9): " + kthLargest.add(9) + ", Expected: 8");
        System.out.println("add(4): " + kthLargest.add(4) + ", Expected: 8");
    }

    static class KthLargest {

        int k;
        PriorityQueue<Integer> minHeap;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.minHeap = new PriorityQueue<>();

            for (int value : nums) {
                minHeap.offer(value);

                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
        }

        // Solution - O(mlogk) time, O(k) space
        public int add(int val) {
            if (val > minHeap.peek()){
                minHeap.poll();
                minHeap.add(val);
            }

//            System.out.println("Size: " + minHeap.size() + " - heap: " + minHeap);
            return minHeap.peek();
        }
    }

}
