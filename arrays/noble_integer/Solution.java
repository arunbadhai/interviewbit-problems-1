package arrays.noble_integer;

import java.util.ArrayList;
import java.util.Collections;

import static java.util.Arrays.asList;

/**
 Noble Integer
 https://www.interviewbit.com/problems/noble-integer/

 Given an integer array, find if an integer p exists in the array such that the number of integers greater
 than p in the array equals to p. If such an integer is found return 1 else return -1.


 */

public class Solution {

    public static void main(String[] args) {
        System.out.println(
                solve(new ArrayList<>(asList(-1, -1, 1, 2)))
        );
    }

//    O(nlogn)
    public static int solve(ArrayList<Integer> A) {
        Collections.sort(A);

        for (int i = 0; i < A.size(); i++) {
            int checkedNumber = A.get(i);
            if (i + 1 < A.size() && checkedNumber == A.get(i + 1)) {
                continue;
            }

            if (A.size() - i - 1 == checkedNumber) {
                return 1;
            }
        }

        return -1;
    }

//    Naive solution O(n^2)
//
//    for (int i = 0; i < A.size(); i++) {
//        int checkedNumber = A.get(i);
//        int counter = 0;
//        for (int j = 0; j < A.size(); i++) {
//            if (j != i && checkedNumber < A.get(j)) {
//                counter++;
//            }
//        }
//
//        if (checkedNumber == counter) {
//            return 1;
//        }
//    }
//    return -1;
}
