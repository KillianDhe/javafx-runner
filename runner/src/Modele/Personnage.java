package Modele;

public abstract class Personnage {

    private int taille;
    private boolean enSaut;
    private boolean enBas;
    private int longueurSaut;
    private int hauteurSaut;
    private int positiony;
    private int positionx;

    public Personnage(int positiony,int positionx) {
        this.setTaille(constantes.getTaillePersonnage());
        this.setEnSaut(false);
        this.setEnBas(false);
        this.setLongueurSaut(constantes.getLongueurSaut());
        this.setHauteurSaut(constantes.getHauteurSaut());
        this.setPositionx(positionx);
        this.setPositiony(positiony);
    }


    public void sauter(){
        this.setPositiony(this.getPositiony()+50);
        this.setEnSaut(true);
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
                "taille=" + taille +
                ", enSaut=" + enSaut +
                ", enBas=" + enBas +
                ", longueurSaut=" + longueurSaut +
                ", hauteurSaut=" + hauteurSaut +
                ", positiony=" + positiony +
                ", positionx=" + positionx +
                '}';
    }
}
