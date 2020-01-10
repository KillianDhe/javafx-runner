package Modele;

public class Personnage {


    private boolean enSaut;
    private boolean enBas;
    private static final double positionX=constantes.getPosPerso();
    private double positionY=constantes.getHauteurPiste();
    private static final int longueurSaut=constantes.getLongueurSaut();
    private static final int hauteurSaut=constantes.getHauteurSaut();
    private double Velocite = 0;

    public Personnage() {
        this.setEnSaut(false);
        this.setEnBas(true);
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

    public static double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public double getVelocite() {
        return Velocite;
    }

    public void setVelocite(double velocite) {
        Velocite = velocite;
    }



    public void sauter(long tps){
        if (this.getPositionY() < constantes.getHauteurPiste()){
            this.setPositionY(this.getPositionY() + this.getVelocite());
            this.setVelocite(this.getVelocite() + 5);
        }

        if(this.getPositionY() == constantes.getHauteurPiste()){
            this.enBas = true;
            this.enSaut = false;
            this.setVelocite(-90);
        }

    }
}
