package sample;

import Modele.ObstacleCarre;
import Modele.constantes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        int coucou;
        coucou=constantes.getHauteurSaut();
        System.out.println(coucou);
        System.out.println(coucou);
        System.out.println(coucou);
    }


    public static void main(String[] args) {
        launch(args);
    }


}
