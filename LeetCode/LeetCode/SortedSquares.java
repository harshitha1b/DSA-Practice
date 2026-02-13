// Problem: Squares of a Sorted Array
// Platform: LeetCode
// Link: https://leetcode.com/problems/squares-of-a-sorted-array/?source=submission-ac
// Approach: Two Pointer
// Time Complexity: O(n)

class Solution {
    public int[] sortedSquares(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];

        int l = 0, h = n - 1;
        int p = n - 1;

        while (l <= h) {

            int leftSquare = nums[l] * nums[l];
            int rightSquare = nums[h] * nums[h];

            if (leftSquare > rightSquare) {
                res[p] = leftSquare;
                l++;
            } else {
                res[p] = rightSquare;
                h--;
            }

            p--;
        }

        return res;
    }
}
