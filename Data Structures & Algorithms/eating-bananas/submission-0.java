class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // find upper bound k = max(piles)
        // lower bound = 1
        int l = 1;
        int r = arrayMax(piles);
        int result = r;

        while (l <= r) {
            int k = l + (r - l) / 2;

            int timeTaken = 0;
            for (int pile : piles) {
                timeTaken += Math.ceil((double) pile / k);
            }

            if (timeTaken <= h) {
                result = k;
                r = k - 1;
            }
            else {
                l = k + 1;
            }
        }

        return result;

    }

    public int arrayMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
