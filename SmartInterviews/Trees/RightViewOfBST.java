// Problem: Right View of Binary Search Tree
// Platform: Smart Interviews (SI)
// Topic: Trees / Level Order Traversal

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class Main {

    static Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.data)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    static void rightView(Node root) {

        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                Node temp = q.poll();

                if (i == size - 1)
                    System.out.print(temp.data + " ");

                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            Node root = null;

            for (int i = 0; i < n; i++)
                root = insert(root, sc.nextInt());

            rightView(root);
        }
    }
}
