// Problem: Product array puzzle
// Platform: GeeksforGeeks
// Link: https://www.geeksforgeeks.org/problems/product-array-puzzle4525/1

import java.util.Arrays;

class Solution {
    public static int[] productExceptSelf(int arr[]) {
        int n = arr.length;
        int zeros = 0, index = -1;
        int prod = 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zeros++;
                index = i;
            } else {
                prod *= arr[i];
            }
        }

        int[] res = new int[n];
        Arrays.fill(res, 0);

        if (zeros == 0) {
            for (int i = 0; i < n; i++)
                res[i] = prod / arr[i];
        } 
        else if (zeros == 1) {
            res[index] = prod;
        }

        return res;
    }
}
