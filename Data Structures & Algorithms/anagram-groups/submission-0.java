class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // (k, v) = (sortedString, [anagrams])
        Map<String, List<String>> allAnagrams = new HashMap<>();
        for (String s : strs) {
            char [] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            allAnagrams.putIfAbsent(sortedStr, new ArrayList<>()); // first instance
            allAnagrams.get(sortedStr).add(s); // append s to [anagrams]
        }
        // convert to array list
        return new ArrayList<>(allAnagrams.values());
    }
}
