package sample;

import Modele.Jeu;
import Modele.Partie;
import Vue.JeuView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {




    @Override
    public void start(Stage primaryStage) throws Exception{

            System.out.println("ca marche");
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

            Partie p1=new Partie(300);
            p1.GeneretEtAjouterObstacle();
            p1.GeneretEtAjouterObstacle();


            System.out.println(p1.getListeObstacle());

/*
       JeuView leJeu = new JeuView();
        primaryStage.setTitle("Runner");
        primaryStage.setWidth(1100);
        primaryStage.setHeight(700);
        primaryStage.setResizable(false);
        primaryStage.setScene(leJeu.getGamePane());
        primaryStage.show();
*/


        /*Piste p1 = new Piste(10,new bonhomme(new Color(0.5,0.5,0.5,0.5),100,100));
        p1.ajouterGoupeObstacle(p1.genererGroupeObstacle());
        System.out.println(p1.toString());

        Personnage p2=new bonhomme(new Color(0.5,0.5,0.5,0.5),100,100);
        System.out.println(p2);
        p2.sauter();
        System.out.println(p2);*/
    }


    public static void main(String[] args) {
        launch(args);
    }


}
