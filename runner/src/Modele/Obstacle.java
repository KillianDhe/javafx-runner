package Modele;

import javafx.scene.paint.Color;

public abstract class Obstacle{

    private int hauteur;
    private int Largeur;
    private Color couleur;

    public Obstacle(int hauteur, int largeur, Color couleur) {
        this.setHauteur(hauteur);
        this.setLargeur(largeur);
        this.setCouleur(couleur);
    }

    public int getLargeur() {
        return Largeur;
    }

    public void setLargeur(int largeur) {
        if (largeur>constantes.getLongueurObstacle())
            this.Largeur=constantes.getLongueurObstacle();
        else Largeur = largeur;
    }


    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        if (hauteur>constantes.getHauteurObstacle())
            this.hauteur=constantes.getLongueurGroupeObstacle();
        else this.hauteur = hauteur;
    }

    @Override
    public String toString() {
        return "Obstacle{" +
                "hauteur=" + hauteur +
                ", Largeur=" + Largeur +
                ", couleur=" + couleur +
                '}';
    }
}
