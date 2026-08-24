class Solution {
    public int trap(int[] height) {
        // water trapped at i'th bar either when a combination is true:
        // there is water at left or  right
        // the bar is taller at left or right
        // water at i = min(height[l], height[r]) - height[i]
        // takes time to find l and r, O(n^2) worst case
        // DP: only calculate each one once, so we dont need to refind l or r
        // discover maxLeft from left to right
        // discover maxRight from right to left
        int sum = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        
        int curMaxLeft = maxLeft[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            if (height[i] > curMaxLeft) {
                curMaxLeft = height[i];
            }
            maxLeft[i] = curMaxLeft;
        }

        int curMaxRight = maxRight[height.length-1] = height[height.length-1];
        for (int i = height.length-1; i >=0; i--) {
            if (height[i] > curMaxRight) {
                curMaxRight = height[i];
            }
            maxRight[i] = curMaxRight;
        }

        // loop to calculate min(left, right)
        for (int i = 0; i < height.length; i++) {
            sum = sum + Math.min(maxLeft[i], maxRight[i]) - height[i];
        }

        return sum;
    }
}
