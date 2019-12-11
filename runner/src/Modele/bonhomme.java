package Modele;

import javafx.scene.paint.Color;

public class bonhomme extends Personnage
{
    private Color couleur;


    public bonhomme(Color couleur,int positiony,int positionx) {
        super(positiony,positionx);
        this.couleur = couleur;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }


    @Override
    public String toString() {
        return super.toString() +"bonhomme{" +
                "couleur=" + couleur +
                '}';
    }
}
