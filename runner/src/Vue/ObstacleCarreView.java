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

    public int getCote() {
        return Cote;
    }

    public void setCote(int cote) {
        Cote = cote;
    }

    public Rectangle getCarre() {
        return Carre;
    }

    public void setCarre(Rectangle carre) {
        Carre = carre;
    }
}
