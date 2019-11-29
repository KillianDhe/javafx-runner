package Modele;

public class ObstacleRond extends Obstacle {

    private int diametre;


    public ObstacleRond(int diametre) {
        this.setDiametre(diametre);
    }

    public int getDiametre() {
        return diametre;
    }

    public void setDiametre(int diametre) {
        this.diametre = diametre;
    }
}
