package Modele;

public class ObstacleCarre extends Obstacle {
    private int cote;

    public ObstacleCarre(int positionX, int positionY, int cote) {
        super(positionX, positionY,cote,cote);
        this.cote = cote;
    }

    public int getCote() {
        return cote;
    }

    public void setCote(int cote) {
        this.cote = cote;
    }

    public void move(){
        positionXProperty().set((positionXProperty().getValue())-1);
    }

}