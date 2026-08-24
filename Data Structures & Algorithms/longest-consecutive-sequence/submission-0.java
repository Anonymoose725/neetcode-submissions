class Solution {
    public int longestConsecutive(int[] nums) {
        // convert array into set for no duplicates and O(1) lookup
        HashSet<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        } 

        int longest = 0;
        for (Integer num : numSet) {
            if (!numSet.contains(num-1)) {
                // num is a sequence starter
                int length = 1;
                while (numSet.contains(num+length)) {
                    length++;
                }
                // check if its longer than previous longest sequence
                if (length > longest) {
                    longest = length;
                }
            }
        }
        return longest;
    }
}
