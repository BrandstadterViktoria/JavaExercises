package Week4_8puzzle;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Board {

    private final int dimension;
    private final int[][] blocks;
    private int manhattan = 0;
    private int blankPositionRow = 0;
    private int blankPositionCol = 0;
    private Board twin;
    private boolean done = false;
    private int hamming = 0;


    public Board(int[][] blocks) {
        this.blocks = blocks;
        this.dimension = blocks.length;
        int goalRow = 0;
        int goalColumn = 0;
        int currentElementOfBlockArray = 1;
        while (currentElementOfBlockArray <= dimension * dimension - 1) {
            for (int i = 0; i < blocks.length; i++) {
                for (int j = 0; j < blocks[i].length; j++) {
                    if (blocks[i][j] == currentElementOfBlockArray) {
                        int currentManhattan = Math.abs(i - goalRow) + Math.abs(j - goalColumn);
                        if (currentManhattan > 0) {
                            hamming++;
                        }
                        this.manhattan += currentManhattan;
                        currentElementOfBlockArray++;
                        goalRow = (currentElementOfBlockArray - 1) / dimension;
                        goalColumn = (currentElementOfBlockArray - 1) - (goalRow * dimension);
                        i = -1;
                        break;
                    }
                }

            }
        }
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                if (blocks[i][j] == 0) {
                    blankPositionRow = i;
                    blankPositionCol = j;
                }
            }
        }
    }


    public int dimension() {
        return dimension;

    }

    public int hamming() {
        return hamming;
    }


    public int manhattan() {
        return this.manhattan;
    }


    public boolean isGoal() {
        return manhattan == 0;

//        boolean isGoal = false;
//        int [] blockArray = new int [dimension * dimension];
//        for (int i = 0; i < blocks.length; i++) {
//            for (int j = 0; j < blocks[i].length; j++) {
//                blockArray[j + (i * dimension)] = blocks[i][j];
//            }
//        }
//        for (int i = 1; i < blockArray.length; i++) {
//            if (i == blockArray[i - 1]) {
//                isGoal = true;
//                continue;
//            } else {
//                isGoal = false;
//                break;
//            }
//        }
//        return isGoal;
    }


    public Board twin() {
        while (!done) {
            int toSwap1 = StdRandom.uniform(0, dimension);
            int toSwap2 = StdRandom.uniform(0, dimension);
            int toSwap3 = StdRandom.uniform(0, dimension);
            int toSwap4 = StdRandom.uniform(0, dimension);
            while (toSwap1 == toSwap3 && toSwap2 == toSwap4) {
                toSwap3 = StdRandom.uniform(0, dimension);
                toSwap4 = StdRandom.uniform(0, dimension);
            }
            int[][] arrayOfTwinBoard = swap(toSwap1, toSwap2, toSwap3, toSwap4);
            twin = new Board(arrayOfTwinBoard);
            done = true;
        }

        return twin;
    }

    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        Board compare = (Board) y;
        return Arrays.deepEquals(compare.blocks, this.blocks);
    }

    public Iterable<Board> neighbors() {
        Stack<Board> neighbors = new Stack<>();
        if (blankPositionRow != dimension - 1 && blankPositionRow >= 0) {
            neighbors.push(new Board(swap(blankPositionRow,blankPositionCol, blankPositionRow + 1,blankPositionCol)));
        }
        if (blankPositionRow != 0 && blankPositionRow <= dimension - 1) {
            neighbors.push(new Board((swap(blankPositionRow, blankPositionCol, blankPositionRow - 1, blankPositionCol))));
        }
        if (blankPositionCol != dimension - 1 && blankPositionCol >= 0) {
            neighbors.push(new Board(swap(blankPositionRow,blankPositionCol, blankPositionRow,blankPositionCol + 1)));
        }
        if (blankPositionCol != 0 && blankPositionCol <= dimension - 1) {
            neighbors.push(new Board(swap(blankPositionRow,blankPositionCol, blankPositionRow,blankPositionCol - 1)));
        }

        return neighbors;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(dimension + "\n");
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                s.append(String.format("%2d ", blocks[i][j]));
            }
            s.append("\n");
        }
        return s.toString();

    }

    private int[][] swap(int toSwapRow, int toSwapColumn, int goalIndexForSwapRoow, int goalIndexForSwapCol) {
     int swapped [][] = new int [dimension][dimension];
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                swapped[i][j] = blocks[i][j];
            }
        }
        int temp = swapped[goalIndexForSwapRoow][goalIndexForSwapCol];
        swapped[goalIndexForSwapRoow][goalIndexForSwapCol] = swapped[toSwapRow][toSwapColumn];
        swapped[toSwapRow][toSwapColumn] = temp;
        return swapped;
    }


    public static void main(String[] args) {
        // empty method intentionally



    }
}


