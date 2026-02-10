// Problem: Intersection of Two Linked Lists
// Platform: LeetCode
// Approach: Length Difference Method
// Link: https://leetcode.com/problems/intersection-of-two-linked-lists/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int n = size(headA);
        int m = size(headB);

        // Ensure headA is the longer list
        if (n < m) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;

            int t = n;
            n = m;
            m = t;
        }

        int d = n - m;

        // Move longer list ahead
        while (d-- > 0) {
            headA = headA.next;
        }

        // Traverse both lists together
        while (headA != null && headB != null) {
            if (headA == headB)
                return headA;

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    static int size(ListNode head) {
        int c = 0;
        while (head != null) {
            c++;
            head = head.next;
        }
        return c;
    }
}
