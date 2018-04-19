package arrays.largest_number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import static java.util.Arrays.asList;

/**
 Largest Number
 https://www.interviewbit.com/problems/largest-number/

 Given a list of non negative integers, arrange them such that they form the largest number.

 For example:
 Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 Note: The result may be very large, so you need to return a string instead of an integer.
 */

public class Solution {

    public static void main(String[] args) {
        System.out.println(
                largestNumber(new ArrayList<>(asList(3, 30, 34, 5, 9)))
        );
    }

    public static String largestNumber(final List<Integer> A) {
        ArrayList<Integer> list = new ArrayList<>(A);
        Collections.sort(list, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                String first = String.valueOf(o1);
                String second = String.valueOf(o2);

                return Long.compare(Long.valueOf(second + first), Long.valueOf(first + second));
            }
        });

        boolean firstZero = true;
        StringBuilder sb = new StringBuilder();
        for (Integer i: list) {
            if (firstZero && i == 0) {
                continue;
            }
            firstZero = false;
            sb.append(i);
        }

        if (sb.length() == 0) {
            sb.append("0");
        }

        return sb.toString();
    }

}
