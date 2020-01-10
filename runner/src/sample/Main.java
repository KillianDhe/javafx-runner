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


    public static final Jeu monJeu = new Jeu();

    @Override
    public void start(Stage primaryStage) throws Exception{

            System.out.println("ca marche");
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            monJeu.setPartie(new Partie(new Personnage()));
            //j1.getPartie().GeneretEtAjouterObstacle();

            //System.out.println(monJeu.getPartie().getListeObstacle());





/*        PisteView pisteView = new PisteView(500);
        PersonnageView persoview = new PersonnageView(new Personnage(), new Image(getClass().getResource("/image/santa.png").toString()));
        ObstacleCarreView obstacleCarreView = new ObstacleCarreView(new ObstacleCarre(300, 450, 50), new Image(getClass().getResource("/image/cadeau.jpg").toString()));
        obstacleCarreView.getObstacleCarre().positionXProperty().set(100);
        System.out.println(obstacleCarreView.getPositionX());
        System.out.println(obstacleCarreView.getRectangle().getX());

       Partie p1=new Partie(new Personnage());
        p1.GeneretEtAjouterObstacle();
        p1.GeneretEtAjouterObstacle();
        p1.GeneretEtAjouterObstacle();
        p1.Rafraichir();*/


    }


    public static void main(String[] args) {
        launch(args);
    }


}
