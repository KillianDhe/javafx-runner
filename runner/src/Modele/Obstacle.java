package Modele;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class  Obstacle {

    /**
     * booléen définissant si l'obstacle est sur l'écran ou non (sortie par la gauche)
     */
    public boolean isOnScreen = true ;
    /**
     * propriété double pour la position latérale d'objet , la vue va se binder dessus pour afficher l'obstacle a la bonne position
     */
    private final SimpleDoubleProperty positionX = new SimpleDoubleProperty();
    public double getPositionX() {return positionX.get();}
    public DoubleProperty positionXProperty() {return positionX;}
    public void setPositionX(Integer positionX) {this.positionX.set(positionX);}

    /**
     * la position horizontale de l'obstacle
     */
    private int positionY;

    private int largeur;
    private int hauteur;


    /**
     * constructeur d'obstacle replissant les champs positionX,positionY,largeur et hauteur
     * @param positionX la position x que l'on veut attribuer
     * @param positionY la position y que l'on veut attribuer
     * @param largeur la largeur que l'on veut ttribuer
     * @param hauteur la hauteur que l'on veut attribuer
     */
    public Obstacle(double positionX, int positionY, int largeur, int hauteur) {
        this.positionX.set(positionX);
        this.positionY = positionY;
        this.hauteur=hauteur;
        this.largeur=largeur;
    }


    /**
     * déplace tout les obstacles vers la gauche
     * @param dt différence de temps entre la sortie et l'entrée de l'animation timer
     */
    public abstract void move(double dt);

    /**
     * getter position Y
     * @return la poisition y
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     * getter de la largeur
     * @return la largeur
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * setter de la largeur
     * @param largeur la valeur que lon veut attribuer au champs largeur
     */
    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    /**
     * getter de la hauteur
     * @return l'entier hauteur
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * setter de la hauteur
     * @param hauteur la valeur que lon veut attribuer au champs hauteur
     */
    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    /**
     * setter de la position Y
     * @param positionY la valeur que lon veut attribuer au champs positionY
     */
    public void setPositionY(int positionY) {
        this.positionY = positionY;


    }
    /**
     * redéfinition de la méthode toString affichant tous les champs , utile pour tester le code
     * @return
     */
    @Override
    public String toString() {
        return "Obstacle{" +
                "positionX=" + positionX +
                ", positionY=" + positionY +
                ", largeur=" + largeur +
                ", hauteur=" + hauteur +
                '}';
    }
}
