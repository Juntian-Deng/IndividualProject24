package com.sirsavage.sudoku;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

import com.sirsavage.sudoku.buildlogic.SudokuBuildLogic;
import com.sirsavage.sudoku.userinterface.IUserInterfaceContract;
import com.sirsavage.sudoku.userinterface.UserInterfaceImpl;

/**
 * This class is the Root Container (the thing which attends to all of the primary objects which must communicate when
 * the program is running (a running program is called a "process").
 */
public class SudokuApplication extends Application {
    private IUserInterfaceContract.View uiImpl;

    @Override
    public void start(Stage primaryStage) throws IOException {
        //Get SudokuGame object for a new game
        uiImpl = new UserInterfaceImpl(primaryStage);

        try {
            SudokuBuildLogic.build(uiImpl);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
