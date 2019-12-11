package sample;

import Modele.*;
import Vue.JeuView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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

        Piste p1 = new Piste(10,new bonhomme(new Color(0.5,0.5,0.5,0.5),100,100));
        p1.ajouterGoupeObstacle(p1.genererGroupeObstacle());
        System.out.println(p1.toString());

        Personnage p2=new bonhomme(new Color(0.5,0.5,0.5,0.5),100,100);
        System.out.println(p2);
        p2.sauter();
        System.out.println(p2);
    }


    public static void main(String[] args) {
        launch(args);
    }


}
