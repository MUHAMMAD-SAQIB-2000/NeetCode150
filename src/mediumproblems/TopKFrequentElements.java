package mediumproblems;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        System.out.println("Solution1: " + Arrays.toString(topKFrequent1(new int[]
                {
                        1, 2, 2, 2, 3, 3, 3, 3
                }, 2)));

        System.out.println("Solution1: " + Arrays.toString(topKFrequent1(new int[]
                {
                        7, 7
                }, 1)));

        System.out.println("\n=============");

        System.out.println("Solution2: " + Arrays.toString(topKFrequent2(new int[]
                {
                        1, 2, 2, 2, 3, 3, 3, 3
                }, 2)));

        System.out.println("Solution2: " + Arrays.toString(topKFrequent2(new int[]
                {
                        7, 7
                }, 1)));

        System.out.println("\n=============");

        System.out.println("Solution3: " + Arrays.toString(topKFrequent3(new int[]
                {
                        1, 2, 2, 2, 3, 3, 3, 3
                }, 2)));

        System.out.println("Solution3: " + Arrays.toString(topKFrequent3(new int[]
                {
                        7, 7
                }, 1)));

    }

    // Solution 2 - O(n + m log m)
    public static int[] topKFrequent2(int[] nums, int k) {
        System.out.println("Priority Queue Solution: ");
        Map<Integer, Integer> frequencies = new HashMap<>();

        for (int number : nums) {
            frequencies.merge(number, 1, Integer::sum);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Map.Entry.<Integer, Integer>comparingByValue().reversed());
        queue.addAll(frequencies.entrySet());

        int[] result = new int[k];
        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }

    // Solution 3 - O(n)
    public static int[] topKFrequent3(int[] nums, int k) {
        System.out.println("Bucket Solution: ");
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int number : nums) {
            frequencies.merge(number, 1, Integer::sum);
        }

        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            buckets.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            int number = entry.getKey();
            int count = entry.getValue();
            buckets.get(count).add(number);
        }

        int[] result = new int[k];
        int resultIndex = 0;
        for (int freq = nums.length; freq >= 1 && resultIndex < k; freq--) {
            for (int number : buckets.get(freq)) {
                result[resultIndex++] = number;
                if (resultIndex == k)
                    break;
            }
        }
        return result;
    }

    // Solution 1 - O (n log n)
    public static int[] topKFrequent1(int[] nums, int k) {
        System.out.println("Frequency + Sorting based Solution: ");
        Map<Integer, Integer> numberCount = new HashMap<>();

        for (int num : nums) {
            if (numberCount.containsKey(num))
                numberCount.put(num, numberCount.get(num) + 1);
            else
                numberCount.put(num, 1);
        }

        // System.out.println("numberCount: " + numberCount.toString());

        List<Integer> sortedNumbers = numberCount.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey).toList();

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = sortedNumbers.get(i);
        }
        return result;
    }
}
