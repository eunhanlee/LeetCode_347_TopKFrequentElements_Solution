import java.util.*;

class Solution {
    /**
     * Returns the top K frequent elements from the given array.
     *
     * @param nums the input array
     * @param k    the number of top frequent elements to return
     * @return an array containing the top K frequent elements
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k]; // Array to store the result


        Map<Integer, Integer> count = new HashMap<>(); // Map to store element frequencies
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1); // Calculate frequencies and store in the map
        }

//        Queue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer n1, Integer n2) {
//                return count.get(n1) - count.get(n2);
//            }
//        });
//        same as below
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));
        // Min heap to store elements based on their frequencies



        for (int n : count.keySet()) {
            heap.add(n); // Add elements to the heap

            if (heap.size() > k) {
                heap.poll(); // If heap size exceeds k, remove the element with minimum frequency
            }
        }


        for (int i = k - 1; i >= 0; --i) {
            result[i] = heap.poll(); // Retrieve elements from the heap in reverse order and store in the result array
        }
        return result; // Return the result array
    }
}
