package com.sirsavage.sudoku.buildlogic;

import java.io.IOException;

import com.sirsavage.sudoku.computationlogic.GameLogic;
import com.sirsavage.sudoku.persistence.LocalStorageImpl;
import com.sirsavage.sudoku.problemdomain.IStorage;
import com.sirsavage.sudoku.problemdomain.SudokuGame;
import com.sirsavage.sudoku.userinterface.IUserInterfaceContract;
import com.sirsavage.sudoku.userinterface.logic.ControlLogic;

public class SudokuBuildLogic {

    public static void build(IUserInterfaceContract.View userInterface) throws IOException {
        SudokuGame initialState;
        IStorage storage = new LocalStorageImpl();

        try {
            //will throw if no game data is found in local storage

            initialState = storage.getGameData();
        } catch (IOException e) {

            initialState = GameLogic.getNewGame();
            //this method below will throw an IOException if we cannot update the game data. Will create a new game.
            storage.updateGameData(initialState);
        }

        IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);
        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);
    }
}
