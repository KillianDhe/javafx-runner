package sample;

import Modele.GroupeObstacle;
import Modele.ObstacleCarre;
import Modele.Piste;
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
    public void start(Stage primaryStage) throws Exception {
        Piste p1 = new Piste(10, 10);
        p1.ajouterGoupeObstacle(p1.genererGroupeObstacle());
        System.out.println(p1.toString());
    }

    public static void main(String[] args) {
        launch(args);
    }


}
