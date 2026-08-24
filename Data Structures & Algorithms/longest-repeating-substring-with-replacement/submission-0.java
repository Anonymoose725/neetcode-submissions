class Solution {
    public int characterReplacement(String s, int k) {
        // sliding window
        // a window is valid if window size - count most freq char <= k
        // since chars that arent most frequent require replacing
        // while expending window, track freq of each char and highest freq in window
        // if window is too large, shrink

        HashMap<Character, Integer> frequencies = new HashMap<>();
        int longest = 0;
        int l = 0;
        int maxFrequency = 0;
        for (int r = 0; r < s.length(); r++) {
            char cur = s.charAt(r);
            int soFar = frequencies.getOrDefault(cur, 0);
            frequencies.put(cur, soFar+1);
            maxFrequency = Math.max(maxFrequency, frequencies.get(cur));

            // window
            while ((r-l+1) - maxFrequency > k) {
                char leftChar = s.charAt(l);
                // invalid window, shrink and adjust frequency in window
                frequencies.put(leftChar, frequencies.get(leftChar)-1);
                l++;
            }

            longest = Math.max(longest, r - l + 1); // prev window or this one
        }

        return longest;
    }
}


