package Modele;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Personnage {

    /**
     * booléen , true si le personnage est en train de sauter
     */
    private boolean enSaut;

    /**
     * la position verticale du personnage dans la vue , il ne bougera pas de gauche a droite
     */
    private static final double positionX= Constantes.getPosPerso();

    /**
     * Proprieté de double (et ses getter/setter) , la position Y du personnage , la vue va se binder dessus pour mettre a jour sa position y lorsque le personnage saute
     */
    public DoubleProperty positionY=new SimpleDoubleProperty();
    public Double getPositionY() {return positionY.get();}
    public DoubleProperty positionYProperty() {return positionY;}
    public void setPositionY(Double positionY) {this.positionY.set(positionY);}

    /**
     * velocité du personnage , utilisée pour le saut
     */
    private double velocite = 0;


    /**
     * constructeur de personnage
     * set le booléen en saut a false , et la position y du personnage a la hauteur de la piste , pour qu'il soit dessus
     */
    public Personnage() {
        this.enSaut=false;
        positionY.setValue(Constantes.getHauteurPiste());
    }

    /**
     * verifie si le personnage est en train de sauter
     * @return enSaut qui est à true si il saute , false sinon
     */
    public boolean isEnSaut() {
        return enSaut;
    }

    /**
     * getter de la positionX
     * @return l'attribut positionX
     */
    public static double getPositionX() {
        return positionX;
    }

    /**
     * getter de la velocité
     * @return l'ttribut velocite
     */
    public double getVelocite() {
        return velocite;
    }

    /**
     * setter de la velocité
     * @param velocite la vélocité a definir
     */
    public void setVelocite(double velocite) {
        velocite = velocite;
    }

    /**
     * fait sauter le personnage , set une velocité et le booleen enSaut a true
     */
    public void sauter(){
        if(!enSaut)
        {
            velocite=120;
            enSaut=true;
        }

    }

    /**
     * raffraichie la position du personnage
     * il monte lorsque la velocité est positive , puis il descend lorsquelle est negative
     * la velocite decremente au fur et a mesure
     * le personnage s'arrete si il revient a sa position initialse , il n'est plus en saut.
     * @param dt difference de temps entre l'entree et la sortie de l'animationtimr
     */
    public void refreshPosition(double dt) {

       positionY.setValue(positionY.get()-velocite*dt);
       if (enSaut) {
           velocite=velocite-40*dt;
       }
       if(positionY.getValue()> Constantes.getHauteurPiste())
       {
           velocite=0;
           positionY.setValue(Constantes.getHauteurPiste());
           enSaut=false;
       }
    }

}