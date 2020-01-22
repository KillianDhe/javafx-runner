package Vue;

import Modele.ObstacleRond;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class ObstacleRondView extends Parent {

    private Modele.ObstacleRond obstacleRond;
    private Circle circle;

    private final IntegerProperty positionX = new SimpleIntegerProperty();
    public Integer getPositionX() {return positionX.get();}
    public IntegerProperty positionXProperty() {return positionX;}
    public void setPositionX(Integer positionX) {this.positionX.set(positionX);}

    public ObstacleRondView(ObstacleRond obstacleRond, Image image) {
        this.obstacleRond = obstacleRond;
        circle=new Circle();
        circle.setFill(new ImagePattern(image));
        circle.setRadius(obstacleRond.getDiametre());
        positionX.bind(obstacleRond.positionXProperty());
        circle.centerXProperty().bind(obstacleRond.positionXProperty());
        circle.setCenterY(obstacleRond.getPositionY()+obstacleRond.getDiametre());
        this.getChildren().add(circle);
    }

    public ObstacleRond getObstacleRond() {
        return obstacleRond;
    }

    public Circle getCircle() {
        return circle;
    }
}
