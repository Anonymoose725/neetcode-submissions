class Solution {
    public int lengthOfLongestSubstring(String s) {
        // grow window until an already-found character is hit
            // known chars tracked with a hashset for O(1) retrieval
            // when encountering a known character, shrink window by one
            // remove first char in window from seen chars
            // repeat until conditions satisfied
        HashSet<Character> seenInWindow = new HashSet<>();

        int longestLen = 0; // has to be, unless s is empty
        int l = 0;
        int r = 0;

        while (r < s.length()) {
            char c = s.charAt(r);

            if (!seenInWindow.contains(c)) {
                // increase window and longestLen
                seenInWindow.add(c);
                r++;
                longestLen = Math.max(longestLen, r - l);
            }
            else {
                // c is in the window
                // shrink until c is removed
                seenInWindow.remove(s.charAt(l));
                l++;
            }
        }

        return longestLen;
    }
}
