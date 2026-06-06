class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> freqS = new HashMap<>();
        HashMap<Character, Integer> freqT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Integer curFreqS = freqS.getOrDefault(s.charAt(i), 0);
            Integer curFreqT = freqT.getOrDefault(t.charAt(i), 0);

            freqS.put(s.charAt(i), curFreqS + 1);
            freqT.put(t.charAt(i), curFreqT + 1);
        }

        return freqS.equals(freqT);
    }
}
