/**
 * Given an array A containing 2*N+2 positive numbers, out of which 2*N numbers
 * exist in pairs whereas the other two number occur exactly once and are
 * distinct. Find the other two numbers. Return in increasing order.
 * 
 * 
 * Example 1:
 * 
 * Input:
 * N = 2
 * arr[] = {1, 2, 3, 2, 1, 4}
 * Output:
 * 3 4
 * Explanation:
 * 3 and 4 occur exactly once.
 * Example 2:
 * 
 * Input:
 * N = 1
 * arr[] = {2, 1, 3, 2}
 * Output:
 * 1 3
 * Explanation:
 * 1 3 occur exactly once.
 * 
 * Your Task:
 * You do not need to read or print anything. Your task is to complete the
 * function singleNumber() which takes the array as input parameter and returns
 * a list of two numbers which occur exactly once in the array. The list must be
 * in ascending order.
 * 
 * 
 * Expected Time Complexity: O(N)
 * Expected Space Complexity: O(1)
 * 
 * 
 * Constraints:
 * 1 <= length of array <= 106
 * 1 <= Elements in array <= 5 * 106
 */

class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums)
            xor = xor ^ num;
        xor = xor & (-xor);
        int xor1 = 0, xor2 = 0;
        for (int num : nums) {
            if ((num & xor) == 0)
                xor1 = xor1 ^ num;
            else
                xor2 = xor2 ^ num;
        }
        if (xor2 < xor1) {
            int temp = xor1;
            xor1 = xor2;
            xor2 = temp;
        }
        return new int[] { xor1, xor2 };
    }
}

// =============================================================================
//
// Pepcoding Video :
// https://www.youtube.com/watch?v=pnx5JA9LNM4&t=11s&ab_channel=Pepcoding
//
// ==============================================================================