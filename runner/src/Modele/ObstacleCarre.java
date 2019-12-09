package Modele;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ObstacleCarre extends Obstacle {

    private int cote;

    public ObstacleCarre(int cote,Color couleur){
        super(cote,cote,couleur);
        this.setCote(cote);
    }

    public int getCote() {
        return cote;
    }

    public void setCote(int cote) {
        this.cote = cote;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
