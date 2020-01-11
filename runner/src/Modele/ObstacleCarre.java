package Modele;

public class ObstacleCarre extends Obstacle {
    private int cote;
    private double velocityX = 50;

    public ObstacleCarre(double positionX, int positionY, int cote) {
        super(positionX, positionY,cote,cote);
        this.cote = cote;
    }

    public int getCote() {
        return cote;
    }

    public void setCote(int cote) {
        this.cote = cote;
    }

    public void move(double dt){
        positionXProperty().set(positionXProperty().getValue()-(velocityX*dt));
        if(positionXProperty().getValue() + cote <0){
            this.isOnScreen=false;
        }
    }


}