import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;
import java.util.Stack;

public class Solver {

    private int moves = 0;
    private Stack<Board> solutionBoardStack = new Stack<>();
    private MinPQ<SearchNode> priorityQue = new MinPQ<>(Comparator.comparingInt(searchNode -> searchNode.priority));

    public class SearchNode {
        Board board;
        int priority;
        SearchNode predecessor;


        public SearchNode(Board board, SearchNode predecessor) {
            this.board = board;
            this.predecessor = predecessor;
            priority = board.manhattan() + moves;
        }

    }

    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException();
        }
        MinPQ<SearchNode> priorityQueTwin = new MinPQ<>(Comparator.comparingInt(searchNode -> searchNode.priority));
        SearchNode current = new SearchNode(initial, null);
        SearchNode currentTwin = new SearchNode(initial.twin(),null);
        while (!current.board.isGoal()) {
            moves++;
            for (Board neighbor : current.board.neighbors()) {
                if ((current.predecessor == null) || !current.predecessor.board.equals(neighbor)) {
                    SearchNode newSearchNode = new SearchNode(neighbor, current);
                    priorityQue.insert(newSearchNode);
                }
            }
            current = priorityQue.delMin();
        }

        while (current != null) {
            solutionBoardStack.push(current.board);
            current = current.predecessor;
        }

        while (!currentTwin.board.isGoal()) {
            moves++;
            for (Board neighbor : currentTwin.board.neighbors()) {
                if ((currentTwin.predecessor == null) || !currentTwin.predecessor.board.equals(neighbor)) {
                    SearchNode newSearchNode = new SearchNode(neighbor, currentTwin);
                    priorityQueTwin.insert(newSearchNode);
                }
            }
            currentTwin = priorityQueTwin.delMin();
        }
    }


    public boolean isSolvable() {
        priorityQue.min().board.isGoal();
        return true;
    }


    public int moves() {
        if (!isSolvable()) {
            return -1;
        } else {
            return solutionBoardStack.size();
        }
    }

    public Iterable<Board> solution() {
        if (!isSolvable()) {
            return null;
        } else {
            return solutionBoardStack;
        }
    }

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


