package easyproblems;

public class NumberOf1Bits {

    public static void main(String[] args) {
        System.out.println("Test Case 1: " + hammingWeight(11) + ", Expected: 3");

        System.out.println("\n========================");

        System.out.println("Test Case 2: " + hammingWeight(128) + ", Expected: 1");
    }

    public static int hammingWeight(int n) {
        int count1Bits = 0;
        while (n != 0){
            n = n & (n - 1);
            count1Bits++;
        }
        return count1Bits;
    }

}
