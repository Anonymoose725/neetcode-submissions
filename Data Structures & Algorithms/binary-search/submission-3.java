class Solution {
    public int search(int[] nums, int target) {
        // iterative rather than recursive
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int val = nums[middle];
            
            if (val > target) {
                right = middle - 1;
            }
            else if (val < target) {
                left = middle + 1;
            }
            else { // nums[middle] = target
                return middle;
            }
        }

        return -1;
    }
}
