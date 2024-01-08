package com.example.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.stage.StageStyle;

import java.io.IOException;

public class TicTacToe extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TicTacToe.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 282, 313);
        stage.getIcons().add(new Image("D:\\Файлы для учебы\\Программирование\\Tic-Tac-Toe\\src\\main\\resources\\com\\example\\tictactoe\\images\\tic-tac-toe.png"));
        stage.setTitle("Tic-Tac-Toe");
        stage.initStyle(StageStyle.UTILITY);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}