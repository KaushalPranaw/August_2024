package Company.Walmart;

import java.util.HashSet;
import java.util.LinkedList;

public class MyHashMap<K, V> {

    // Define a bucket size (e.g., 16)
    private static final int DEFAULT_BUCKET_SIZE = 16;

    // Array of linked lists (buckets) to store key-value pairs
    private LinkedList<Entry<K, V>>[] table;

    // The current size of the HashMap
    private int size;

    // Constructor to initialize the HashMap
    public MyHashMap() {
        table = new LinkedList[DEFAULT_BUCKET_SIZE];
        size = 0;
    }

    // A helper method to compute the hash index of a key
    private int getBucketIndex(K key) {
        if (key == null) return 0;  // Handle null key
        return Math.abs(key.hashCode()) % table.length;
    }

    // Method to add a key-value pair to the HashMap
    public void put(K key, V value) {
        int index = getBucketIndex(key);

        // If the bucket is empty, initialize it as a linked list
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        // Iterate over the linked list in the bucket to check if the key already exists
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                // Key already exists, update the value
                entry.value = value;
                return;
            }
        }

        // Key doesn't exist, so add a new entry
        table[index].add(new Entry<>(key, value));
        size++;
    }

    // Method to retrieve a value by key
    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        if (bucket != null) {
            for (Entry<K, V> entry : bucket) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null; // Return null if the key doesn't exist
    }

    // Method to remove a key-value pair by key
    public void remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        if (bucket != null) {
            for (Entry<K, V> entry : bucket) {
                if (entry.key.equals(key)) {
                    bucket.remove(entry);
                    size--;
                    return;
                }
            }
        }
    }

    // Method to check if the HashMap contains a specific key
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    // Method to return the current size of the HashMap
    public int size() {
        return size;
    }

    // Internal class to represent a key-value pair (entry)
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Main method to test the custom HashMap implementation
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        // Insert some key-value pairs
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("orange", 3);

        // Retrieve values
        System.out.println("apple: " + map.get("apple"));   // Output: apple: 1
        System.out.println("banana: " + map.get("banana")); // Output: banana: 2

        // Update an existing key
        map.put("apple", 10);
        System.out.println("apple after update: " + map.get("apple")); // Output: apple after update: 10

        // Remove a key-value pair
        map.remove("banana");
        System.out.println("banana after removal: " + map.get("banana")); // Output: banana after removal: null

        // Check the size of the HashMap
        System.out.println("Size of HashMap: " + map.size()); // Output: Size of HashMap: 2

        // Check if a key exists
        System.out.println("Contains 'orange': " + map.containsKey("orange")); // Output: Contains 'orange': true
    }
}
