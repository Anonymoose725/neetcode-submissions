class Solution {

    public String encode(List<String> strs) {
        // encode: str::length::#::str
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length());
            encoded.append('#');
            encoded.append(str);
        } 
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedStrings = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++; // keep going
            }
            int len = Integer.parseInt(str.substring(i, j));

            i = j + 1; // # + 1, first char in string
            j = i + len; // last char in string
            decodedStrings.add(str.substring(i, j));
            i = j; // skip forward
        }
        return decodedStrings;
    }
}
