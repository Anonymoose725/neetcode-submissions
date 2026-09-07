class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // rows are sorted non-decreasing
        // every first of a row is greater than the last of the prev
        // binary search on rows: logm time
            // when target is between firsts of rows, check the firsts
            // check binary on above row: logn time
            // = logn + logm = logmn
        
        int first = 0;
        int last = matrix.length - 1;

        while (first <= last) {
            int middle = first + (last - first) / 2;
            int[] middleRow = matrix[middle];
            int lowest = middleRow[0];
            int highest = middleRow[middleRow.length - 1];

            if (lowest <= target && target <= highest) {
                // belongs to this row: do a binary search
                return Arrays.binarySearch(middleRow, target) >= 0;
            }
            else if (target > highest) {
                first = middle + 1;
            }
            else {
                last = middle - 1;
            }
        }

        return false;
    }
}    

    
