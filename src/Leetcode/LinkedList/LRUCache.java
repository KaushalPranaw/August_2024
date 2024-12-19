package Leetcode.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node {
        int key, value;
        Node next, prev;

        Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }

    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    int capacity;
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int c) {
        this.capacity = c;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.key;
        } else return -1;
    }

    public void put(int k, int v) {
        if (map.containsKey(k)) {
            remove(map.get(k));
        }
        if (map.size() == this.capacity) {
            remove(this.tail.prev);
        }
        insert(new Node(k, v));
    }

    void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void insert(Node node) {
        map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }

    public static void main(String[] args) {
        // Create an LRUCache with a capacity of 2
        LRUCache lruCache = new LRUCache(2);

        // Put some key-value pairs into the cache
        lruCache.put(1, 1);  // Cache is {1=1}
        lruCache.put(2, 2);  // Cache is {1=1, 2=2}

        // Get the value for key 1, which should return 1
        System.out.println(lruCache.get(1)); // returns 1

        // The cache should now be {2=2, 1=1} (1 is most recently used)

        // Adding another key-value pair, this will evict key 2
        lruCache.put(3, 3);  // Cache is {1=1, 3=3}

        // Try to get the value for key 2, which should return -1 (not found)
        System.out.println(lruCache.get(2)); // returns -1

        // Adding another key-value pair, this will evict key 1
        lruCache.put(4, 4);  // Cache is {3=3, 4=4}

        // Try to get the value for key 1, which should return -1 (not found)
        System.out.println(lruCache.get(1)); // returns -1

        // Get the value for key 3, which should return 3
        System.out.println(lruCache.get(3)); // returns 3

        // Get the value for key 4, which should return 4
        System.out.println(lruCache.get(4)); // returns 4
    }

}
