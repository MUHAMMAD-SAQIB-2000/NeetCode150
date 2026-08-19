package easyproblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        System.out.println("Test Case 1: " + isHappy(19) + ", Expected: true");

        System.out.println("\n========================");

        System.out.println("Test Case 2: " + isHappy(2) + ", Expected: false");
    }

    public static boolean isHappy(int n) {
        Set<Integer> lookup = new HashSet<>();
        while(n != 1){
            n = helperCalcSquareSum(n);

            if(lookup.contains(n)) return false;
            lookup.add(n);
        }
        return true;
    }

    public static int helperCalcSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

}
