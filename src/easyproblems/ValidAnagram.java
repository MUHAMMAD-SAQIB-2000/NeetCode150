package easyproblems;

public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println("Test Case 1: " + isAnagram("anagram", "nagaram") + ", Expected: true");
        System.out.println("Test Case 2: " + isAnagram("rat", "car") + ", Expected: false");
    }

    // O(n) time, O(1) space (fixed 26-letter alphabet)
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }
        for (int count : counts) {
            if (count != 0) return false;
        }
        return true;
    }

}