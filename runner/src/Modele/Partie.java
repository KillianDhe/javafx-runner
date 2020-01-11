package Modele;

import Vue.ObstacleCarreView;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Partie {

    private ObservableList<Obstacle> listeObstacle= FXCollections.observableArrayList();
    private Personnage personnage;

    //private GenerateurObstacle generateurObstacle=new GenerateurObstacle();


    public Partie(Personnage p) {
        listeObstacle.add(GenerateurObstacle.genererObstacle(null));
        this.personnage=p;
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

    public void Rafraichir(){
        AnimationTimer gameLoop = new AnimationTimer() {
            long old=0;
            double dt;
            @Override
            public void handle(long l) {
                dt=(double)(l-old)/100000000;
                personnage.refreshPosition(dt);
                for(Obstacle obstacle: listeObstacle){
                    obstacle.move();
                }

                Random r = new Random();
                if (r.nextInt(140) == 50) {

                        listeObstacle.add(GenerateurObstacle.genererObstacle(listeObstacle.get(listeObstacle.size()-1)));

                    }

                old=l;
            }

        };
        gameLoop.start();
    }
}