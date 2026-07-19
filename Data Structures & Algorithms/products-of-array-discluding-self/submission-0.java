class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] left = new int[nums.length];
        int [] right = new int[nums.length];
        int [] output = new int[nums.length];

        // prefixes
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i-1] * left[i-1];
        }

        // suffixes
        right[nums.length - 1] = 1;
        for (int j = nums.length - 2; j >= 0; j--) {
            right[j] = nums[j+1] * right[j+1];
        }

        // output
        for (int i = 0; i < nums.length; i++) {
            output[i] = left[i] * right[i];
        }
        return output;
    }
}  
