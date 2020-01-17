package Modele;

import Vue.ObstacleCarreView;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
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

    private final IntegerProperty meilleurScore = new SimpleIntegerProperty();
    public Integer getMeilleurScore() {return meilleurScore.get();}
    public IntegerProperty meilleurScoreProperty() {return meilleurScore;}
    public void setMeilleurScore(Integer score) {this.meilleurScore.set(score);}

    public Partie(Personnage p) {
        listeObstacle.add(GenerateurObstacle.genererObstacle(null));
        this.personnage=p;
        score.set(0);
        meilleurScore.set(0);
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

    public void cleanObstacleList() {
        List<Obstacle> listeObstacleDelete = new ArrayList<>();
        listeObstacle.forEach(obstacleTmp ->   {
            if(!obstacleTmp.isOnScreen){
                listeObstacleDelete.add(obstacleTmp);
                incrementerScore();
            }
        });
        listeObstacle.removeAll(listeObstacleDelete);
    }

    public void incrementerScore()
    {
        setScore(getScore()+1);
        if(getScore()>getMeilleurScore())
            setMeilleurScore(getScore());
    }

    public void perdre()
    {
        listeObstacle.clear();
      /*  setScore(0);*/
    }

    @Override
    public String toString() {
        return "Piste{" +
                ", listeGroupeObstacle=" + listeObstacle +
                ", personnage=" + personnage +
                '}';
    }
}