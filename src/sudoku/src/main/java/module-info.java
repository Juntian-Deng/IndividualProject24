module sudoku.problemdomain {
    requires javafx.controls;
    requires javafx.fxml;

    opens sudoku.problemdomain to javafx.fxml;
    exports sudoku.problemdomain;
}
