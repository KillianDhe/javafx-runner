package Modele;

public class GroupeObstacle {

    private int positionx;
    private int positiony;
    private int largeur;
    private int largeurMax;


    public GroupeObstacle(int positionx, int positiony, int largeur, int largeurMax) {
        this.setPositionx(positionx);
        this.setPositiony(positiony);
        this.setLargeur(largeur);
        this.setLargeurMax(largeurMax);
    }


    public int getPositionx() {
        return positionx;
    }

    public void setPositionx(int positionx) {
        this.positionx = positionx;
    }

    public int getPositiony() {
        return positiony;
    }

    public void setPositiony(int positiony) {
        this.positiony = positiony;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getLargeurMax() {
        return largeurMax;
    }

    public void setLargeurMax(int largeurMax) {
        this.largeurMax = largeurMax;
    }
}
