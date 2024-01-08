package com.example.tictactoe;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.DepthTest;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    private char Symbol = 'x';
    private char gameField[][] = new char [3][3];
    private boolean isGame = true;
    private boolean GameWin = false;
    private GridPane GridPane;
    @FXML
    void buttonClick(ActionEvent event) {
        Button btn = (Button)event.getSource();

        if(!isGame || btn.getText() != "") return;

        int rowIndex = GridPane.getRowIndex(btn) == null ? 0 : GridPane.getRowIndex(btn);
        int colomnIndex = GridPane.getColumnIndex(btn)== null ? 0 : GridPane.getColumnIndex(btn);

        gameField[rowIndex][colomnIndex] = Symbol;

        btn.setText(String.valueOf(Symbol));
        boolean emptyFieldsExist = true;

        while(emptyFieldsExist && !GameWin) {

            if (
                    (gameField[0][0] == 'o' && gameField[0][1] == 'o' && gameField[0][2] == 'o') ||
                            (gameField[1][0] == 'o' && gameField[1][1] == 'o' && gameField[1][2] == 'o') ||
                            (gameField[2][0] == 'o' && gameField[2][1] == 'o' && gameField[2][2] == 'o') ||
                            (gameField[0][0] == 'o' && gameField[1][0] == 'o' && gameField[2][0] == 'o') ||
                            (gameField[0][1] == 'o' && gameField[1][1] == 'o' && gameField[2][1] == 'o') ||
                            (gameField[0][2] == 'o' && gameField[1][2] == 'o' && gameField[2][2] == 'o') ||
                            (gameField[0][0] == 'o' && gameField[1][1] == 'o' && gameField[2][2] == 'o') ||
                            (gameField[0][2] == 'o' && gameField[1][1] == 'o' && gameField[2][0] == 'o')
            ) {
                isGame = false;
                GameWin = true;
                Alert alert = new Alert(Alert.AlertType.NONE, "o is the winner!", ButtonType.OK);
                alert.showAndWait();
            } else if (
                    (gameField[0][0] == 'x' && gameField[0][1] == 'x' && gameField[0][2] == 'x') ||
                            (gameField[1][0] == 'x' && gameField[1][1] == 'x' && gameField[1][2] == 'x') ||
                            (gameField[2][0] == 'x' && gameField[2][1] == 'x' && gameField[2][2] == 'x') ||
                            (gameField[0][0] == 'x' && gameField[1][0] == 'x' && gameField[2][0] == 'x') ||
                            (gameField[0][1] == 'x' && gameField[1][1] == 'x' && gameField[2][1] == 'x') ||
                            (gameField[0][2] == 'x' && gameField[1][2] == 'x' && gameField[2][2] == 'x') ||
                            (gameField[0][0] == 'x' && gameField[1][1] == 'x' && gameField[2][2] == 'x') ||
                            (gameField[0][2] == 'x' && gameField[1][1] == 'x' && gameField[2][0] == 'x')) {
                isGame = false;
                GameWin = true;
                Alert alert = new Alert(Alert.AlertType.NONE, "x is the winner!", ButtonType.OK);
                alert.showAndWait();
            }
            if(GameWin){
                break;
            }
            emptyFieldsExist = false;

            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (gameField[row][col] == ' ') {
                        emptyFieldsExist = true;
                        break;
                    }
                }
                if (emptyFieldsExist && !GameWin) {
                    Alert alert = new Alert(Alert.AlertType.NONE, "Drawn!", ButtonType.OK);
                    alert.showAndWait();
                    break;
                }
            }
        }

        Symbol = Symbol == 'x'?'o':'x';
    }
    @FXML
    void buttonResetClick(ActionEvent event){
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                gameField[row][col] = ' ';
            }
        }

        for (Node button : GridPane.lookupAll(".button")) {
            button.setDepthTest(DepthTest.valueOf(" "));
        }

        isGame = true;
        GameWin = false;
        Symbol = 'x';
    }

    @FXML
    void initialize() {

    }

}
