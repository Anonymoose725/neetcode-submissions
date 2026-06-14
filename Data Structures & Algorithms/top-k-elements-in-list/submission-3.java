class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // (k, v) = (number, frequency)
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int freq = frequencies.getOrDefault(cur, 0);
            frequencies.put(cur, freq + 1);
        }
        // how do we keep track of most frequent? heap!
        // use a min heap, and pop every time a more frequent result comes in
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // for each key-value pair in the set
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            minHeap.offer(new int[]{entry.getValue(), entry.getKey()});
        }
        while (minHeap.size() > k) { // until k entries found
            minHeap.poll(); // pop min and trash it
        }

        int [] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = minHeap.poll()[1];
        }
        return topK;
    }

}
