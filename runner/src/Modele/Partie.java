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
        /**
         * UID unique nécessair epour la serialisation
         */
        private static final long serialVersionUID = 4683561297105055078L;

        /**
         * liste observable d'obstacles , qui va contenir les obstacles a afficher , génerées aleatoirement
         */
    private  ObservableList<Obstacle> listeObstacle= FXCollections.observableArrayList();

        /**
         * Le personnage de notre partie
         */
    private  Personnage personnage;

        /**
         *  Propriété integer (avec son setter et getter) , la vue va se binder dessus pour afficher le meilleur score effectué
         */
    private final IntegerProperty score = new SimpleIntegerProperty();
    public Integer getScore() {return score.get();}
    public IntegerProperty scoreProperty() {return score;}
    public void setScore(Integer score) {this.score.set(score);}

        /**
         * Propriété integer (avec son setter et getter) , la vue va se binder dessus pour afficher le score
         */
    private final IntegerProperty meilleurScore = new SimpleIntegerProperty();
    public Integer getMeilleurScore() {return meilleurScore.get();}
    public IntegerProperty meilleurScoreProperty() {return meilleurScore;}
    public void setMeilleurScore(Integer score) {this.meilleurScore.set(score);}

        /**
         * constructeur de la classe Partie  , instancie un nouveau personnage , initialise le score et meilleiur score à 0 , ajoute un obstacle à la liste.
         */
        public Partie() {
        personnage=new Personnage();
            score.set(0);
            meilleurScore.set(0);
            listeObstacle.add(GenerateurObstacle.genererObstacle(null));
        }


        /***
         * getter de la liste observable d'obstacles
         * @return la liste observale d'obstacle de cette classe
         */
    public ObservableList<Obstacle> getListeObstacle() {
        return listeObstacle;
    }

        /**
         * getter de personnage
         * @return le personnage de cette classe partie
         */
    public Personnage getPersonnage() {
        return personnage;
    }

        /**
         * setter de personnage
         * @param personnage le personnage que l'on veut attribuer a cette classe partie
         */
    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }

        /**
         * efface tous les obstcales qui ne sont plus sur l'écran (a gauche)
         * incrémente le score de 1 a chaque effacement
         */
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

        /**
         * incrémente le score de 1
         */
    public void incrementerScore()
    {
        setScore(getScore()+1);
        if(getScore()>getMeilleurScore())
            setMeilleurScore(getScore());
    }

        /**
         * efface la liste d'obstacle ( pour quand on perds)
         * on pourrait le faire dans la fonction rejouer en fait
         */
    public void perdre()
    {
        listeObstacle.clear();
      /*  setScore(0);*/
    }

        /**
         * remet le score a 0 , pour lorsque on relance une partie
         */
    public void rejouer()
    {
        setScore(0);
    }

        /**
         * serialize le score et le meilleur score
         * @param objectOutput le flux ou l'on érit l'objet
         * @throws IOException exception si la serialisation s'est mal passée
         */
        @Override
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeInt(score.get());
            objectOutput.writeInt(meilleurScore.get());

        }

        /**
         *
         * @param objectInput le flux d'ou on lit les données
         * @throws IOException exception si la déserialisation s'est mal passée
         */
        @Override
        public void readExternal(ObjectInput objectInput) throws IOException {
            score.set(objectInput.readInt());
            meilleurScore.set(objectInput.readInt());
    }

        /**
         * redéfinition de la méthode toString pour pouvoir tester , en affichant tous les attributs
         * @return
         */
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
