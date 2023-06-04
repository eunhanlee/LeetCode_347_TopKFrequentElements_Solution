import java.util.*;

class Solution2 {

    /**
     * Finds the top k frequent numbers in the given array.
     *
     * @param nums the input number array.
     * @param k the number of top frequent numbers to find.
     * @return an array containing the top k frequent numbers.
     */
    public int[] topKFrequent(int[] nums, int k) {
        // Create a HashMap to store the frequency of each number.
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate over the nums array and update the frequency of each number.
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        // Create a list of map entries and sort them in descending order based on frequency.
        List<Map.Entry<Integer, Integer>> sortedEntriesList = new ArrayList<>(map.entrySet());
        sortedEntriesList.sort(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));

        // Create a result array of size k.
        int[] result = new int[k];

        // Fill the result array with the top k frequent numbers.
        for (int i = 0; i < k; i++) {
            result[i] = sortedEntriesList.get(i).getKey();
        }

        // Return the result array.
        return result;
    }
}
