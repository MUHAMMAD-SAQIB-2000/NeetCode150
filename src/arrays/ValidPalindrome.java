package arrays;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println("Test 1 => Is Palindrome: " + isPalindrome("Was it a car or a cat I saw?"));
        System.out.println("Test 2 => Is Palindrome: " + isPalindrome("tab a cat"));
        System.out.println("Test 3 => Is Palindrome: " + isPalindrome("No lemon, no melon"));
    }

    // Solution 1 - O(n) - But memory expensive because of regex
    public static boolean isPalindrome1(String s) {
        String normalized = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int pointer1 = 0, pointer2 = normalized.length() - 1;

        while (pointer1 < pointer2) {
            char ch1 = normalized.charAt(pointer1);
            char ch2 = normalized.charAt(pointer2);
            if (ch1 != ch2) {
                return false;
            }
            pointer1++;
            pointer2--;
        }
        return true;
    }

    // Solution 2 - O(n)
    public static boolean isPalindrome(String s) {
        int pointer1 = 0, pointer2 = s.length() - 1;

        while (pointer1 < pointer2) {
            char ch1 = Character.toLowerCase(s.charAt(pointer1));
            char ch2 = Character.toLowerCase(s.charAt(pointer2));

            if(!Character.isLetterOrDigit(ch1)){
                pointer1++;
                continue;
            }
            if(!Character.isLetterOrDigit(ch2)){
                pointer2--;
                continue;
            }

            if (ch1 != ch2) {
                System.out.println("Ch1: " + ch1 + ", Ch2: " + ch2);
                return false;
            }
            pointer1++;
            pointer2--;
        }
        return true;
    }
}
