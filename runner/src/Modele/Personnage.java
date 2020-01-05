package Modele;

public abstract class Personnage {

    private static final int hauteur=constantes.getHauteurPersonnage();
    private static final int largeur=constantes.getLargeurPersonnage();
    private boolean enSaut;
    private boolean enBas;
    private static final int longueurSaut=constantes.getLongueurSaut();
    private static final int hauteurSaut=constantes.getHauteurSaut();
    private int positiony;
    private int positionx;

    public Personnage(int positiony,int positionx) {
        this.setEnSaut(false);
        this.setEnBas(false);
        this.setPositionx(positionx);
        this.setPositiony(positiony);
    }


    public void sauter(){
        this.setPositiony(this.getPositiony()+50);
        this.setEnSaut(true);
    }

    public int getHauteur() {
        return hauteur;
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


    public int getHauteurSaut() {
        return hauteurSaut;
    }


    public int getPositiony() {
        return positiony;
    }

    public void setPositiony(int positiony) {
        this.positiony = positiony;
    }

    public int getPositionx() {
        return positionx;
    }

    public void setPositionx(int positionx) {
        this.positionx = positionx;
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "enSaut=" + enSaut +
                ", enBas=" + enBas +
                ", positiony=" + positiony +
                ", positionx=" + positionx +
                '}';
    }
}
