class Solution {
    public int trap(int[] height) {
        // water trapped at i'th bar either when a combination is true:
        // there is water at left or  right
        // the bar is taller at left or right
        // water at i = min(height[l], height[r]) - height[i]
        // takes time to find l and r, O(n^2) worst case
        // two pointer solution

        if (height == null || height.length == 0) return 0;

        int sum = 0;
        int left = 0;
        int right = height.length-1;
        int maxLeft = height[left];
        int maxRight = height[right];
        
        while (left < right) {
            if (maxLeft < maxRight) {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                sum += maxLeft - height[left];
            }
            else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                sum+= maxRight - height[right];
            }
        }

        return sum;
    }
}
