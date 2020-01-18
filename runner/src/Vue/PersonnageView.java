package Vue;

import Modele.Personnage;
import Modele.Constantes;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class PersonnageView extends Parent {

    /**
     * Un personnage du modele
     */
    private Modele.Personnage personnage;

    /**
     * un rectangle (la representation d'un personnage)
     */
    private Rectangle rectangle;

    /**
     * la hauteur du personnage
     */
    private static final int hauteur= Constantes.getHauteurPersonnage();

    /**
     * la largeur du personnage
     */
    private static final int largeur= Constantes.getLargeurPersonnage();



    /**
     * la position horizontale du personnage , celui ne bouge pas horizontalement , on fixe 100
     */
    private static final int positionx=100;

    /**
     * constructeur de Personnageview
     * La position du rectangle est bindé sur la position du personnage du modele
     * on paraetre le rectangle et l'ajoute au parent
     * @param personnage le personnage du modele que l'on veut representer
     * @param image l'image du personnage , qui ets mise sur le rectangle
     */
    public PersonnageView(Modele.Personnage personnage,Image image) {
        this.personnage = personnage;
        rectangle=new Rectangle();
        rectangle.setFill(new ImagePattern(image));
        rectangle.setX(positionx);
        rectangle.yProperty().bind(personnage.positionYProperty().add(-hauteur));

        rectangle.setHeight(hauteur);
        rectangle.setWidth(largeur);
        this.getChildren().add(rectangle);
    }

    /**
     * getter du rectangle
     * @return le rectangle
     */
    public Rectangle getRectangle() {
        return rectangle;
    }

    /**
     * getter du Personnage du modele
     * @return le personnage (du modele)
     */
    public Personnage getPersonnage() {
        return personnage;
    }


}
