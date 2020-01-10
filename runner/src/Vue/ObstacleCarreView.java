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
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class ObstacleCarreView {

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
        rectangle.setX((obstacleCarre.positionXProperty().get()));
        rectangle.setY(obstacleCarre.getPositionY());

        positionX.addListener( new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
               rectangle.setX((newValue.doubleValue()));
            }
        } );


    }



    public Rectangle getRectangle() {
        return rectangle;
    }

    public ObstacleCarre getObstacleCarre() {
        return obstacleCarre;
    }
}