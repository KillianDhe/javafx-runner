package Vue;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ObstacleCarreView extends ObstacleView {

    private int Cote;
    private Rectangle Carre ;

    ObstacleCarreView(int Cote, Color couleur){
        super(Cote,Cote,couleur);
        this.Cote=Cote;
        Carre = new Rectangle(Cote,Cote);
    }


}
