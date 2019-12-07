package Modele;

import javafx.scene.paint.Color;

public class ObstacleRond extends Obstacle{

    private int diametre;


    public ObstacleRond(int diametre,int largeur, Color couleur) {
        super(largeur,couleur);
        this.setDiametre(diametre);
    }

    public int getDiametre() {
        return diametre;
    }

    public void setDiametre(int diametre) {
        this.diametre = diametre;
    }


        public int getLargeur(){
            return diametre;
        }

}
