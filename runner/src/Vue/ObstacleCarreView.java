package Vue;

import Modele.ObstacleCarre;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class ObstacleCarreView extends Parent {

    /**
     * un obstacle carre
     */
    private Modele.ObstacleCarre obstacleCarre;

    /**
     * un rectangle
     */
    private Rectangle rectangle;

    /**
     * proprieté Integer (et ses getter,setter) position horizontale de l'obstacle carre view , bindé sur la position de l'obstacle du modele
     */
    private final IntegerProperty positionX = new SimpleIntegerProperty();
    public Integer getPositionX() {return positionX.get();}
    public IntegerProperty positionXProperty() {return positionX;}
    public void setPositionX(Integer positionX) {this.positionX.set(positionX);}

    /**
     * constructeur d'obstaclecarreView , remplit les propriété de rectangle avec les propriétées de obstacleCarre
     * Bind la position du rectangle avec la position de l'obstacleCarre
     * @param obstacleCarre on se sert de ses champs (largeur , position ect) pour définir le rectangle
     * @param image l'image a utiliser sur le rectangle , l'image du personnage
     */
    public ObstacleCarreView(ObstacleCarre obstacleCarre, Image image) {
        this.obstacleCarre = obstacleCarre;
        rectangle=new Rectangle();
        rectangle.setFill(new ImagePattern(image));
        rectangle.setWidth(obstacleCarre.getLargeur());
        rectangle.setHeight(obstacleCarre.getHauteur());
        positionX.bind(obstacleCarre.positionXProperty());
        rectangle.xProperty().bind(obstacleCarre.positionXProperty());
        rectangle.setY(obstacleCarre.getPositionY());
        this.getChildren().add(rectangle);
    }


    /**
     * getter de rectangle
     * @return le rectangle
     */
    public Rectangle getRectangle() {
        return rectangle;
    }

    /**
     * getter de l'obstacleCarre
     * @return obstacleCarre
     */
    public ObstacleCarre getObstacleCarre() {
        return obstacleCarre;
    }
}