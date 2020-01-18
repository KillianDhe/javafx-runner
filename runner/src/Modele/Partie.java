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

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

    public class Partie implements Externalizable {

        private static final long serialVersionUID = 4683561297105055078L;

    private  ObservableList<Obstacle> listeObstacle= FXCollections.observableArrayList();
    private  Personnage personnage;

    private final IntegerProperty score = new SimpleIntegerProperty();
    public Integer getScore() {return score.get();}
    public IntegerProperty scoreProperty() {return score;}
    public void setScore(Integer score) {this.score.set(score);}

    private final IntegerProperty meilleurScore = new SimpleIntegerProperty();
    public Integer getMeilleurScore() {return meilleurScore.get();}
    public IntegerProperty meilleurScoreProperty() {return meilleurScore;}
    public void setMeilleurScore(Integer score) {this.meilleurScore.set(score);}

        public Partie() {
        personnage=new Personnage();
            score.set(0);
            meilleurScore.set(0);
            listeObstacle.add(GenerateurObstacle.genererObstacle(null));
        }


/*        public Partie(Personnage p) {
        listeObstacle.add(GenerateurObstacle.genererObstacle(null));
        this.personnage=p;

    }*/

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

    public void rejouer()
    {
        setScore(0);
    }


        @Override
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeInt(score.get());
            objectOutput.writeInt(meilleurScore.get());

        }

        @Override
        public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
            score.set(objectInput.readInt());
            meilleurScore.set(objectInput.readInt());
    }

        @Override
        public String toString() {
            return "Partie{" +
                    "listeObstacle=" + listeObstacle +
                    ", personnage=" + personnage +
                    ", score=" + score +
                    ", meilleurScore=" + meilleurScore +
                    '}';
        }
    }
