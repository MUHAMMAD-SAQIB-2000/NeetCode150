package mediumproblems;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
    public static void main(String[] args) {
        System.out.println("Encoding: " + List.of("Hello", "World"));
        String encodedString1 = encode(List.of("Hello", "World"));

        System.out.println("Encrypted: " + encodedString1);
        System.out.println("Decoding: " + decode(encodedString1));
        System.out.println("\n=============");


        System.out.println("Encoding: " + List.of("Java", "Spring", "Boot"));
        String encodedString2 = encode(List.of("Java", "Spring", "Boot"));

        System.out.println("Encrypted: " + encodedString2);
        System.out.println("Decoding: " + decode(encodedString2));
        System.out.println("\n=============");


        System.out.println("Encoding: " + List.of("", "Hello", ""));
        String encodedString3 = encode(List.of("", "Hello", ""));

        System.out.println("Encrypted: " + encodedString3);
        System.out.println("Decoding: " + decode(encodedString3));
        System.out.println("\n=============");

    }

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            int length = str.length();
            char[] charArray = str.toCharArray();

            for (int i = 0; i < charArray.length; i++) {
                charArray[i] = (char) (charArray[i] + length);
            }

            String encodedWord = new String(charArray);
            sb.append(length).append("#").append(encodedWord);
        }
        return sb.toString();
    }

    // Solution 1
    public static List<String> decode(String encoded) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < encoded.length()) {
            int hashIndex = encoded.indexOf('#', index);

            int length = Integer.parseInt(encoded.substring(index, hashIndex));

            int wordStart = hashIndex + 1;
            int wordEnd = wordStart + length;

            String substring = encoded.substring(wordStart, wordEnd);
            char[] charArray = substring.toCharArray();

            for (int i = 0; i < charArray.length; i++) {
                charArray[i] = (char) (charArray[i] - length);
            }

            result.add(new String(charArray));

            index = wordEnd;
        }

        return result;
    }
}
