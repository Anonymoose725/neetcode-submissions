class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        // maybe a hashmap with frequencies of characters
        // shortest substring of s with at minimum all characters of t

        HashMap<Character, Integer> freq = countFrequencies(t);

        // variable window - if current window doesnt contain t, grow until it does
        // then, shrink until min (until one more shrink means no t)

        int l = 0;
        int shortestLength = Integer.MAX_VALUE;
        String shortestSubstring = ""; // not really
        HashMap<Character, Integer> freqWindow = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            // add s[r] to window
            char c = s.charAt(r);
            freqWindow.put(c, freqWindow.getOrDefault(c, 0)+1);

            while (containsSubstring(freq, freqWindow)) {
                // update shortest answer if current window is smaller
                if (r-l < shortestLength) {
                    shortestLength = r-l;
                    shortestSubstring = s.substring(l, r+1);
                }
                // shrink window from left
                char leftChar = s.charAt(l);
                freqWindow.put(leftChar, freqWindow.get(leftChar) - 1);
                l++;
            }
        }
        return shortestSubstring;
    }

    public boolean containsSubstring(HashMap<Character, Integer> freqT, HashMap<Character, Integer> freqWindow) {
        // check if freqSubstring is a subset of freqString
        for (Character c : freqT.keySet()) {
            if (!freqWindow.containsKey(c) || freqWindow.get(c) < freqT.get(c)) {
                return false;
            }
        }
        return true;
    }

    public HashMap<Character, Integer> countFrequencies(String str) {
        HashMap<Character, Integer> f = new HashMap<>();
        for (char c : str.toCharArray()) {
            int cur = f.getOrDefault(c, 0);
            f.put(c, cur+1);
        }
        return f;
    }
}
