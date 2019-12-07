package sample;

import Vue.JeuView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        JeuView leJeu = new JeuView();
        primaryStage.setTitle("Runner");
        primaryStage.setWidth(1100);
        primaryStage.setHeight(700);
        primaryStage.setResizable(false);
        primaryStage.setScene(leJeu.getGamePane());
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
