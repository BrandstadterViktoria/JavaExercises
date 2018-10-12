package Part_II.Week4_BoogleSolver;

import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.TrieSET;

public class BoggleSolver {

    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    private TrieSET dictonary = new TrieSET();

    public BoggleSolver(String[] dictionary) {
        for (int i = 0; i < dictionary.length; i++) {
            this.dictonary.add(dictionary[i]);

        }
    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    public Iterable<String> getAllValidWords(BoggleBoard board) {
        DFS dfs = new DFS(board);


    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)

    public int scoreOf(String word) {

    }

    public class DFS {

        private boolean[][] marked;
        private SET<String> validWords = new SET<>();
        private BoggleBoard board;

        DFS(BoggleBoard board) {
            this.board = board;
            marked = new boolean[board.rows()][board.cols()];
            for (int i = 0; i < board.rows(); i++) {
                for (int j = 0; j < board.cols(); j++) {
                    StringBuilder strb = new StringBuilder();
                    strb.append(board.getLetter(i, j));
                    dfs (i, j, strb);
                }
            }
        }

        private SET<String> dfs (int row, int col, StringBuilder strb) {
            int[][] adj = adj(row, col);
            marked[row][col] = true;
            for (int i = 0; i < adj.length; i++) {
                strb.append(board.getLetter(adj[i][0], adj[i][1]));
                String prefix = strb.toString();
                if (dictonary.keysThatMatch(prefix).iterator().hasNext()) {

                }
                if (dictonary.keysWithPrefix(prefix).iterator().hasNext()) {
                    dfs (adj[i][0], adj[i][1], strb);
                }

                else {
                    break;
                }

            }
        }


        private int[][] adj(int row, int col) {
            int[][] adj = new int[8][2];
            adj[0] = new int[]{row, col - 1};
            adj[1] = new int[]{row, col + 1};
            adj[2] = new int[]{row - 1, col - 1};
            adj[3] = new int[]{row - 1, col};
            adj[4] = new int[]{row - 1, col + 1};
            adj[5] = new int[]{row + 1, col - 1};
            adj[6] = new int[]{row + 1, col};
            adj[7] = new int[]{row + 1, col + 1};
            for (int i = 0; i < adj.length; i++) {
                for (int j = 0; j < 3; j++) {
                    if (j % 2 == 0 && !validateR(adj[i][j])) {
                        adj[i][j] = Integer.MAX_VALUE;
                    }
                    if (!(j % 2 == 0) && !validateC(adj[i][j])) {
                        adj[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
            return adj;
        }

        private boolean validateR(int row) {
            return row < 0 || row >= board.rows();
        }

        private boolean validateC(int col) {
            return col < 0 || col >= board.cols();
        }
    }
}
