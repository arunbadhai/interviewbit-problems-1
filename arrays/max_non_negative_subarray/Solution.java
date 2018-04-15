package arrays.max_non_negative_subarray;

import java.util.ArrayList;
import java.util.Scanner;

import static java.util.Arrays.asList;

/**
 Max Non Negative SubArray
 https://www.interviewbit.com/problems/max-non-negative-subarray/

 Find out the maximum sub-array of non negative numbers from an array.
 The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

 Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).

 Example:
 A : [1, 2, 5, -7, 2, 3]
 The two sub-arrays are [1, 2, 5] [2, 3].
 The answer is [1, 2, 5] as its sum is larger than [2, 3]

 NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
 NOTE 2: If there is still a tie, then return the segment with minimum starting index
 */

public class Solution {

    public static void main(String[] args) {
        System.out.println(
                maxset(new ArrayList<>(asList(-1, -1, 1, 2)))
        );
    }

    public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
        ArrayList<Long> sums = new ArrayList<>();
        ArrayList<Integer> indexes = new ArrayList<>();
        ArrayList<ArrayList<Integer>> sets = new ArrayList<>();

        int lastInsertedId = -2;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) >= 0) {
                if (lastInsertedId != (i - 1)) {
                    sums.add(0L);
                    indexes.add(i);
                    sets.add(new ArrayList<>());
                }

                sums.set(sums.size() - 1, (sums.get(sums.size() - 1) + A.get(i)));
                sets.get(sets.size() - 1).add(A.get(i));

                lastInsertedId = i;
            }
        }

        if (sets.size() == 0) {
            return new ArrayList<>();
        }

        int resultIndex = 0;
        for (int i = 1; i < sums.size(); i++) {
            long diff = sums.get(resultIndex) - sums.get(i);
            if (diff < 0) {
                resultIndex = i;
            } else if (diff == 0) {
                int sizeDiff = sets.get(resultIndex).size() - sets.get(i).size();
                if (sizeDiff < 0) {
                    resultIndex = i;
                } else if (sizeDiff == 0 && indexes.get(resultIndex) > indexes.get(i)) {
                    resultIndex = i;
                }
            }
        }

        return sets.get(resultIndex);
    }
}
