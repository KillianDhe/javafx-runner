package Modele;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class  Obstacle {


    private final IntegerProperty positionX = new SimpleIntegerProperty();
    public Integer getPositionX() {return positionX.get();}
    public IntegerProperty positionXProperty() {return positionX;}
    public void setPositionX(Integer positionX) {this.positionX.set(positionX);}

    private int positionY;
    private int largeur;
    private int hauteur;

    public Obstacle(int positionX, int positionY,int largeur,int hauteur) {
        this.positionX.set(positionX);
        this.positionY = positionY;
        this.hauteur=hauteur;
        this.largeur=largeur;
    }

    @Override
    public String toString() {
        return "Obstacle{" +
                "positionX=" + positionX +
                ", positionY=" + positionY +
                ", largeur=" + largeur +
                ", hauteur=" + hauteur +
                '}';
    }


    public int getPositionY() {
        return positionY;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;    }
}
