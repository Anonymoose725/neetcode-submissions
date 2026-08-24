class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> nonets = new HashMap<>(); 
        // (2 digit numbers encoded as xy from 00 -> 22)
        // ex. 11 would be the centre nonet

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char val = board[row][col];
                if (val == '.') continue; // empty space

                String nonet = "" + (row / 3) + (col / 3);

                // put if absent since the set doesnt exist unless i put it there
                rows.putIfAbsent(row, new HashSet<>());                
                cols.putIfAbsent(col, new HashSet<>());
                nonets.putIfAbsent(nonet, new HashSet<>());

                if (rows.get(row).contains(val)
                    || cols.get(col).contains(val)
                    || nonets.get(nonet).contains(val)) {
                        return false;
                    }
                else {
                    // add to seen-so-far maps
                    rows.get(row).add(val);
                    cols.get(col).add(val);
                    nonets.get(nonet).add(val);
                }
            }
        }
        return true; // no collisions
    }
}
