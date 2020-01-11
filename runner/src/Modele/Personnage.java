package Modele;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Personnage {


    private boolean enSaut;
    private boolean enBas;
    private static final double positionX=constantes.getPosPerso();

    public DoubleProperty positionY=new SimpleDoubleProperty();
    public Double getPositionY() {return positionY.get();}
    public DoubleProperty positionYProperty() {return positionY;}
    public void setPositionY(Double positionY) {this.positionY.set(positionY);}


    private static final int longueurSaut=constantes.getLongueurSaut();
    private static final int hauteurSaut=constantes.getHauteurSaut();
    private double velocite = 0;

    public Personnage() {
        this.setEnSaut(false);
        this.setEnBas(true);
        positionY.setValue(constantes.getHauteurPiste());
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

    public double getVelocite() {
        return velocite;
    }

    public void setVelocite(double velocite) {
        velocite = velocite;
    }



    public void sauter(){
/*
        if (this.getPositionY() < constantes.getHauteurPiste()){
            this.setPositionY(this.getPositionY() + this.getVelocite());
            this.setVelocite(this.getVelocite() + 5);
        }

        if(this.getPositionY() == constantes.getHauteurPiste()){
            this.enSaut = false;
            this.setVelocite(-90);
        }
*/
    velocite=100;
    enSaut=true;
        System.out.println("salam ca  a sauté et mis la velocité a:"+velocite);


    }

    public void refreshPosition(long dt) {

        positionY.setValue(positionY.get()+velocite*dt);
        velocite=velocite-10;
      //  System.out.println("position y :"+this.positionY.getValue());
        if(positionY.getValue()<constantes.getHauteurPiste())
        {
            velocite=0;
            positionY.setValue(constantes.getHauteurPiste());
        }
    }
}
