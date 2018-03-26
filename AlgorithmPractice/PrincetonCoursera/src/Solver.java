import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;
import java.util.Stack;

public class Solver {

    private MinPQ<SearchNode> priorityQue = new MinPQ<>(Comparator.comparingInt(searchNode -> searchNode.priority));
    private int moves = 0;
    private Stack<Board> solutionBoardStack = new Stack<>();


    public class SearchNode {
        Board board;
        int priority;
        SearchNode predecessor;


        public SearchNode(Board board, SearchNode predecessor) {
            this.board = board;
            this.predecessor = predecessor;
            priority = board.manhattan() + moves;
        }

        public SearchNode(Board board) {
            this.board = board;
        }
    }

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException();
        }
        MinPQ<SearchNode> priorityQueTwin = new MinPQ<>(Comparator.comparingInt(searchNode -> searchNode.priority));
        SearchNode initialNode = new SearchNode(initial);
        SearchNode next = initialNode;
        solutionBoardStack.push(initial);
        while (!next.board.isGoal()) {
            moves++;
            for (Board neighbor : next.board.neighbors()) {
                if (!solutionBoardStack.contains(neighbor)) {
                    SearchNode newSearchNode = new SearchNode(neighbor, next);
                    priorityQue.insert(newSearchNode);
                }
            }
            next = priorityQue.delMin();
            solutionBoardStack.push(next.board);
        }

    }

    // is the initial board solvable?
    public boolean isSolvable() {
        priorityQue.min().board.isGoal();
        return true;

    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (!isSolvable()) {
            return -1;
        } else {
            return moves;
        }
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (!isSolvable()) {
            return null;
        } else {
            return solutionBoardStack;
        }
    }

    // solve a slider puzzle (given below)
    public static void main(String[] args) {

        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);

        }
    }
}

