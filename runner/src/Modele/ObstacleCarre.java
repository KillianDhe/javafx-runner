package Modele;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ObstacleCarre extends Obstacle {

    private int cote;

    public ObstacleCarre(int cote,Color couleur){
        super.setCouleur(couleur);
        super.setLargeur(cote);
        super.setHauteur(cote);
        this.setCote(cote);
    }

    public int getCote() {
        return cote;
    }

    public void setCote(int cote) {
        this.cote = cote;
    }



}
