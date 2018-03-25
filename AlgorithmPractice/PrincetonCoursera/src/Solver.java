import edu.princeton.cs.algs4.MinPQ;
import java.util.Comparator;
import java.util.Stack;

public class Solver {

    private MinPQ<SearchNode> priorityQue = new MinPQ<>(Comparator.comparingInt(searchNode -> searchNode.priority));
    private int movesSolver = 0;
    private Stack<Board> solutionBoardStack = new Stack<>();


    public class SearchNode {
        Board boardNode;
        int moves;
        int priority;
        SearchNode predecessor;


        public SearchNode(Board boardNode, SearchNode predecessor) {
            this.boardNode = boardNode;
            this.predecessor = predecessor;
            this.moves = ++predecessor.moves;
            priority = boardNode.manhattan() + moves;
        }

        public SearchNode(Board boardNode) {
            this.boardNode = boardNode;
        }
    }

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException();
        }
        MinPQ<SearchNode> priorityQueTwin = new MinPQ<>(Comparator.comparingInt(searchNode -> searchNode.priority));
        SearchNode initialNode = new SearchNode(initial);
        SearchNode initialTwin = new SearchNode(initial.twin());
        SearchNode next = initialNode;
        SearchNode nextTwin = initialTwin;
        while (!next.boardNode.isGoal() || !nextTwin.boardNode.isGoal()) {
            Stack<Board> stackOfBoards = new Stack<>();
            for (Board neighbor : next.boardNode.neighbors()) {
                stackOfBoards.push(neighbor);
            }
            while (!stackOfBoards.isEmpty()) {
                SearchNode newNode = new SearchNode(stackOfBoards.pop(), next);
                if (!newNode.boardNode.equals(newNode.predecessor.boardNode)) {
                    priorityQue.insert(newNode);
                }
            }
            stackOfBoards.push(priorityQue.delMin().boardNode);
            next = priorityQue.delMin();
            movesSolver++;

            Stack<Board> stackOfTwinBoards = new Stack<>();
            for (Board neighbor : nextTwin.boardNode.neighbors()) {
                stackOfTwinBoards.push(neighbor);
            }
            while (!stackOfTwinBoards.isEmpty()) {
                SearchNode newNode = new SearchNode(stackOfTwinBoards.pop(), next);
                if (!newNode.boardNode.equals(newNode.predecessor.boardNode)) {
                    priorityQueTwin.insert(newNode);
                }
            }
            nextTwin = priorityQueTwin.delMin();

        }
    }

    // is the initial board solvable?
    public boolean isSolvable() {
        priorityQue.min().boardNode.isGoal();
        return true;

    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (!isSolvable()) {
            return -1;
        } else {
            return movesSolver;
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

    }
}

