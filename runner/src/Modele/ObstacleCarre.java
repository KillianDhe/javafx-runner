package Modele;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ObstacleCarre extends Obstacle {

    private int cote;
    private Color couleur;

    public Rectangle creerObstacleCarre(){
        Rectangle obstacle = new Rectangle();
        obstacle.setX(50);
        obstacle.setY(50);
        obstacle.setHeight(this.cote);
        obstacle.setWidth(this.cote);
        return obstacle;
    }
}
