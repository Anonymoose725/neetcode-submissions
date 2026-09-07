class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       // flatten array and do a regular binary search
       // run a single binary search from index 0 to (rows * cols - 1)
       int m = matrix.length;
       int n = matrix[0].length;
       int left = 0;
       int right = m * n - 1;

       while (left <= right) {
            int mid = left + (right - left) / 2;

            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) return true;

            else if (target > matrix[row][col]) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
       }

       return false;
    }
}
