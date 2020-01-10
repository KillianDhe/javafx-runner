package Vue;

import Modele.constantes;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class PersonnageView extends Parent {

    private Modele.Personnage personnage;
    private Rectangle rectangle;
    private static final int hauteur= constantes.getHauteurPersonnage();
    private static final int largeur=constantes.getLargeurPersonnage();
    private static final int positiony=constantes.getHauteurPiste()-hauteur;
    private static final int positionx=100;

    public PersonnageView(Modele.Personnage personnage,Image image) {
        this.personnage = personnage;
        rectangle=new Rectangle();
        rectangle.setFill(new ImagePattern(image));
        rectangle.setX(positionx);
        rectangle.setY(positiony);
        rectangle.setHeight(hauteur);
        rectangle.setWidth(largeur);
        this.getChildren().add(rectangle);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }


}
