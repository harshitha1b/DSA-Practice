// Problem: LRU Cache
// Platform: Smart Interviews (SI)
// Approach: HashMap + Doubly Linked List
// Time Complexity: O(1) per operation

import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int key;
        Node prev, next;

        Node(int key) {
            this.key = key;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {

            String[] firstLine = br.readLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int k = Integer.parseInt(firstLine[1]);

            String[] pages = br.readLine().split(" ");

            HashMap<Integer, Node> map = new HashMap<>();

            // Dummy nodes
            Node lru = new Node(-1);
            Node mru = new Node(-1);
            lru.next = mru;
            mru.prev = lru;

            for (int i = 0; i < n; i++) {

                int page = Integer.parseInt(pages[i]);

                if (map.containsKey(page)) {

                    Node curr = map.get(page);

                    // Remove from current position
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;

                    // Move to MRU position
                    Node last = mru.prev;
                    last.next = curr;
                    curr.prev = last;
                    curr.next = mru;
                    mru.prev = curr;

                } else {

                    // If cache is full
                    if (map.size() >= k) {

                        Node toRemove = lru.next;
                        map.remove(toRemove.key);

                        lru.next = toRemove.next;
                        toRemove.next.prev = lru;
                    }

                    Node newNode = new Node(page);

                    Node last = mru.prev;
                    last.next = newNode;
                    newNode.prev = last;
                    newNode.next = mru;
                    mru.prev = newNode;

                    map.put(page, newNode);
                }
            }

            // Print final cache content
            Node temp = lru.next;
            while (temp != mru) {
                output.append(temp.key).append(" ");
                temp = temp.next;
            }
            output.append("\n");
        }

        System.out.print(output);
    }
}
