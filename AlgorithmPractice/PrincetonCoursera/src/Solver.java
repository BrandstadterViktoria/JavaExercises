import edu.princeton.cs.algs4.MinPQ;

import java.util.Comparator;
import java.util.Stack;

public class Solver {

    private SearchNode next;

    public class SearchNode {
        Board boardNode;
        int moves;
        int priority;
        SearchNode predecessor;
        SearchNode next;

        public SearchNode(Board boardNode, SearchNode predecessor) {
            this.boardNode = boardNode;
            this.predecessor = predecessor;
            this.moves = ++predecessor.moves;
            priority = boardNode.manhattan() + moves;
        }
        public SearchNode(Board boardNode){
            this.boardNode = boardNode;
        }
    }

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException();
        }
        int[][] goal2DArray = new int[initial.dimension()][initial.dimension()];
        for (int row = 0; row < initial.dimension(); row++) {
            for (int col = 0; col < initial.dimension(); col++) {
                goal2DArray[row][col] = col + row * initial.dimension() + 1;
            }
        }
        SearchNode goalNode = new SearchNode(new Board(goal2DArray));
        MinPQ<SearchNode> priorityQue = new MinPQ<>(Comparator.comparingInt(searchNode -> searchNode.priority));
        SearchNode initialNode = new SearchNode(initial);
        this.next = initialNode;
        while (next.boardNode != goalNode.boardNode) {
            Stack<Board> stackOfBoards = new Stack<>();
            for (Board neighbor : next.boardNode.neighbors()) {
                stackOfBoards.push(neighbor);
            }
            while (!stackOfBoards.isEmpty()){
                SearchNode newNode = new SearchNode(stackOfBoards.pop(),next);
                if (!newNode.boardNode.equals(newNode.predecessor)) {
                    priorityQue.insert(newNode);
                } else {
                    continue;
                }
            }
            next = priorityQue.delMin();
        }

    }

    // is the initial board solvable?
    public boolean isSolvable() {

    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {

    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {

    }

    // solve a slider puzzle (given below)
    public static void main(String[] args) {

    }
}
