class Solution {
    public boolean isPalindrome(String s) {
        String noSpecChars = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] str = noSpecChars.toCharArray();
        int i = 0; // first
        int j = str.length - 1; // last
        while (i <= j) {
            if (str[i] != str[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
