package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {
        List<List<String>> groupedAnagramsTest1 = groupAnagrams(new String[]{"act", "pots", "tops", "cat", "stop", "hat"});
        System.out.println("groupedAnagramsTest1: " + groupedAnagramsTest1);

        List<List<String>> groupedAnagramsTest2 = groupAnagrams(new String[]{"x"});
        System.out.println("groupedAnagramsTest2: " + groupedAnagramsTest2);

        List<List<String>> groupedAnagramsTest3 = groupAnagrams(new String[]{""});
        System.out.println("groupedAnagramsTest3: " + groupedAnagramsTest3);
    }

    // Solution 3 - Final
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupedAnagrams = new HashMap<>();

        for (String word : strs) {
            int[] count = new int[26];
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }

            String key = java.util.Arrays.toString(count);
            groupedAnagrams.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(groupedAnagrams.values());
    }

    /*
    * Solution 1
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> pairs = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            java.util.Arrays.sort(chars);
            String sortedWord = new String(chars);

            List<String> groupedItems;
            if (pairs.containsKey(sortedWord)) {
                groupedItems = new ArrayList<>(pairs.get(sortedWord));
            } else {
                groupedItems = new ArrayList<>();
            }
            groupedItems.add(word);
            pairs.put(sortedWord, groupedItems);
        }
        return new ArrayList<>(pairs.values());
    }
    */

    /*
    * Solution 2
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupedAnagrams = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            java.util.Arrays.sort(chars);
            String sortedWord = new String(chars);

            groupedAnagrams.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(groupedAnagrams.values());
    }
    */
}
