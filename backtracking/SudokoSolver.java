package backtracking;

public class SudokoSolver {
    public static void main(String[] args) {
        int board[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        sudokoSolve(board, 0, 0);
    }

    static void sudokoSolve(int board[][], int row, int col) {
        if (row == board.length) {
            display(board);
            return;
        }
        int ri = 0;
        int rj = 0;
        if (col == board[0].length - 1) {
            ri = row + 1;
            rj = 0;
        } else {
            ri = row;
            rj = col + 1;
        }

        if (board[row][col] != 0) {
            sudokoSolve(board, ri, rj);
        } else {
            for (int op = 1; op <= 9; op++) {
                // func to check is number is present in horizontal or vertical or 3*3 matrix
                // if it returns true it will check for other number
                if (isValidPlace(board, row, col, op)) {
                    board[row][col] = op;
                    sudokoSolve(board, ri, rj);
                    board[row][col] = 0;
                }
            }

        }

    }

    static boolean isValidPlace(int board[][], int row, int col, int op) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == op)
                return false;
        }
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == op)
                return false;
        }

        int rm = row / 3 * 3;
        int cm = col / 3 * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[rm + i][cm + j] == op)
                    return false;
            }
        }

        return true;
    }

    static void display(int board[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
