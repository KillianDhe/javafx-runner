package Modele;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ObstacleCarre extends Obstacle {

    private int cote;

    public ObstacleCarre(int cote, Color couleur,int largeur, int  ){
        super()
        this.setCote(cote);
        this.setCouleur(couleur);

    }

    public int getCote() {
        return cote;
    }

    public void setCote(int cote) {
        this.cote = cote;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public int getLargeur(){
        return cote;
    }

}
