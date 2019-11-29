package Modele;

public abstract class Personnage {

   private int Taille;
    private boolean enSaut;
    private boolean enBas;
    private int longueurSaut;

    public Personnage(int taille, boolean enSaut, boolean enBas, int longueurSaut) {
        Taille = taille;
        this.enSaut = enSaut;
        this.enBas = enBas;
        this.longueurSaut = longueurSaut;
    }

    public int getTaille() {
        return Taille;
    }

    public void setTaille(int taille) {
        Taille = taille;
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
}
