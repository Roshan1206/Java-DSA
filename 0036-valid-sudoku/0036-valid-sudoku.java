class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check columns
        for(int row=0; row<board.length; row++){
            Set<Character> seen = new HashSet<Character>();
            for(int col=0; col<board[row].length; col++){
                if(board[row][col] == '.') continue;
                if(seen.contains(board[row][col])) return false;
                seen.add(board[row][col]);
            }
        }

        // check rows
        for(int col=0; col<board.length; col++){
            Set<Character> seen = new HashSet<Character>();
            for(int row=0; row<board[col].length; row++){
                if(board[row][col] == '.') continue;
                if(seen.contains(board[row][col])) return false;
                seen.add(board[row][col]);
            }
        }

        // check squares
        for(int sq=0; sq<board.length; sq++){
            Set<Character> seen = new HashSet<Character>();
            for(int i=0; i<board.length/3; i++){
                int row = (sq/3)*3 + i;
                for(int j=0; j<3; j++){
                    int col = (sq%3)*3 + j;
                    if(board[row][col] == '.') continue;
                    if(seen.contains(board[row][col])) return false;
                    seen.add(board[row][col]);
                }
            }            
        }
        return true;
    }
}