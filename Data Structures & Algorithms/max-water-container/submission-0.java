class Solution {
    public int maxArea(int[] heights) {
        // for any bars i and j, i < j
        // area = min(heights[i], heights[j]) * (j - i)
        // brute force would be O(n^2), find O(n)
        // one pointer is at the start, another at the end
        // move smaller of two heights to find two maximums
        // width proportionally moves inward so any of smaller height will surely be smaller area too
        int i = 0;
        int j = heights.length - 1;
        int maxArea = 0;
        while (i < j) {
            int curArea = Math.min(heights[i], heights[j]) * (j - i);
            if (curArea > maxArea) {
                maxArea = curArea;
            }
            // move smaller height inward
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--; 
            }    
        }
        
        return maxArea;
    }
}
