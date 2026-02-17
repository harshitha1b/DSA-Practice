// Problem: Depth of Tree Nodes
// Platform: Smart Interviews (SI)
// Topic: BST Insertion + Depth Tracking

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class Main {

    static int insert(Node root, int val) {

        int depth = 0;

        while (true) {

            if (val < root.data) {
                depth++;

                if (root.left == null) {
                    root.left = new Node(val);
                    return depth;
                }

                root = root.left;

            } else {

                depth++;

                if (root.right == null) {
                    root.right = new Node(val);
                    return depth;
                }

                root = root.right;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            int[] arr = new int[n];
            int[] depth = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            Node root = new Node(arr[0]);
            depth[0] = 0;

            for (int i = 1; i < n; i++)
                depth[i] = insert(root, arr[i]);

            for (int i = 0; i < n; i++)
                System.out.print(depth[i] + " ");

            System.out.println();
        }
    }
}
