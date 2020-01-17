package sample;

import Modele.Jeu;
import Modele.ObstacleCarre;
import Modele.Partie;
import Modele.Personnage;
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


    public static final Jeu monJeu = new Jeu(new Partie(new Personnage()));
    public static final JeuView leJeu = new JeuView();

    @Override
    public void start(Stage primaryStage) throws Exception{

            System.out.println("ca marche");
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

            //j1.getPartie().GeneretEtAjouterObstacle();

            //System.out.println(monJeu.getPartie().getListeObstacle());

    }


    public static void main(String[] args) {
        launch(args);
    }


}
