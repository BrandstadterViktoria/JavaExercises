package Part_II;

import edu.princeton.cs.algs4.SET;
import java.util.ArrayList;
import java.util.List;

public class BoggleSolver {

    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    private SET<String> dictonary = new SET<>();

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

        private boolean[] marked;
        private SET<String> validWords = new SET<>();
        private BoggleBoard board;

        public DFS(BoggleBoard board) {
            this.board = board;
            marked = new boolean[board.rows() * board.cols()];
            dfs();
        }

        private void dfs() {
            for (int i = 0; i < board.rows(); i++) {
                for (int j = 0; j < board.cols(); j++) {
                    singleSourceDFS(i, j);
                }
            }
        }

        private SET<String> singleSourceDFS(int row, int col) {
            marked


        }

        private List<int []> adj (int row, int col) {
            validate(row,col);
            List<int[]> adj = new ArrayList<>();
            if (validate(row, col - 1)) {
                adj.add(new int[] {row, col - 1});
            }
            if (validate(row, col + 1)){
                adj.add(new int[] {row, col + 1});
            }
            if (validate(row - 1, col)) {
                adj.add(new int[] {row - 1, col});
            }
            if (validate(row - 1, col - 1)) {
                adj.add(new int[]{row - 1, col - 1});
            }
            if (validate(row - 1, col + 1)) {
                adj.add(new int[]{row - 1, col + 1});
            }
            if (validate(row + 1, col)) {
                adj.add(new int[]{row + 1, col});
            }
            if (validate(row + 1, col - 1)) {
                adj.add(new int[]{row + 1, col - 1});
            }
            if (validate(row + 1, col + 1)) {
                adj.add(new int[]{row + 1, col + 1});
            }

            return adj;
        }

        private boolean validate (int row, int col) {
            return row < 0 || row >= board.rows() || col < 0 || col >= board.cols();
        }
    }
}
