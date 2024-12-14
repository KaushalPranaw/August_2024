package Company.Walmart;


import java.util.PriorityQueue;

public class KthSmallestElement {
    public static int findKthSmallest(int[] nums, int k) {
        // Create a min-heap (PriorityQueue) with the elements of the array
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->b.compareTo(a));

        // Add all elements to the min-heap
        for (int num : nums) {
            minHeap.add(num);
        }
        System.out.println(minHeap);


        // The kth smallest element will now be at the top of the heap
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("The " + k + "th smallest element is: " + findKthSmallest(nums, k));
    }
}
