class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int n : nums) {

            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        Map<Integer, List<Integer>> buckets = new HashMap<>();

        for (int elem : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(elem);
            List<Integer> elems = buckets.getOrDefault(frequency, new ArrayList<>());
            elems.add(elem);
            buckets.put(frequency, elems);
        }

        int[] result = new int[k];
        int index = 0;
        for (int frequency = nums.length; frequency >= 0 && index < k; frequency--) {
            if (buckets.get(frequency) != null) {
                for (int elem : buckets.get(frequency)) {
                    result[index] = elem;
                    index++;
                }
            }
        }
        return result;
    }
}