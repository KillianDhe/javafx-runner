package Modele;

public abstract class  Obstacle {
    private int positionX;
    private int positionY;
    private int largeur;
    private int hauteur;

    public Obstacle(int positionX, int positionY,int largeur,int hauteur) {
        this.positionX = positionX;
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

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
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
