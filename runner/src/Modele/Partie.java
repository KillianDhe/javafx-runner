package Modele;

import Vue.ObstacleCarreView;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Partie {

    private ObservableList<Obstacle> listeObstacle= FXCollections.observableArrayList();
    private Personnage personnage;
    private final IntegerProperty score = new SimpleIntegerProperty();
    public Integer getScore() {return score.get();}
    public IntegerProperty scoreProperty() {return score;}
    public void setScore(Integer score) {this.score.set(score);}


    public Partie(Personnage p) {
        listeObstacle.add(GenerateurObstacle.genererObstacle(null));
        this.personnage=p;
        score.set(0);
    }

    public ObservableList<Obstacle> getListeObstacle() {
        return listeObstacle;
    }

    public Personnage getPersonnage() {
        return personnage;
    }

    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }

    @Override
    public String toString() {
        return "Piste{" +
                ", listeGroupeObstacle=" + listeObstacle +
                ", personnage=" + personnage +
                '}';
    }



  /*  public void Reprendre(){

        gameLoop.start();
    }

    public void arreterRafraichir(){

        gameLoop.stop();
    }*/

    public void cleanObstacleList() {
        List<Obstacle> listeObstacleDelete = new ArrayList<>();
        listeObstacle.forEach(obstacleTmp ->   {
            if(!obstacleTmp.isOnScreen){
                listeObstacleDelete.add(obstacleTmp);
            }
        });
        listeObstacle.removeAll(listeObstacleDelete);
       /* System.out.println("Nb d'obstacles : " + listeObstacle.size());
        System.out.println("Nb obstacle on Screen : " +listeObstacle.stream().filter(obstacle -> {return obstacle.isOnScreen;}).count());

*/

    }


}