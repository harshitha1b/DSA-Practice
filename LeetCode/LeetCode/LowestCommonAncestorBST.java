// Problem: Lowest Common Ancestor of a Binary Search Tree
// Platform: LeetCode
// Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/?envType=problem-list-v2&envId=tree
// Time Complexity: O(h) where h is height of tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return null;

        // both nodes are in left subtree
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);

        // both nodes are in right subtree
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);

        // split point -> this is LCA
        return root;
    }
}
