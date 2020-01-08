package Vue;

import Modele.Obstacle;
import Modele.ObstacleCarre;
import Modele.constantes;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class ObstacleCarreView {

    private Modele.ObstacleCarre obstacleCarre;
    private Rectangle rectangle;

    public ObstacleCarreView(ObstacleCarre obstacleCarre, Image image) {
        this.obstacleCarre = obstacleCarre;
        rectangle=new Rectangle();
        rectangle.setFill(new ImagePattern(image));
        rectangle.setWidth(obstacleCarre.getLargeur());
        rectangle.setHeight(obstacleCarre.getHauteur());
        rectangle.setX(obstacleCarre.getPositionX());
        rectangle.setY(obstacleCarre.getPositionY());
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}