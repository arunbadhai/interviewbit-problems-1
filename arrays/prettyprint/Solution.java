package arrays.prettyprint;

import java.util.ArrayList;

/**
 Pretty Print
 https://www.interviewbit.com/problems/prettyprint/

 Print concentric rectangular pattern in a 2d matrix.
 Let us show you some examples to clarify what we mean.

 Example 1:

 Input: A = 4.
 Output:

 4 4 4 4 4 4 4
 4 3 3 3 3 3 4
 4 3 2 2 2 3 4
 4 3 2 1 2 3 4
 4 3 2 2 2 3 4
 4 3 3 3 3 3 4
 4 4 4 4 4 4 4
 Example 2:

 Input: A = 3.
 Output:

 3 3 3 3 3
 3 2 2 2 3
 3 2 1 2 3
 3 2 2 2 3
 3 3 3 3 3
 The outermost rectangle is formed by A, then the next outermost is formed by A-1 and so on.

 You will be given A as an argument to the function you need to implement, and you need to return a 2D array.
 */

public class Solution {

    public static void main(String[] args) {
        System.out.println(prettyPrint(3));
    }

    public static ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        int size = 2*A - 1;
        int lastIndex = size - 1;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            ArrayList<Integer> col = new ArrayList<>(size);
            for (int j = 0; j < size; j++) {
                int iIndex = (i > A - 1)?(lastIndex - i):(i);
                int jIndex = (j > A - 1)?(lastIndex - j):(j);
                col.add(j, A - Math.min(iIndex, jIndex));
            }

            result.add(i, col);
        }

        return result;
    }
}
