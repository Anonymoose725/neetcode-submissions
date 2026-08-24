// O(n^2) would be to brute force : try each combination of two numbers

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // numbers is sorted in ascending order !!
        // ^-- use binary search for logn find?
        // cant. instead use ascending order fact: largest right, smallest left.
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            }
            else if (numbers[left] + numbers[right] < target) {
                left++;
            }
            else {
                // found match: numbers[left] + numbers[right] = target
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{}; // not a real case
    }
    
}
