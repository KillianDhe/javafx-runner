package Vue;

import Modele.Obstacle;
import Modele.ObstacleCarre;
import Modele.constantes;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class ObstacleCarreView extends Parent {

    private Modele.ObstacleCarre obstacleCarre;
    private Rectangle rectangle;

    private final IntegerProperty positionX = new SimpleIntegerProperty();
    public Integer getPositionX() {return positionX.get();}
    public IntegerProperty positionXProperty() {return positionX;}
    public void setPositionX(Integer positionX) {this.positionX.set(positionX);}

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



    public Rectangle getRectangle() {
        return rectangle;
    }

    public ObstacleCarre getObstacleCarre() {
        return obstacleCarre;
    }
}