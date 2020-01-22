package Modele;

public class ObstacleRond extends Obstacle {

    private int diametre;
    private double velocityX = 50;

    public ObstacleRond(double positionX, int positionY, int diametre){
        super(positionX,positionY,diametre,diametre);
        this.diametre=diametre;

    }

    @Override
    public void move(double dt) {
        positionXProperty().set(positionXProperty().getValue()-(velocityX*dt));
        if(positionXProperty().getValue() + diametre <0){
            this.isOnScreen=false;
        }
    }

    public int getDiametre() {
        return diametre;
    }

    public double getVelocityX() {
        return velocityX;
    }


}
