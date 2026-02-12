// Problem: Binary Search (First Occurrence)
// Platform: GeeksforGeeks
// Time Complexity: O(log n)

class Solution {
    public int binarysearch(int[] arr, int k) {

        int n = arr.length;
        int l = 0, h = n - 1;
        int ans = -1;

        while (l <= h) {

            int mid = l + (h - l) / 2;  // safe mid calculation

            if (arr[mid] == k) {
                ans = mid;        // store index
                h = mid - 1;      // move left to find smaller index
            }
            else if (arr[mid] > k) {
                h = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        return ans;
    }
}
