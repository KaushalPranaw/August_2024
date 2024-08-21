package Matrix;

import java.util.HashSet;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '4', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(new ValidSudoku().isValidSudoku(board));

    }

    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    if (!seen.add(ch + " in row " + i) ||
                            !seen.add(ch + " in col " + j) || !seen.add(ch + " in box " + (i / 3) + "-" + (j / 3)))
                        return false;
                }
            }
        }
        return true;

    }
}
