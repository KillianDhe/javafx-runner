package Modele;

public abstract class Personnage {

    private int taille;
    private boolean enSaut;
    private boolean enBas;
    private int longueurSaut;
    private int hauteurSaut;

    public Personnage(int taille, boolean enSaut, boolean enBas, int longueurSaut, int hauteurSaut) {
        this.setTaille(taille);
        this.setEnSaut(enSaut);
        this.setEnBas(enBas);
        this.setLongueurSaut(longueurSaut);
        this.setHauteurSaut(hauteurSaut);
    }
    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        taille = taille;
    }

    public boolean isEnSaut() {
        return enSaut;
    }

    public void setEnSaut(boolean enSaut) {
        this.enSaut = enSaut;
    }

    public boolean isEnBas() {
        return enBas;
    }

    public void setEnBas(boolean enBas) {
        this.enBas = enBas;
    }

    public int getLongueurSaut() {
        return longueurSaut;
    }

    public void setLongueurSaut(int longueurSaut) {
        this.longueurSaut = longueurSaut;
    }

    public int getHauteurSaut() {
        return hauteurSaut;
    }

    public void setHauteurSaut(int hauteurSaut) {
        this.hauteurSaut = hauteurSaut;
    }


}
