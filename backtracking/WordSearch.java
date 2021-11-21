package backtracking;

// Leetcode ques [79] : here we have to find word in 2d array and we can go in four dirextions(top,bottom,left,right)

public class WordSearch {
    public static void main(String[] args) {
        char board[][] = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "BFDE";
        boolean isPresent = isWord(board, word);
        System.out.println(isPresent);
    }

    static boolean isWord(char[][] board, String word) {

        boolean isVisited[][] = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean isFound = getWord(board, word, i, j, isVisited);
                    if (isFound) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    static boolean getWord(char board[][], String word, int row, int col, boolean isVisited[][]) {
        if (word.length() == 0) {
            return true;
        }

        if (row < 0 || col < 0 || row > board.length - 1 || col > board[0].length - 1 || isVisited[row][col] == true) {
            return false;
        }

        char ch = word.charAt(0);

        if (ch == board[row][col]) {
            isVisited[row][col] = true;

            boolean ans = getWord(board, word.substring(1), row, col + 1, isVisited)
                    || getWord(board, word.substring(1), row, col - 1, isVisited)
                    || getWord(board, word.substring(1), row - 1, col, isVisited)
                    || getWord(board, word.substring(1), row + 1, col, isVisited);

            isVisited[row][col] = false;
            return ans;
        } else {
            return false;
        }

    }

}
