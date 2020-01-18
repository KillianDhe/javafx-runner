package sample;

import Modele.*;
import Vue.JeuView;
import Vue.ObstacleCarreView;
import Vue.PersonnageView;
import Vue.PisteView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {


    public static  Manager monJeu ;
    public static JeuView leJeu;

    @Override
    public void start(Stage primaryStage) throws Exception{


            SauvegardeBin sauvegardeBin=new SauvegardeBin();
            monJeu=new Manager(sauvegardeBin);
            monJeu.charger();
            leJeu=new JeuView();

            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
