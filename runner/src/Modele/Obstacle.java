package Modele;

public abstract class Obstacle{

    private int Largeur;
    private int hauteurmax;
    private Color couleur;

    public Obstacle(int largeur, Color couleur) {
        Largeur = largeur;
        this.couleur = couleur;
    }

    public int getLargeur() {
        return Largeur;
    }

    public void setLargeur(int largeur) {
        Largeur = largeur;
    }

    public int getHauteurmax() {
        return hauteurmax;
    }

    public void setHauteurmax(int hauteurmax) {
        this.hauteurmax = hauteurmax;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
}
