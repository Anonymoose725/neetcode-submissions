class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /* 
        sort nums ascending
        for each i'th num:
            find j and k s.t. nums[i] + nums[j] + nums[k] = 0
            => nums[j] + nums[k] = -nums[i]
            => nums[i] = -(nums[j] + nums[k])
            => [i, j, k] U [results]
            => how to check for duplicates?
        */
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int target = -nums[i];
            // find j and k using two-pointer method over nums after i
            // bound at i since all before i have been checked (avoid duplicates)
            int j = i+1; // smallest
            int k = nums.length - 1; // biggest
            while (j < k) {
                if (nums[j]+nums[k] > target) {
                    k--;
                }
                else if (nums[j]+nums[k] < target) {
                    j++;
                }
                else {
                    // found match, add to result
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    result.add(triplet);
                    // move both pointers
                    // skip dup numbers to avoid dup triplets
                    j++;
                    while (j < k && nums[j] == nums[j-1]) j++;
                    k--;
                    while (k > j && nums[k] == nums[k+1]) k--;
                }
            }
        }
        return result;
    }
}
