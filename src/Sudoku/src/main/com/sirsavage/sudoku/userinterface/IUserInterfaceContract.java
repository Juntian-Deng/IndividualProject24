package com.sirsavage.sudoku.userinterface;

import com.sirsavage.sudoku.problemdomain.SudokuGame;

public interface IUserInterfaceContract {
    interface EventListener {
        void onSudokuInput(int x, int y, int input);
        void onDialogClick();
    }

    interface View {
        void setListener(IUserInterfaceContract.EventListener listener);
        //update a single square after user input
        void updateSquare(int x, int y, int input);

        //update the entire board
        void updateBoard(SudokuGame game);
        void showDialog(String message);
        void showError(String message);
    }
}
