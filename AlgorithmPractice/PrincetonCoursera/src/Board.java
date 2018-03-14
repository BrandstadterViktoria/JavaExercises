import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdRandom;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private final int[] blockArray;
    private final int dimension;
    private final int[][] blocks;

    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks) {
        this.blocks = blocks;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                list.add(blocks[i][j]);
            }
        }
        this.blockArray = new int[list.size()];
        for (int i = 0; i < blockArray.length; i++) {
            blockArray[i] = list.get(i);
        }
        this.dimension = blocks.length;
    }

    // board dimension n
    public int dimension() {
        return dimension;

    }

    // number of blocks out of place
    public int hamming() {
        int diff = 0;
        int hamming;
        for (int i = 1; i <= 8; i++) {
            if (blockArray[i] != i) {
                diff++;
            }
        }
        int moves = 0;
        hamming = moves + diff;
        return hamming;
    }

    // sum of Manhattan distances between blocks and goal
 /*   public int manhattan() {


    }*/

    // is this board the goal board?
    public boolean isGoal() {
        boolean isGoal = false;
        for (int i = 1; i < blockArray.length; i++) {
            if (i == blockArray[i - 1]) {
                isGoal = true;
                continue;
            } else {
                isGoal = false;
                break;
            }
        }
        return isGoal;
    }


    // a board that is obtained by exchanging any pair of blocks
    public Board twin() {
        int[] arrayOfTwinBoard = this.blockArray;
        int toSwap1 = StdRandom.uniform(1, 9);
        int toSwap2 = StdRandom.uniform(1, 9);
        while (toSwap1 == toSwap2) {
          toSwap2 = StdRandom.uniform(1, 9);
        }
        arrayOfTwinBoard = swap(toSwap1,toSwap2);

        int[][] twinBoard = new int[dimension()][dimension()];
        for (int row = 0; row < dimension(); row++) {
            for (int col = 0; col < dimension(); col++) {
                twinBoard[row][col] = arrayOfTwinBoard[col + row * dimension()];
            }
        }
        return new Board(twinBoard);
    }

    // does this board equal y?
    public boolean equals(Object y) {
        boolean equals = false;
        if (y == this) {
            equals = true;
        }
        if (y == null) {
            equals = false;
        }
        if (y.getClass() != this.getClass()) {
            equals = false;
        }

        return equals;
    }
    // all neighboring boards
    public Iterable<Board> neighbors() {
        Stack<Board> boardStack = new Stack<>();
        if (blockArray[0] == 0){
            Board n0 = newBoardFrom1DArray(swap(0, 1));
            Board n1 = newBoardFrom1DArray(swap(0,3));
            boardStack.push(n0);
            boardStack.push(n1);
        }
        if (blockArray[1] == 0){
            Board n0 = newBoardFrom1DArray(swap(1, 0));
            Board n1 = newBoardFrom1DArray(swap(1,2));
            Board n2 = newBoardFrom1DArray(swap(1,4));
            boardStack.push(n0);
            boardStack.push(n1);
            boardStack.push(n2);
        }
        if (blockArray[2] == 0) {
            Board n0 = newBoardFrom1DArray(swap(2, 1));
            Board n1 = newBoardFrom1DArray(swap(2,5));
            boardStack.push(n0);
            boardStack.push(n1);
        }
        if (blockArray[3] == 0) {
            Board n0 = newBoardFrom1DArray(swap(3, 0));
            Board n1 = newBoardFrom1DArray(swap(3, 4));
            Board n2 = newBoardFrom1DArray(swap(3, 6));
            boardStack.push(n0);
            boardStack.push(n1);
            boardStack.push(n2);
        }
        if (blockArray[4] == 0) {
            Board n0 = newBoardFrom1DArray(swap(4, 1));
            Board n1 = newBoardFrom1DArray(swap(4, 3));
            Board n2 = newBoardFrom1DArray(swap(4, 5));
            Board n3 = newBoardFrom1DArray(swap(4, 7));
            boardStack.push(n0);
            boardStack.push(n1);
            boardStack.push(n2);
            boardStack.push(n3);
        }
        if (blockArray[5] == 0) {
            Board n0 = newBoardFrom1DArray(swap(5, 2));
            Board n1 = newBoardFrom1DArray(swap(5, 4));
            Board n2 = newBoardFrom1DArray(swap(5, 8));
            boardStack.push(n0);
            boardStack.push(n1);
            boardStack.push(n2);
        }
        if (blockArray[6] == 0) {
            Board n0 = newBoardFrom1DArray(swap(6, 3));
            Board n1 = newBoardFrom1DArray(swap(6, 7));
            boardStack.push(n0);
            boardStack.push(n1);
        }
        if (blockArray[7] == 0) {
            Board n0 = newBoardFrom1DArray(swap(7, 4));
            Board n1 = newBoardFrom1DArray(swap(7,8));
            boardStack.push(n0);
            boardStack.push(n1);
        }
        if (blockArray[8] == 0) {
            Board n0 = newBoardFrom1DArray(swap(8, 5));
            Board n1 = newBoardFrom1DArray(swap(8, 7));
            boardStack.push(n0);
            boardStack.push(n1);
        }



        return boardStack;
    }
//
//    // string representation of this board (in the output format specified below)
//    public String toString() {
//    }


    public int[] getBlockArray() {
        return blockArray;
    }
    private int [] swap(int toSwap, int goalIndexForSwap){
        int [] swapped = this.blockArray;
        int temp = swapped[goalIndexForSwap];
        swapped[goalIndexForSwap] = 0;
        swapped[toSwap] = temp;
        return swapped;
    }

    private Board newBoardFrom1DArray(int [] arrayToConvert) {
        int[][] newBoard = new int[dimension()][dimension()];
        for (int row = 0; row < dimension(); row++) {
            for (int col = 0; col < dimension(); col++) {
                newBoard[row][col] = arrayToConvert[col + row * dimension()];
            }
        }
        return new Board(newBoard);
    }

    public static void main(String[] args) {

        //testing the constructor
        int[][] blocks = new int[][]{
                {0, 5, 2},
                {4, 1, 6},
                {3, 7, 8}
        };

        Board board = new Board(blocks);
        for (int n : board.twin().getBlockArray()) {
            System.out.println(n);
        }
//        System.out.println(board.isGoal());

    }
}


