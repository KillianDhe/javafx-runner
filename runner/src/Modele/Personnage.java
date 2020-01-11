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
        if(!enSaut)
        {
            velocite=100;
            enSaut=true;
        }

    }

    public void refreshPosition(double dt) {

       positionY.setValue(positionY.get()-velocite*dt);
       if (enSaut) {
           velocite=velocite-1;
       }

       if(positionY.getValue()>constantes.getHauteurPiste())
       {
           velocite=0;
           positionY.setValue(constantes.getHauteurPiste());
           enSaut=false;
       }

    }
}