package Vue;

import Modele.Personnage;
import Modele.constantes;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class PersonnageView extends Parent {

    private Modele.Personnage personnage;
    private Rectangle rectangle;
    private static final int hauteur= constantes.getHauteurPersonnage();
    private static final int largeur=constantes.getLargeurPersonnage();

    public DoubleProperty positionY=new SimpleDoubleProperty();
    public Double getPositionY() {return positionY.get();}
    public DoubleProperty positionYProperty() {return positionY;}
    public void setPositionY(Double positionY) {this.positionY.set(positionY);}

    private static final int positionx=0;

    public PersonnageView(Modele.Personnage personnage,Image image) {
        positionY.bind(personnage.positionYProperty());
        this.personnage = personnage;
        rectangle=new Rectangle();
        rectangle.setFill(new ImagePattern(image));
        rectangle.setX(positionx);
        rectangle.yProperty().bind(personnage.positionYProperty().add(-hauteur));

        rectangle.setHeight(hauteur);
        rectangle.setWidth(largeur);
        this.getChildren().add(rectangle);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Personnage getPersonnage() {
        return personnage;
    }


}
