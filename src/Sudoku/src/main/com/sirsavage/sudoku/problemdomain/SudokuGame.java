package com.sirsavage.sudoku.problemdomain;

import java.io.Serializable;

import com.sirsavage.sudoku.computationlogic.SudokuUtilities;
import com.sirsavage.sudoku.constants.GameState;

public class SudokuGame implements Serializable {
    private final GameState gameState;
    private final int[][] gridState;

    /**
     * To make it easier to work with Arrays (where the first index position is 0 instead of 1, and so on),
     * Grid coordinates will be represented with x and y index values ranging from 0 (inclusive) to 8 (inclusive).
     */
    public static final int GRID_BOUNDARY = 9;

    /**
     * I suppose that the most fundamental states required to represent a sudoku game, are an active state and a
     * complete state. The game will start in Active state, and when a Complete state is achieved (based on GameLogic),
     * then a special UI screen will be displayed by the user interface.
     * To avoid Shared Mutable State (Shared change-able data), which causes many problems, I have decided to make this
     * class Immutable (meaning that once I created an instance of it, the values may only be read via getGameState()
     * and getGridState() functions, a.k.a. methods. Each time the gridState changes, a new SudokuGame object is created
     * by taking the old one, applying some functions to each, and generated a new one.
     */
    public SudokuGame(GameState gameState, int[][] gridState) {
        this.gameState = gameState;
        this.gridState = gridState;
    }

    public GameState getGameState() {
        return gameState;
    }

    public int[][] getCopyOfGridState() {
        return SudokuUtilities.copyToNewArray(gridState);
    }

}
