class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // brute force would involve a fixed window scan for every permutation
        if (s1.length() > s2.length()) return false;

        // use hashset or array of 26 for alphabet
        int[] freqInS1 = new int[26];
        // for each fixed window of size s1.length(), freq[letter] = frequency of letters in this window
        // if it matches freq in s1, is anagram, therefore is included

        for (char c : s1.toCharArray()) {
            int alphabetPos = c - 'a'; // +1-1 since alphabet shift but then array index
            freqInS1[alphabetPos] = freqInS1[alphabetPos] + 1;
        }

        int windowSize = s1.length();
        for (int r = s1.length(); r <= s2.length(); r++) {
            int l = r - windowSize;
            int[] freqInWindow = new int[26];
            
            int temp = l;
            while (temp < r) {
                int alphabetPos = s2.charAt(temp) - 'a';
                freqInWindow[alphabetPos] = freqInWindow[alphabetPos] + 1;
                temp++;
            }

            // compare freqs
            if (Arrays.equals(freqInS1, freqInWindow)) {
                return true;
            }
        }

        return false;
    }
}
