package Modele;

public class Personnage {


    private boolean enSaut;
    private boolean enBas;
    private static final int longueurSaut=constantes.getLongueurSaut();
    private static final int hauteurSaut=constantes.getHauteurSaut();


    public Personnage() {
        this.setEnSaut(false);
        this.setEnBas(false);
    }


    public void sauter(){
       // this.setPositiony(this.getPositiony()+50);
        this.setEnSaut(true);
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


}
